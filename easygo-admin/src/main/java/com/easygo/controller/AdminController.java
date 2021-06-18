package com.easygo.controller;

import com.easygo.api.AdminClient;
import com.easygo.api.LoginlogClient;
import com.easygo.pojo.Admin;
import com.easygo.pojo.Loginlog;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 16:00
 * @Description
 */
@Controller
@Scope("prototype")
public class AdminController {

    @Autowired
    AdminClient adminClient;

    @Autowired
    LoginlogClient loginlogClient;

    /**
     * 异步获取登录日志
     * @param session
     * @return
     */
    @RequestMapping("/getLoginlogs")
    @ResponseBody
    public List<Loginlog> getLoginlogs(HttpSession session){
        // 获取登录的用户
        Admin admin = (Admin) session.getAttribute("admin1");
        List<Loginlog> myLoginlogs = loginlogClient.getMyLoginlogs(admin.getUsername());
        return myLoginlogs;
    }

    @RequestMapping("/admin_logout")
    public String adminLogout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/admin_login")
    @ResponseBody
    public MessageResults adminLogin(Admin admin,String ip,String city, HttpSession session){
        System.out.println("IP"+ip);
        System.out.println("city"+city);
        // 获取到用户登录的真实IP和城市  多种做法
        // 1.获取到IP之后，调用WebService，查询IP对应的城市(功能更强大)
        // 2.直接JS前端调用接口（现在适合使用）
        MessageResults results=null;
        Admin admin1 = adminClient.adminLogin(admin);
        System.out.println("当前登录的用户是："+admin1);
        if (admin1!=null){
            if ("1".equals(admin1.getStatus())){

                // 登录的日志对象
                Loginlog loginlog = new Loginlog(ip, admin.getUsername(), city);
                loginlogClient.addLoginlog(loginlog);

                session.setAttribute("admin1",admin1);
                results=new MessageResults(200,"登录成功");
            }else {
                results=new MessageResults(303,"该用户已被冻结，请联系管理员！");
            }
        }else {
            results=new MessageResults(500,"登录失败");
        }
        return results;
    }
}

package com.easygo.controller;

import com.easygo.api.UsersClient;
import com.easygo.pojo.Users;
import com.easygo.utils.MessageResults;
import com.easygo.utils.SendMessage;
import com.easygo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Lym
 * @Date 2020/4/21 15:29
 * @Description
 */
@Controller
@Scope("prototype")
public class UsersController {

    @Autowired
    UsersClient usersClient;

    @Value("${salt}")
    String salt;

    /**
     * 用户注册
     * @param users
     * @return
     */
    @RequestMapping("/users_add")
    @ResponseBody
    public MessageResults users_add(Users users,String userMessageCode,HttpSession session){
        System.out.println("用户输入的验证码："+userMessageCode);
        //正确的验证码
        String sendMsg = (String) session.getAttribute("sendMsg");

        MessageResults results=null;
        //手机号
        String phone = users.getPhone();
        System.out.println("盐："+salt);
        try {
            if (sendMsg.equals(userMessageCode)){
                String password= StringUtil.MD5Encode(users.getPassword()+salt);
                users.setPassword(password);
                Integer count = usersClient.users_add(users);
                if (count>0){
                    results=new MessageResults(200,"注册成功");
                }else {
                    results=new MessageResults(500,"注册失败");
                }
            }else {
                results=new MessageResults(505,"验证码输入有误！！！");
            }
        }catch (Exception e){
            results=new MessageResults(500,"注册失败");
            e.printStackTrace();
        }
        return results;
    }

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @RequestMapping("/sendMessage/{phone}")
    @ResponseBody
    public MessageResults sendMessage(@PathVariable("phone") String phone, HttpSession session){
        MessageResults results=null;
        try {
            //调用短信接口，并返回验证码（比对是否正确）
            Integer sendMsg = SendMessage.sendMsg(phone);
            session.setAttribute("sendMsg",sendMsg+"");
            results=new MessageResults(200,"短信发送成功");
        }catch (Exception e){
            results=new MessageResults(500,"短信发送失败");
            e.printStackTrace();
        }
        return results;
    }

}

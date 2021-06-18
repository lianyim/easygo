package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.api.ContentClient;
import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.FastDFSClient;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 19:53
 * @Description
 */
@Controller
@Scope("prototype")
public class ContentController {

    @Autowired
    ContentClient contentClient;

    @Autowired
    ContentCategoryClient contentCategoryClient;

    //操作Redis
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // 更新广告
    @RequestMapping("/content_update")
    @ResponseBody
    public MessageResults content_update(Content content) throws Exception{

        // 图片地址
        String pic = content.getPic();
        // 数据库的图片地址
        String oldPic = contentClient.getContentById(content.getId()).getPic();
        if (!oldPic.equals(pic)){
            // 表示图片已修改，删除FastDFS服务器中的图片
            // 获取工具类，配置文件
            //FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            //fastDFSClient.deleteFile("","group1");
        }

        MessageResults results = null;
        System.out.println("要更新之后的对象是："+content);
        Integer i = contentClient.updateContent(content);
        if (i>0){
            // 在此处更新时：删除缓存，或更新缓存数据
            // 把广告列表ID写到配置文件中
            List<Content> lunbo_contents = contentClient.getContentByCategoryId(1);
            // 把查询到的数据，存入一份到缓存
            redisTemplate.opsForValue().set("lunbo_contents_key",lunbo_contents);
            results=new MessageResults(200,"更新成功");
        }else {
            results=new MessageResults(500,"更新失败");
        }
        return results;
    }

    //跳转更新页面
    @RequestMapping("/content_goupdate")
    @ResponseBody
    public Map<String ,Object> content_goupdate(Integer id){
        // 广告回显的对象
        Content content = contentClient.getContentById(id);
        // 查询下拉框数据
        List<ContentCategory> contentCategorys = contentCategoryClient.getContentCategorys();
        HashMap<String,Object> map = new HashMap<>();
        map.put("content",content);
        map.put("contentCategorys",contentCategorys);
        return map;
    }

    // 新增广告
    @RequestMapping("/content_add")
    @ResponseBody
    public MessageResults contentAdd(Content content){
        MessageResults results = null;
        System.out.println("要新增之后的对象是："+content);
        Integer i = contentClient.addContent(content);
        if (i>0){
            // 在此处更新时：删除缓存，或更新缓存数据
            // 把广告列表ID写到配置文件中
            List<Content> lunbo_contents = contentClient.getContentByCategoryId(1);
            // 把查询到的数据，存入一份到缓存
            redisTemplate.opsForValue().set("lunbo_contents_key",lunbo_contents);
            results=new MessageResults(200,"新增成功");
        }else {
            results=new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/content_page")
    public String getContent_page(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                @RequestParam(defaultValue = "5",required = false) Integer pageSize, Model model){
        PageUtils<Content> pageUtils = contentClient.getContent_page(pageIndex, pageSize);
        System.out.println("获取到的pageUtils是："+pageUtils);
        model.addAttribute("pageUtils",pageUtils);
        return "content";
    }

    //有效无效
    @RequestMapping("/content_updateStatus")
    @ResponseBody
    public MessageResults updateStatus(Integer id, Integer status){
        MessageResults results = null;
        System.out.println("前台id："+id+" 前台status: "+status);
        int i = contentClient.updateStatus(id,status);
        if (i>0){
            results=new MessageResults(200,"更新成功");
        }else {
            results=new MessageResults(500,"更新失败");
        }
        return results;
    }

}

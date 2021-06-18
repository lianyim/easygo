package com.easygo.controller;

import com.easygo.utils.FastDFSClient;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Lym
 * @Date 2020/3/31 22:49
 * @Description  文件上传的控制器
 */
@Controller
@Scope("prototype")
public class FileUploadController {

    // 在配置文件中 图片服务器的地址
    @Value("${FILE_SERVER_URL}")
    public String FILE_SERVER_URL;

    @RequestMapping("/file_upload")
    @ResponseBody
    public MessageResults uploadImg(MultipartFile file){
        // 文件上传的逻辑代码
        // 1.获取上传的文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("上传的原始文件名是："+originalFilename);
        // 2.获取上传文件的后缀名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("文件的扩展名:"+extName);

        try {
            // 获取工具类，配置文件
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            // 上传文件，返回上传成功的地址
            String url = fastDFSClient.uploadFile(file.getBytes(), extName);
            // 还需要拼接一下全地址
            String fullPath=FILE_SERVER_URL+url;
            System.out.println("文件上传成功之后的全地址是："+fullPath);
            return new MessageResults(200,fullPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new MessageResults(500,null);
    }

}

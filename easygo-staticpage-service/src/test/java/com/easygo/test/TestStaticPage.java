package com.easygo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/19 22:32
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStaticPage {

    /**
     * 01-测试页面静态化技术的API
     */
    @Test
    public void testHtmlDemo() throws Exception{
        //1.创建一个模板加载器
        ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");  //模板所在的路径
        resolver.setSuffix(".html");  //模板的后缀

        for (int i=0;i<10;i++){
            //2.创建模板引擎
            TemplateEngine templateEngine = new TemplateEngine();
            //3.加载器加入模板引擎
            templateEngine.setTemplateResolver(resolver);
            //4.设置静态页面生成的文件地址
            FileWriter fileWriter=new FileWriter("E:/xxxooo/test"+i+".html");
            //5.创建Context对象
            Context context = new Context();
            //6.放入测试数据
            context.setVariable("message","波波语录...."+i);
            //7.生成页面
            templateEngine.process("demo",context,fileWriter);
            System.out.println("静态页面生成完毕~~~ ");
        }
    }

    /**
     * 测试对象生成模板
     */
    @Test
    public void testHtmlDemo2() throws Exception{

        Users u1 = new Users(1, "波波1", "吟诗");
        Users u2 = new Users(2, "波波2", "蹦迪");
        Users u3 = new Users(3, "波波3", "美女");
        Users u4 = new Users(4, "波波4", "还能战!!! ");

        List<Users> list=new ArrayList<Users>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

        //1.创建一个模板加载器
        ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");  //模板所在的路径
        resolver.setSuffix(".html");  //模板的后缀

        //2.创建模板引擎
        TemplateEngine templateEngine = new TemplateEngine();
        //3.加载器加入模板引擎
        templateEngine.setTemplateResolver(resolver);
        //4.设置静态页面生成的文件地址
        FileWriter fileWriter=new FileWriter("E:/xxxooo/bobo.html");
        //5.创建Context对象
        Context context = new Context();
        //6.放入测试数据,填充对象集合
        context.setVariable("list",list);
        //7.生成页面
        templateEngine.process("users",context,fileWriter);
        System.out.println("静态页面生成完毕~~~ ");
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Users implements Serializable{
    private Integer id;
    private String name;
    private String hobby;
}

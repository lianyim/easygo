package com.easygo.controller;

import com.easygo.api.ContentClient;
import com.easygo.api.ItemCatClient;
import com.easygo.pojo.Admin;
import com.easygo.pojo.Content;
import com.easygo.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lym
 * @Date 2020/3/30 21:34
 * @Description
 */
@Controller
@Scope("prototype")
public class IndexController {

    @Autowired
    ContentClient contentClient;

    @Autowired
    ItemCatClient itemCatClient;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /**
     * 首页加载
     * @param model
     * @return
     */
    @RequestMapping({"/","index"})
    public String index(Model model){
        //加载分类
        getItemCats(model);
        // 查询轮播图广告
        getContents(model);
        // 跳转首页
        return "index";
    }

    //加载商品类目
    public void getItemCats(Model model){
        //所有类目
        List<ItemCat> itemCats = itemCatClient.getItemCats();
        //所有的一级分类
        List<ItemCat> itemCats_one = extractItemCat("1", itemCats);
        //所有的二级分类
        List<ItemCat> itemCats_two = extractItemCat("2", itemCats, itemCats_one);
        //所有的三级分类
        List<ItemCat> itemCats_third = extractItemCat("3", itemCats, itemCats_two);
        //存值
        model.addAttribute("itemCats_one",itemCats_one);
        model.addAttribute("itemCats_two",itemCats_two);
        model.addAttribute("itemCats_third",itemCats_third);


    }

    //提取类目
    public List<ItemCat> extractItemCat(String type,List<ItemCat>... sourceList){
        List<ItemCat> emptyList=new ArrayList<>();
        //所有分类
        List<ItemCat> allList=sourceList[0];

        //所有一级分类
        if ("1".equals(type)){
            for (ItemCat itemCat: allList){
                if (itemCat.getParent_id().toString().equals("0")){
                    emptyList.add(itemCat);
                    if (emptyList.size()==10){
                        //由于页面无法显示全，那么只显示10个
                        break;
                    }
                }
            }
        }
        //所有二级分类
        if ("2".equals(type)){
            //所有一级分类
            List<ItemCat> itemCats_one = sourceList[1];
            for (ItemCat itemCat: itemCats_one){
                for (ItemCat item: allList){
                    if (item.getParent_id().toString().equals(itemCat.getId().toString())){
                        emptyList.add(item);
                    }
                }
            }
        }
        //所有三级分类
        if ("3".equals(type)){
            //所有二级分类
            List<ItemCat> itemCats_two = sourceList[1];
            for (ItemCat itemCat : itemCats_two) {
                for (ItemCat item : allList) {
                    if (item.getParent_id().toString().equals(itemCat.getId().toString())){
                        emptyList.add(item);
                    }
                }
            }
        }

        return emptyList;
    }



    // 加载首页上需要的广告数据
    public void getContents(Model model){
        // 先从缓存中查询，是否有缓存数据
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(ArrayList.class));
        List<Content> lunbo_contents = (ArrayList<Content>) redisTemplate.opsForValue().get("lunbo_contents_key");
        List<Content> shengxian_contents = (ArrayList<Content>) redisTemplate.opsForValue().get("shengxian_contents_key");
        if (lunbo_contents==null){
            System.out.println("缓存中没有轮播图数据.... ");
            // 轮播图广告
            // 把广告列表ID写到配置文件中
            lunbo_contents = contentClient.getContentByCategoryId(1);
            // 把查询到的数据，存入一份到缓存
            redisTemplate.opsForValue().set("lunbo_contents_key",lunbo_contents);
        }else {
            System.out.println("缓存中有轮播图数据,不用查询数据库.... ");
        }

        if (shengxian_contents==null){
            System.out.println("缓存中没有生鲜数据.... ");
            // 生鲜楼层广告
            shengxian_contents = contentClient.getContentByCategoryId(10);
            // 把查询到的数据，存入一份到缓存
            redisTemplate.opsForValue().set("shengxian_contents_key",shengxian_contents);
        }else {
            System.out.println("缓存中有生鲜数据,不用查询数据库.... ");
        }

        model.addAttribute("lunbo_contents",lunbo_contents);


        model.addAttribute("shengxian_contents",shengxian_contents);
    }

}

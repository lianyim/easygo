package com.easygo.test;

import com.easygo.client.*;
import com.easygo.pojo.*;
import com.easygo.utils.AttributeNameObject;
import com.easygo.utils.JsonUtils;
import com.easygo.utils.OrderUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/20 9:47
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProduct {

    @Autowired
    GoodsClient goodsClient;

    @Autowired
    GoodsDescClient goodsDescClient;

    @Autowired
    BrandClient brandClient;

    @Autowired
    ItemCatClient itemCatClient;

    @Autowired
    ItemClient itemClient;

    /**
     * 商品详情页静态生成
     */
    @Test
    public void createProductHtml() throws Exception{
        Goods goods = goodsClient.getGoodsById(149187842867960L);
//        Goods goods = goodsClient.getGoodsById(149187842867930L);
        System.out.println("商品对象："+goods);
        GoodsDesc goodsDesc = goodsDescClient.getGoodsDescById(goods.getId());
        System.out.println("商品详情对象："+goodsDesc);

        //商品图片集合(json数据)
        String item_images = goodsDesc.getItem_images();
        //商品图片的集合数据(貌似有问题...)
        List<OrderUrl> orderUrls = JsonUtils.parseitem_images2List(item_images);
        //品牌id
        Integer brand_id = goods.getBrand_id();
        //品牌对象
        Brand brand = brandClient.getBrandById(brand_id);
        System.out.println("品牌对象："+brand);

        //分类数据
        Integer category1_id = goods.getCategory1_id(); //一级类目id
        String name1 = itemCatClient.getItemCatById(category1_id).getName(); //一级类目名称
        Integer category2_id = goods.getCategory2_id(); //二级类目id
        String name2 = itemCatClient.getItemCatById(category2_id).getName(); //二级类目名称
        Integer category3_id = goods.getCategory3_id(); //三级类目id
        String name3 = itemCatClient.getItemCatById(category3_id).getName(); //三级类目名称

        //加载商品的规格数据
        String specification_items = goodsDesc.getSpecification_items();
        //规格的集合
        List<AttributeNameObject> attributeNameObjects = JsonUtils.parseAttributeName2List(specification_items);
        System.out.println("规格的集合是："+attributeNameObjects);

        //SKU的集合，一个商品下有多个SKU
        List<Item> skus = itemClient.getItemsByGoodsId(goods.getId());
        List<SkuBean> skuList=new ArrayList<>();
        for (Item item : skus) {
            Long sku_id = item.getId();
            String sku_title = item.getTitle();
            Double sku_price = item.getPrice();
            String sku_spec = item.getSpec();
            Map map = JsonUtils.json2Map(sku_spec);
            SkuBean skuBean = new SkuBean(sku_id,sku_title,sku_price,map);
            skuList.add(skuBean);
        }
        //把skuList转为JSon格式
        String sku_jsons = new ObjectMapper().writeValueAsString(skuList);


        //把商品对象存值，生成详情页面
        //1.创建一个模板加载器
        ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");  //模板所在的路径
        resolver.setSuffix(".html");  //模板的后缀
        //2.创建模板引擎
        TemplateEngine templateEngine = new TemplateEngine();
        //3.加载器加入模板引擎
        templateEngine.setTemplateResolver(resolver);
        //4.设置静态页面生成的文件地址
        FileWriter fileWriter=new FileWriter("E:/xxxooo/"+goods.getId()+".html");
        //5.创建Context对象
        Context context = new Context();
        //6.放入测试数据,填充对象集合
        context.setVariable("goods",goods); //商品对象
        context.setVariable("goodsDesc",goodsDesc); //商品详情对象
        context.setVariable("orderUrls",orderUrls); //商品图片集合
        context.setVariable("brand",brand); //商品品牌对象
        context.setVariable("name1",name1); //一级类目名称
        context.setVariable("name2",name2); //二级类目名称
        context.setVariable("name3",name3); //三级类目名称
        context.setVariable("attributeNameObjects",attributeNameObjects); //商品规格集合
        context.setVariable("sku_jsons",sku_jsons); //商品的SKU（json格式）
        //7.生成页面，指定模板
        templateEngine.process("product",context,fileWriter);
        System.out.println(goods.getId()+".html商品详情页面生成完毕~~~ ");
        fileWriter.close();

    }

}

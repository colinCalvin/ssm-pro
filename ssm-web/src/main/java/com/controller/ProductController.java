package com.controller;

import com.domain.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Product的控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * @Author 长歌哲理
     * @Description 查询产品信息
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list1");
        return mv;
    }

    /**
     * @Author 长歌哲理
     * @Description 保存产品信息
     * @Param [product]
     * @return void
     **/
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        //将数据添加之后需要跳转到查询所有产品的页面
        return "redirect:findAll";
    }


}

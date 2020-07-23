package com.controller;

import com.domain.Orders;
import com.github.pagehelper.PageInfo;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Orders的前端控制器
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    //查询全部订单（未分页）
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//        ModelAndView mv = new ModelAndView();
//        List<Orders> orders = ordersService.findALl();
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return  mv;
//    }

    //查询全部订单（分页）
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page ,@RequestParam(name = "size",required = true, defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersLis = ordersService.findAll(page,size);

        //PageInfo是pagehelper自带的分页bean
        PageInfo pageInfo = new PageInfo(ordersLis);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");

        return mv;
    }

}

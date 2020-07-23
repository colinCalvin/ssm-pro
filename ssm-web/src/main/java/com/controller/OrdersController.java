package com.controller;

import com.alibaba.druid.stat.TableStat;
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

    /**
     * @Description 查询全部订单（已分页）
     * @Param [page, size]
     * @return org.springframework.web.servlet.ModelAndView
     **/
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

    /**
     * @Description 根据订单id查询订单详情
     * @Param [orderId]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(orderId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}

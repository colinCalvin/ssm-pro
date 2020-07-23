package com.service.Impl;

import com.dao.OrdersDao;
import com.domain.Orders;
import com.github.pagehelper.PageHelper;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: OrderService的实现类
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) {

        //参数pageNum是页码数，参数pageSize代表是每页显示条数
        //必须在真正调用查询语句之前
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
}

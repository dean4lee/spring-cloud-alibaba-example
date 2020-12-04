package cloud.alibaba.example.service.impl;

import cloud.alibaba.example.dao.OrderMapper;
import cloud.alibaba.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dean.lee
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String addOrder(String id, Integer uid, Double money) {
        // 添加订单
        orderMapper.add(id, uid, money);

        // 模拟异常
        // int a = 1/0;
        return "success";
    }
}

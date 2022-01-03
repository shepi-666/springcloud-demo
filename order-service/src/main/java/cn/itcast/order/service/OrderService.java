package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.example.clients.UserClient;
import com.example.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserClient userClient;

    /**
     * 使用feign的方式完成远程调用
     * @param orderId
     * @return
     */
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 使用feign的方式完成远程调用
        User user = userClient.findById(order.getUserId());

        // 3 封装user到order中
        order.setUser(user);

        // 4.返回
        return order;
    }



/*
    @Resource
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1 url路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2 发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);

        // 3 封装user到order中
        order.setUser(user);

        // 4.返回
        return order;
    }*/
}

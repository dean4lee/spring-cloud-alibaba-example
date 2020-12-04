package cloud.alibaba.example;

import cloud.alibaba.example.service.OrderService;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
@MapperScan("cloud.alibaba.example.dao")
@RestController
public class OrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @GetMapping("addOrder")
    public String addOrder(Double money, Integer uid){
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        return orderService.addOrder(id, uid, money);
    }
}

package cloud.alibaba.example;

import cloud.alibaba.example.feign.AccountFeign;
import cloud.alibaba.example.feign.OrderFeign;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoDataSourceProxy // seata开启数据源自动代理，所有服务都需要开启
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class PayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayConsumerApplication.class, args);
    }

    @Autowired
    private AccountFeign accountFeign;
    @Autowired
    private OrderFeign orderFeign;

    @GlobalTransactional // 开启事物
    @GetMapping("pay")
    public String pay(Double money, Integer uid) {
        // 扣除账户余额
        accountFeign.deduction(money, uid);
        // 添加订单
        orderFeign.addOrder(money, uid);

        // 模拟异常
//        int a = 1 / 0;
        return "success";
    }
}

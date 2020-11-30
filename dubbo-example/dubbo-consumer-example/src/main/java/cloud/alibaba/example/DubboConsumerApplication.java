package cloud.alibaba.example;

import cloud.alibaba.example.service.PrintService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @DubboReference // 引用dubbo服务
    private PrintService printService;

    @GetMapping("print")
    public String print(String src){
        return printService.print(src);
    }
}

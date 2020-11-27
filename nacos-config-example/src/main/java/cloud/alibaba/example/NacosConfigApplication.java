package cloud.alibaba.example;

import cloud.alibaba.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    @Value("${user.name:null}")
    private String name;

    @Autowired
    private User user;

    @GetMapping("getName")
    public String getName() {
        return name;
    }

    @GetMapping("get")
    public User get(){
        return user;
    }
}

package cloud.alibaba.example;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAutoConfiguration //如果只使用dubbo的bean，则不需要使用@SpringBootApplication
public class DubboProviderApplication {
    public static void main(String[] args) {
        // 非web项目启动
        new SpringApplicationBuilder(DubboProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}

package cloud.alibaba.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dean.lee
 */
// 调用服务的名称
@FeignClient("nacos-provider")
public interface TestFeign {
    // 调用服务的接口
    @GetMapping("/hello")
    String hello();
}

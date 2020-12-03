package cloud.alibaba.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dean.lee
 */
@FeignClient(value = "sentinel-feign-provider", fallback = TestFeignImpl.class)
public interface TestFeign {

    @GetMapping("hello")
    String hello();
}

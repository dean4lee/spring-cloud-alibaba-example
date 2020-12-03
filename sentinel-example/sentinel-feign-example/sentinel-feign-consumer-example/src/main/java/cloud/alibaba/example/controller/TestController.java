package cloud.alibaba.example.controller;

import cloud.alibaba.example.feign.TestFeign;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dean.lee
 */
@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello-feign")
    public String helloFeign(){
        return testFeign.hello();
    }

    // fallback属性指定降级的方法，默认为当前类的方法
    @SentinelResource(value = "hello-rest", fallback = "helloRestFallback")
    @GetMapping("hello-rest")
    public String helloRest(){
        return restTemplate.getForObject("http://sentinel-feign-provider/hello", String.class);
    }

    public String helloRestFallback(){
        return "rest fallback";
    }
}

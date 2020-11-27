package cloud.alibaba.example.controller;

import cloud.alibaba.example.feign.TestFeign;
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
    private RestTemplate restTemplate;

    @GetMapping("hello-rest")
    public String rest(){
        return restTemplate.getForObject("http://nacos-provider/hello", String.class);
    }

    @Autowired
    private TestFeign testFeign;

    @GetMapping("hello-feign")
    public String feign(){
        return testFeign.hello();
    }
}

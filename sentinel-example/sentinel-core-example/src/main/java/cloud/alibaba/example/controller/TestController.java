package cloud.alibaba.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dean.lee
 */
@RestController
public class TestController {

    // blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，
    // 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。
    // blockHandler 函数默认需要和原方法在同一个类中。
    // 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，
    // 注意对应的函数必需为 static 函数，否则无法解析。
    @SentinelResource(value = "test", blockHandler = "testHandler")
    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    public String testHandler(BlockException e){
        return "test limiting";
    }
}

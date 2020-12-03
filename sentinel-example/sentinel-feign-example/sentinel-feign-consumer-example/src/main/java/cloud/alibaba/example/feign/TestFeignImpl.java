package cloud.alibaba.example.feign;

import org.springframework.stereotype.Component;

/**
 * @author dean.lee
 */
@Component
public class TestFeignImpl implements TestFeign{
    @Override
    public String hello() {
        return "feign fallback";
    }
}

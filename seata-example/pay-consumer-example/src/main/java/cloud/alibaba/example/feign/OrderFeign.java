package cloud.alibaba.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dean.lee
 */
@FeignClient("order-provider")
public interface OrderFeign {

    @GetMapping("addOrder")
    String addOrder(@RequestParam("money") Double money, @RequestParam("uid") Integer uid);
}

package cloud.alibaba.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dean.lee
 */
@FeignClient("account-provider")
public interface AccountFeign {

    @GetMapping("deduction")
    String deduction(@RequestParam("money") Double money, @RequestParam("uid") Integer uid);
}

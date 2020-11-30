package cloud.alibaba.example.service.impl;

import cloud.alibaba.example.service.PrintService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author dean.lee
 */
@DubboService // 暴露服务
public class PrintServiceImpl implements PrintService {

    @Override
    public String print(String src) {
        return "print:" + src;
    }
}

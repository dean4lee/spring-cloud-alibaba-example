package cloud.alibaba.example.service.impl;

import cloud.alibaba.example.dao.AccountMapper;
import cloud.alibaba.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dean.lee
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public String deduction(Integer uid, Double money) {
        Double accountMoney = accountMapper.selectMoney(uid);
        if(accountMoney < money){
            throw new RuntimeException("账户余额不足");
        }
        accountMapper.deduction(uid, money);
        return "success";
    }
}

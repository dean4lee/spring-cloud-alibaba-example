package cloud.alibaba.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author dean.lee
 */
public interface AccountMapper {

    @Select("select money from t_account where uid = #{uid}")
    Double selectMoney(@Param("uid") Integer uid);

    @Update("update t_account set money = money - #{money} where uid = #{uid}")
    int deduction(@Param("uid") Integer uid, @Param("money") Double money);
}

package cloud.alibaba.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author dean.lee
 */
public interface OrderMapper {

    @Insert("insert into t_order (id, uid, money) values (#{id}, #{uid}, #{money})")
    int add(@Param("id") String id, @Param("uid") Integer uid, @Param("money") Double money);
}

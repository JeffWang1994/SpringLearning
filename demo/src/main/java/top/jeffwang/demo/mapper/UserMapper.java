package top.jeffwang.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import top.jeffwang.demo.domain.User;

/**
 * 功能描述：访问数据库的接口
 */
public interface UserMapper {

    // 推荐使用#{}取值，不要用${}，因为存在注入风险
    @Insert("INSERT INTO user(name, phone, create_time, age VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    int insert(User user);
}

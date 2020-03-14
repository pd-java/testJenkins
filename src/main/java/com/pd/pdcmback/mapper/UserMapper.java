package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.User;
import com.pd.pdcmback.entity.UserCM;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/18 14:40
 */
@Repository
public interface UserMapper {

    //通过用户名查询用户基本信息
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    //插入一个用户
    Integer insertUser(User user);

    //修改用户密码
    Integer modifyUserPassword(Map map);

    //更新用户个人资料
    Integer updateUserPersonalData(User user);

}

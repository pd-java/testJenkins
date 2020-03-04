package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/18 14:57
 */
@Repository
public interface RoleMapper {

    @Select("select r.id,r.role_name rolename from role r,role_user ru,user u where u.id = #{userId} and ru.user_id = u.id and ru.role_id = r.id")
    List<Role> getRolesByUserId(Integer userId);
}

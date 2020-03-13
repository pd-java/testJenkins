package com.pd.pdcmback.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/3/13 10:13
 * @function
 * @describe
 */
@Repository
public interface RoleWithUserMapper {

    Integer insertUserWithUserRole(Map map);
}

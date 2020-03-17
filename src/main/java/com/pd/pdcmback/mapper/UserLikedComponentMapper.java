package com.pd.pdcmback.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/3/17 9:42
 * @function
 * @describe
 */
@Repository
public interface UserLikedComponentMapper {

    Integer insertUserLikedComponent(Map<String,Object> map);

    Integer deleteUserLikedComponent(Map<String,Object> map);
}

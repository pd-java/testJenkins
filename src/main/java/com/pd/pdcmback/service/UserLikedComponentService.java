package com.pd.pdcmback.service;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/3/17 9:43
 * @function
 * @describe
 */
public interface UserLikedComponentService {

    public Integer insertUserLikedComponent(Map<String,Object> map);

    public Integer deleteUserLikedComponent(Map<String,Object> map);
}

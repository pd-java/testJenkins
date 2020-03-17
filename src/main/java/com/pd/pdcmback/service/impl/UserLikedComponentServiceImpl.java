package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.UserCM;
import com.pd.pdcmback.mapper.ComponentMapper;
import com.pd.pdcmback.mapper.UserLikedComponentMapper;
import com.pd.pdcmback.service.UserLikedComponentService;
import com.pd.pdcmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/3/17 9:44
 * @function
 * @describe
 */
@Service
public class UserLikedComponentServiceImpl implements UserLikedComponentService {

    @Autowired
    private UserLikedComponentMapper userLikedComponentMapper;

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private UserService userService;

    @Override
    public Integer insertUserLikedComponent(Map<String, Object> map) {
        String username = (String) map.get("username");
        UserCM userCM = userService.getUserPersonalData(username);
        Integer userId = userCM.getId();
        map.put("userId",userId);
        userLikedComponentMapper.insertUserLikedComponent(map);
        Integer componentId = (Integer) map.get("componentId");
        return componentMapper.updateAddOneComponentPreferTimes(componentId);
    }

    @Override
    public Integer deleteUserLikedComponent(Map<String, Object> map) {
        String username = (String) map.get("username");
        UserCM userCM = userService.getUserPersonalData(username);
        Integer userId = userCM.getId();
        map.put("userId",userId);
        userLikedComponentMapper.deleteUserLikedComponent(map);
        Integer componentId = (Integer) map.get("componentId");
        return componentMapper.updateReduceOneComponentPreferTimes(componentId);
    }
}

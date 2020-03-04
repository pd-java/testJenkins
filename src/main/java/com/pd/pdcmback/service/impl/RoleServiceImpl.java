package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.Role;
import com.pd.pdcmback.mapper.RoleMapper;
import com.pd.pdcmback.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/18 14:57
 */
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}

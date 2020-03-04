package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.Role;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/18 14:57
 */
public interface RoleService {

    public List<Role> getRolesByUserId(Integer userId);
}

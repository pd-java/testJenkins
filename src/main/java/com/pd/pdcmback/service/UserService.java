package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.User;
import com.pd.pdcmback.entity.UserCM;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/18 14:39
 */
public interface UserService extends UserDetailsService {

    public User getUserByUsername(String username);

    public Integer insertUser(User user);

    public boolean modifyPassword(Map map);

    public Integer updateUserPersonalData(User user);

    public UserCM getUserPersonalData(String username);

}

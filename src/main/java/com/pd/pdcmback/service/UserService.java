package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author pengdong
 * @date 2020/2/18 14:39
 */
public interface UserService extends UserDetailsService {

    public User getUserByUsername(String username);

    public Integer insertUser(User user);
}

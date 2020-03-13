package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.Role;
import com.pd.pdcmback.entity.User;
import com.pd.pdcmback.mapper.RoleMapper;
import com.pd.pdcmback.mapper.RoleWithUserMapper;
import com.pd.pdcmback.mapper.UserMapper;
import com.pd.pdcmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/18 14:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleWithUserMapper roleWithUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if(user == null){
            //若user为空
            System.out.println("username="+username);
            System.out.println("user is null");
            user = new User();
            return user;
        }
        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        user.setRoles(roles);
        String password = user.getPassword();
        System.out.println("user="+user);
        return new org.springframework.security.core.userdetails.User(username,password,user.getAuthorities());
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public Integer insertUser(User user) {
        //对密码加密
        String pass = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setEnabled(true);
        user.setPassword(pass);
        Integer id = userMapper.insertUser(user);
        Integer userId = user.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        roleWithUserMapper.insertUserWithUserRole(map);
        return id;
    }

    @Override
    public boolean modifyPassword(Map map) {
        User user = userMapper.getUserByUsername((String) map.get("username"));
        if(user != null){
            String password = (String) map.get("password");
            //BCryptPasswordEncoder().matches(a,b)其中a为前端传的123明文密码，b为数据库的加密密码
            boolean passwordIsRight = new BCryptPasswordEncoder().matches(password, user.getPassword());
            if(passwordIsRight){
                String newPassword = (String) map.get("newPassword");
                newPassword = new BCryptPasswordEncoder().encode(newPassword);
                map.put("newPassword",newPassword);
                map.put("userId",user.getId());
                int count = userMapper.modifyUserPassword(map);
                if (count == 1){
                    return true;
                }
            }
        }
        return false;
    }
}

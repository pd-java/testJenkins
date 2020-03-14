package com.pd.pdcmback.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/14 14:43
 * @function
 * @describe
 */
@Data
public class UserCM {

    private Integer id;

    private String username;

    private String password;

    private List<Role> roles;

    private String sex;

    private Integer age;

    private String job;

    private String birth;

    private Boolean enabled;

    private String name;

    private String company;

    private String education;

    private String school;

    private String workTime;

    private String personalProfile;

    public Integer getId() {
        return id;
    }

}

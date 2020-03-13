package com.pd.pdcmback.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author pengdong
 * @date 2020/3/13 9:57
 * @function
 * @describe
 */
@Data
public class RoleWithUser {

    private Integer id;

    private Integer userId;

    private Integer roleId;
}

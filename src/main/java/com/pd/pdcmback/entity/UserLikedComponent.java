package com.pd.pdcmback.entity;

import lombok.Data;

/**
 * @author pengdong
 * @date 2020/3/17 9:41
 * @function
 * @describe
 */
@Data
public class UserLikedComponent {

    private Integer id;

    private Integer userId;

    private Integer componentId;
}

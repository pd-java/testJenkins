package com.pd.pdcmback.entity;

import lombok.Data;

/**
 * @author pengdong
 * @date 2020/2/28 15:03
 * @function
 * @describe
 */
@Data
public class ComponentBackMenuRelate {

    private Integer id;

    private Integer fatherId;

    private Integer sonId;
}

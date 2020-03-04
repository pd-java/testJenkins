package com.pd.pdcmback.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/24 17:31
 * @function
 * @describe
 */
@Data
public class ComponentType {

    private Integer id;

    private String typeName;

    private Integer typeLevel;

    private String typeCreatTime;

    private String typeCreator;

    private boolean typeStatus;

    private List<ComponentType> sonTypes;
}

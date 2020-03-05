package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.ComponentType;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/3 10:20
 * @function
 * @describe
 */
public interface ComponentTypeService {

    public List<ComponentType> getComponentTypesAll();

    public List<ComponentType> selectComponentTypeHead();
}

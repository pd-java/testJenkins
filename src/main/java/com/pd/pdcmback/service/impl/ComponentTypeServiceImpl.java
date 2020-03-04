package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.mapper.ComponentTypeMapper;
import com.pd.pdcmback.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/3 10:21
 * @function
 * @describe
 */
@Service
public class ComponentTypeServiceImpl implements ComponentTypeService {

    @Autowired
    private ComponentTypeMapper componentTypeMapper;

    @Override
    public List<ComponentType> getComponentTypesAll() {
        return componentTypeMapper.getComponentTypesAll();
    }
}

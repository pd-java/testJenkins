package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.ComponentBackMenu;
import com.pd.pdcmback.entity.ComponentBackMenuRelate;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.entity.ComponentTypeLevel;
import com.pd.pdcmback.mapper.ComponentTypeLevelMapper;
import com.pd.pdcmback.mapper.ComponentTypeMapper;
import com.pd.pdcmback.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ComponentTypeLevelMapper componentTypeLevelMapper;

    @Override
    public List<ComponentType> getComponentTypesAll() {
        return componentTypeMapper.getComponentTypesAll();
    }

    @Override
    public List<ComponentType> selectComponentTypeHead() {
        List<ComponentType> ComponentTypes = componentTypeMapper.selectComponentTypeHead();
        int componentTypeSize = ComponentTypes.size();
        ComponentType componentType = null;
        for(int i = 0; i < componentTypeSize; i++){
            componentType = ComponentTypes.get(i);
            ComponentTypes.get(i).setSonTypes(getComponentTypeAllSons(componentType));
        }
        System.out.println("componentBaceMenus=");
        System.out.println(ComponentTypes);
        return ComponentTypes;
    }

    //递归查询所有子菜单
    private List<ComponentType> getComponentTypeAllSons(ComponentType componentType){
        List<ComponentType> componentTypes = new ArrayList<>();
        int fatherId = componentType.getId();
        List<ComponentTypeLevel> componentTypeLevels = componentTypeLevelMapper.selectComponentTypeLevelByFatherId(fatherId);
        if(componentTypeLevels != null && componentTypeLevels.size() > 0){
            for(ComponentTypeLevel componentTypeLevel: componentTypeLevels){
                int sonId = componentTypeLevel.getSonId();
                ComponentType sonComponentType  = componentTypeMapper.selectComponentTypeById(sonId);
                if(sonComponentType != null){
                    sonComponentType.setSonTypes(getComponentTypeAllSons(sonComponentType));
                    componentTypes.add(sonComponentType);
                }
            }
        }
        return componentTypes;
    }
}

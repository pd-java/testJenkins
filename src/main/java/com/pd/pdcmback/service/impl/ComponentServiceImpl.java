package com.pd.pdcmback.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.mapper.ComponentMapper;
import com.pd.pdcmback.mapper.ComponentTypeMapper;
import com.pd.pdcmback.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/24 17:27
 * @function
 * @describe
 */
@Service
public class ComponentServiceImpl implements ComponentService {

    @Value("${homePage.HotComponentAmount}")
    private Integer amount;

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private ComponentTypeMapper componentTypeMapper;

    @Override
    public PageInfo<Component> selectComponentAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Component> blogList = componentMapper.selectComponentAll();
        PageInfo<Component> pageInfo = new PageInfo<Component>(blogList);
        return pageInfo;
    }

    @Override
    public Component selectComponentByUuid(String componentUuid) {
        Component component = componentMapper.selectComponentByUuid(componentUuid);
        System.out.println("com b uid detail: "+component);
        if(component.isComponentEnabled() != true){
            component = new Component();
        }
        return component;
    }

    @Override
    public Integer insertComponent(Component component) {
        return componentMapper.insertComponent(component);
    }

    @Override
    public Integer insertComponentPictureAndUuid(Map<String, Object> map) {
        return componentMapper.insertComponentPictureAndUuid(map);
    }

    @Override
    public Integer insertComponentType(Map<String, Object> map) {
        ComponentType componentType = componentTypeMapper.selectComponentTypeByTypeId((Integer) map.get("componentTypeId"));
        if(componentType != null){
            map.put("componentType",componentType.getTypeName());
            componentMapper.insertComponentType(map);
        }
        return componentTypeMapper.insertComponentRelatedType(map);
    }

    @Override
    public Integer insertComponentExhibitionAndDownloadAddress(Map<String, Object> map) {
        return componentMapper.insertComponentExhibitionAndDownloadAddress(map);
    }

    @Override
    public PageInfo<Component> selectComponentBycheckedComponentType(String checkedComponentType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Component> blogList = componentMapper.selectComponentBycheckedComponentType(checkedComponentType);
        PageInfo<Component> pageInfo = new PageInfo<Component>(blogList);
        return pageInfo;
    }

    @Override
    public List<Component> selectHotComponentByPreferTimes() {
        return componentMapper.selectHotComponentByPreferTimes(amount);
    }

    @Override
    public PageInfo<Component> selectComponentBySearchKeyWords(String searchKeyWords, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Component> blogList = componentMapper.selectComponentBySearchKeyWords(searchKeyWords);
        PageInfo<Component> pageInfo = new PageInfo<Component>(blogList);
        return pageInfo;
    }

    @Override
    public List<Component> selectPersonalComponent() {
        return componentMapper.selectPersonalComponent();
    }


}

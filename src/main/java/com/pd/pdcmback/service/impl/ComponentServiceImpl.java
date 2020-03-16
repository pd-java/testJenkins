package com.pd.pdcmback.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.mapper.ComponentMapper;
import com.pd.pdcmback.mapper.ComponentTypeMapper;
import com.pd.pdcmback.service.ComponentService;
import com.pd.pdcmback.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Value("${component.pictureDiskAddress}")
    private String pictureDiskAddress;

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
        //增加浏览次数
        componentMapper.updateComponentBrowseTimes(componentUuid,component.getComponentBrowseTimes() + 1);
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

    @Override
    public List<Component> updatePersonalComponentDisable(Integer componentId, String able) {
        Integer isable = able.equals("true") ? 0: 1;
        System.out.println("able= " + able);
        System.out.println("isable= " + isable);
        Map<String, Object> map = new HashMap<>();
        map.put("componentId",componentId);
        map.put("isable",isable);
        //更新数据，设置指定组件不可用
        componentMapper.updatePersonalComponentDisable(map);
        //重新查询出组件
        return componentMapper.selectPersonalComponent();
    }

    @Override
    public List<Component> deleteComponentByComponentId(Integer componentId) {
        //通过组件id删除组件
        componentMapper.deleteComponentByComponentId(componentId);
        componentMapper.deleteComponentRelatedType(componentId);
        //重新查询出组件
        return componentMapper.selectPersonalComponent();
    }

    @Override
    public Integer updateComponent(Map<String, Object> map) {
        //更新组件名和描述
        componentMapper.updateComponent(map);
        //如果用户没有改变组件类型
        if((Integer) map.get("componentTypeId") == 0){
            return 1;
        }
        //更新组件类型
        return insertComponentType(map);
    }

    @Override
    public boolean deleteComponentPictureOrFile(Integer componentId, String compontentPictureOrDownLoadAddress, String ways) {
        String format[] = compontentPictureOrDownLoadAddress.split("/");
        int formatLength = format.length;
        String pictureName = "";
        for(int i = 4; i > 0; i--){
            pictureName = pictureName+ "/" + format[formatLength-i];
        }
        String pictureAddress = pictureDiskAddress + pictureName;
        if(ways == "file"){
            FileUtils.deleteAnyone(pictureAddress);
            FileUtils.deleteAnyone(pictureDiskAddress + pictureName.split("\\.")[0]);
        } else {
            FileUtils.deleteAnyone(pictureAddress);
        }
        return false;
    }



}

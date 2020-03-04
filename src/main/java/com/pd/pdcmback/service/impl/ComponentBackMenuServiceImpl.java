package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.ComponentBackMenu;
import com.pd.pdcmback.entity.ComponentBackMenuRelate;
import com.pd.pdcmback.mapper.ComponentBackMenuMapper;
import com.pd.pdcmback.mapper.ComponentBackMenuRelateMapper;
import com.pd.pdcmback.service.ComponentBackMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 10:57
 * @function
 * @describe
 */
@Service
public class ComponentBackMenuServiceImpl implements ComponentBackMenuService {

    @Autowired
    private ComponentBackMenuMapper componentBackMenuMapper;

    @Autowired
    private ComponentBackMenuRelateMapper componentBackMenuRelateMapper;

    @Override
    public List<ComponentBackMenu> selectComponentBackMenuHead() {
        List<ComponentBackMenu> componentBackMenus = componentBackMenuMapper.selectComponentBackMenuHead();
        int componentBackMenusSize = componentBackMenus.size();
        ComponentBackMenu componentBackMenu = null;
        for(int i = 0; i < componentBackMenusSize; i++){
            componentBackMenu = componentBackMenus.get(i);
            componentBackMenus.get(i).setSonMenus(getBackMenuAllSons(componentBackMenu));
        }
        System.out.println("componentBaceMenus=");
        System.out.println(componentBackMenus);
        return componentBackMenus;
    }

    //递归查询所有子菜单
    private List<ComponentBackMenu> getBackMenuAllSons(ComponentBackMenu componentBackMenu){
        List<ComponentBackMenu> componentBackMenus = new ArrayList<>();
        int fatherId = componentBackMenu.getId();
        List<ComponentBackMenuRelate> componentBackMenuRelates = componentBackMenuRelateMapper.selectBackMenuRelatesByFatherId(fatherId);
        if(componentBackMenuRelates != null && componentBackMenuRelates.size() > 0){
            for(ComponentBackMenuRelate componentBackMenuRelate: componentBackMenuRelates){
                int sonId = componentBackMenuRelate.getSonId();
                ComponentBackMenu sonComponentBackMenu  = componentBackMenuMapper.selectComponentBackMenuById(sonId);
                if(sonComponentBackMenu != null){
                    sonComponentBackMenu.setSonMenus(getBackMenuAllSons(sonComponentBackMenu));
                    componentBackMenus.add(sonComponentBackMenu);
                }
            }
        }
        return componentBackMenus;
    }
}

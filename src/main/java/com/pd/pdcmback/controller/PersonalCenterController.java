package com.pd.pdcmback.controller;

import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentBackMenu;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.exception.AjaxResponse;
import com.pd.pdcmback.service.ComponentBackMenuService;
import com.pd.pdcmback.service.ComponentService;
import com.pd.pdcmback.service.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/28 14:40
 * @function
 * @describe
 */
@CrossOrigin(origins = "http://127.0.0.1:8088",allowCredentials = "true")       //普通html项目使用ajax请求时，origins不能为"*"
//@CrossOrigin(origins = "*",allowCredentials = "true")     //使用vue时可以
@RestController
public class PersonalCenterController {

    @Autowired
    private ComponentBackMenuService componentBackMenuService;

    @Autowired
    private ComponentTypeService componentTypeService;

    @Autowired
    private ComponentService componentService;

    @RequestMapping("/getBackMenu")
    public AjaxResponse getBackMenu(){
        List<ComponentBackMenu> componentBackMenus = componentBackMenuService.selectComponentBackMenuHead();
        return AjaxResponse.getBackMenuSuccess(componentBackMenus);
    }

    @RequestMapping("/getComponentType")
    public AjaxResponse getComponentType(){
        List<ComponentType> componentTypes = componentTypeService.getComponentTypesAll();
        return AjaxResponse.getComponentTypeSuccess(componentTypes);
    }

    @GetMapping(value = "/uploadComponent",produces = {"application/json;charset=UTF-8"})
    public AjaxResponse uploadComponent(@RequestParam(value = "componentName", defaultValue = "组件名") String componentName,
                                        @RequestParam(value = "componentType", defaultValue = "1") Integer componentType,
                                        @RequestParam(value = "componentDescribe", defaultValue = "") String componentDescribe){
        Component component = new Component();
        component.setComponentName(componentName);
        component.setComponentDescribe(componentDescribe);
        Integer insertCount = componentService.insertComponent(component);
        Map<String,Object> map = new HashMap<>();
        Integer componentId = component.getId();
        map.put("uploadComponentId",componentId);
        map.put("componentId",componentId);
        map.put("componentTypeId",componentType);
        Integer insertComponentType = componentService.insertComponentType(map);
        return AjaxResponse.uploadComponentFirstSuccess(map);
    }

    @GetMapping(value = "/getPersonalComponent")
    public AjaxResponse getPersonalComponent(){
        List<Component> components = componentService.selectPersonalComponent();
        return AjaxResponse.getPersonalComponentSuccess(components);
    }
}

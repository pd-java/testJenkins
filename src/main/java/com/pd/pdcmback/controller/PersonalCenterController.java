package com.pd.pdcmback.controller;

import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentBackMenu;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.exception.AjaxResponse;
import com.pd.pdcmback.service.ComponentBackMenuService;
import com.pd.pdcmback.service.ComponentService;
import com.pd.pdcmback.service.ComponentTypeService;
import com.pd.pdcmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private UserService userService;

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

    @GetMapping(value = "/setPersonalComponentDisable")
    public AjaxResponse setPersonalComponentDisable(@RequestParam(value = "componentId", defaultValue = "0") Integer componentId,@RequestParam(value = "able", defaultValue = "") String able){
        System.out.println(" setdisable componentId ="+componentId);
        List<Component> components = new ArrayList<>();
        if(componentId !=0 && able != ""){
            components = componentService.updatePersonalComponentDisable(componentId,able);
        } else {
            components = componentService.selectPersonalComponent();
        }
        return AjaxResponse.getPersonalComponentSuccess(components);
    }

    @GetMapping(value = "/deleteComponentByComponentId")
    public AjaxResponse deleteComponentByComponentId(@RequestParam(value = "componentId", defaultValue = "0") Integer componentId){
        System.out.println(" setdisable componentId ="+componentId);
        List<Component> components = new ArrayList<>();
        if(componentId !=0){
            components = componentService.deleteComponentByComponentId(componentId);
        } else {
            components = componentService.selectPersonalComponent();
        }
        return AjaxResponse.getPersonalComponentSuccess(components);
    }

    @GetMapping(value = "/updateComponent")
    public AjaxResponse updateComponent(@RequestParam Integer componentId,
                                        @RequestParam String componentName,
                                        @RequestParam Integer componentType,
                                        @RequestParam String componentDescribe){
        Map<String,Object> map = new HashMap<>();
        map.put("componentId",componentId);
        map.put("componentName",componentName);
        map.put("componentTypeId",componentType);
        map.put("componentDescribe",componentDescribe);
        componentService.updateComponent(map);
        return AjaxResponse.updateComponentSuccess();
    }

    @GetMapping(value = "/deleteComponentPicture")
    public AjaxResponse deleteComponentPicture(@RequestParam Integer componentId,
                                               @RequestParam String componentPictureAddress){
        System.out.println("componentId="+componentId);
        System.out.println("compontentPictureAddress="+componentPictureAddress);
        String ways = "picture";
        componentService.deleteComponentPictureOrFile(componentId,componentPictureAddress,ways);
        return AjaxResponse.updateComponentSuccess();
    }

    @GetMapping(value = "/deleteComponentFile")
    public AjaxResponse deleteComponentFile(@RequestParam Integer componentId,
                                               @RequestParam String componentDownloadAddress){
        System.out.println("componentId="+componentId);
        System.out.println("componentDownloadAddress="+componentDownloadAddress);
        String ways = "file";
        componentService.deleteComponentPictureOrFile(componentId,componentDownloadAddress,ways);
        return AjaxResponse.updateComponentSuccess();
    }

    @GetMapping(value = "/modifyPassword")
    public AjaxResponse modifyPassword(@RequestParam String username,
                                       @RequestParam String password,
                                       @RequestParam String newPassword ){
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("newPassword="+newPassword);
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("newPassword",newPassword);
        boolean ismodified = userService.modifyPassword(map);
        String msg = "修改密码失败";
        if(ismodified){
            msg = "修改密码成功";
        }

        return AjaxResponse.modifyPasswordSuccess(msg);
    }
}

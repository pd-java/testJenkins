package com.pd.pdcmback.controller;

import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentType;
import com.pd.pdcmback.entity.User;
import com.pd.pdcmback.exception.AjaxResponse;
import com.pd.pdcmback.service.ComponentService;
import com.pd.pdcmback.service.ComponentTypeService;
import com.pd.pdcmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/18 14:37
 */

@CrossOrigin(origins = "http://127.0.0.1:8088",allowCredentials = "true")       //普通html项目使用ajax请求时，origins不能为"*"
//@CrossOrigin(origins = "*",allowCredentials = "true")     //使用vue时可以
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private ComponentTypeService componentTypeService;

    //@RequestMapping(value = "/",produces = {"application/json;charset=UTF-8"})
    @GetMapping(value = "/",produces = {"application/json;charset=UTF-8"})
    public AjaxResponse home(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize){
    //public AjaxResponse home(String pageNum, String pageSize){
    //public AjaxResponse home(){
        System.out.println("wellcome home");
        PageInfo<Component> componentPageInfo = componentService.selectComponentAll(pageNum, pageSize);
        return AjaxResponse.home(componentPageInfo);
    }

    //获取组件所有类别（递归）
    @RequestMapping("/getComponentTypesAll")
    public AjaxResponse getComponentTypesAll(){
        List<ComponentType> componentTypes = componentTypeService.selectComponentTypeHead();
        return AjaxResponse.getNavBarSuccess(componentTypes);
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello() do");
        return "hello every had logined";
    }

    @RequestMapping("/login")
    public AjaxResponse login(){
        System.out.println("please logining ing ing");
        return AjaxResponse.visitfailure();
    }

    @RequestMapping("/register")
    public AjaxResponse register(@RequestBody User user){
        System.out.println("registing ing ing");
        if(user != null && user.getUsername() != null && user.getPassword() != null){
            Integer count = userService.insertUser(user);
        }
        return AjaxResponse.registerSuccess();
    }

    @RequestMapping("/admin")
    public String roleAdmin(){
        System.out.println("you are admin");
        return "hello admin";
    }

    @RequestMapping("/user")
    public String roleUser(){
        System.out.println("you have user role");
        return "hello user";
    }

    @RequestMapping("/getComponentByUuid")
    public AjaxResponse getComponentByUuid(@RequestBody Map<String,Object> map){
        String componentUuid = (String) map.get("componentUuid");
        Component component = componentService.selectComponentByUuid(componentUuid);
        return AjaxResponse.getComponentByUuidSuccess(component);
    }

    @GetMapping(value = "/getComponentByCheckedComponentType")
    public AjaxResponse uploadComponent(@RequestParam(value = "checkedComponentType", defaultValue = "") String checkedComponentType,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize) {
        System.out.println("checkedComponentType= "+checkedComponentType);
        PageInfo<Component> componentPageInfo = componentService.selectComponentBycheckedComponentType(checkedComponentType, pageNum, pageSize);
        return AjaxResponse.getComponentByCheckedComponentTypeSuccess(componentPageInfo);
    }

    @GetMapping("/getHotComponents")
    public AjaxResponse getHotComponents(){
        List<Component> components = componentService.selectHotComponentByPreferTimes();
        return AjaxResponse.getHotComponentsSuccess(components);
    }

    @GetMapping("/getComponentBySearchKeyWords")
    public AjaxResponse getComponentBySearchKeyWords(@RequestParam(value = "searchKeyWords", defaultValue = "") String searchKeyWords,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize){
        PageInfo<Component> components = componentService.selectComponentBySearchKeyWords(searchKeyWords, pageNum, pageSize);
        return AjaxResponse.getComponentBySearchKeyWordsSuccess(components);
    }


}

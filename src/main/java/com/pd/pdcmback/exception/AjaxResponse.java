package com.pd.pdcmback.exception;

import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.Component;
import com.pd.pdcmback.entity.ComponentBackMenu;
import com.pd.pdcmback.entity.ComponentType;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/20 10:11
 */
@Data
public class AjaxResponse {

    private boolean issuccess;

    private int code;

    private String message;

    private Object data;


    public static AjaxResponse home(PageInfo<Component> componentPageInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(001);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("欢迎来到主页");
        ajaxResponse.setData(componentPageInfo);
        return ajaxResponse;
    }

    public static AjaxResponse getNavBarSuccess(List<ComponentType> ComponentTypes){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取组件类型成功");
        ajaxResponse.setData(ComponentTypes);
        return ajaxResponse;
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("登录成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse visitsuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(201);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("访问成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse registerSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(233);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("注册成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse getComponentByUuidSuccess(Component component){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("通过uuid获取组件详情成功");
        ajaxResponse.setData(component);
        return ajaxResponse;
    }

    public static AjaxResponse getBackMenuSuccess(List<ComponentBackMenu> componentBackMenus){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取后台菜单成功");
        ajaxResponse.setData(componentBackMenus);
        return ajaxResponse;
    }

    public static AjaxResponse getComponentTypeSuccess(List<ComponentType> componentTypes){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取组件类型成功");
        ajaxResponse.setData(componentTypes);
        return ajaxResponse;
    }

    public static AjaxResponse uploadComponentPictureSuccess(Map map){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件图片成功");
        ajaxResponse.setData(map);
        return ajaxResponse;
    }

    public static AjaxResponse uploadCompomentFileSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(100);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件zip文件成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse uploadComponentFirstSuccess(Map map){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件初步成功");
        ajaxResponse.setData(map);
        return ajaxResponse;
    }

    public static AjaxResponse getComponentByCheckedComponentTypeSuccess(PageInfo<Component> componentPageInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(002);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("通过所选类别获取组件成功");
        ajaxResponse.setData(componentPageInfo);
        return ajaxResponse;
    }

    public static AjaxResponse getHotComponentsSuccess(List<Component> components){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(003);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取最热组件成功");
        ajaxResponse.setData(components);
        return ajaxResponse;
    }

    public static AjaxResponse getComponentBySearchKeyWordsSuccess(PageInfo<Component> componentPageInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(003);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取最热组件成功");
        ajaxResponse.setData(componentPageInfo);
        return ajaxResponse;
    }

    public static AjaxResponse getPersonalComponentSuccess(List<Component> components){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(003);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取个人组件成功");
        ajaxResponse.setData(components);
        return ajaxResponse;
    }

    public static AjaxResponse error(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(199);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("登录失败，用户名或密码错误");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse visitfailure(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(403);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("访问失败，未登录");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse withoutPower(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(198);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("权限不足，不能访问");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse uploadFailure(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(99);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("上传失败");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }
}

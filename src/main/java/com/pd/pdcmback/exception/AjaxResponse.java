package com.pd.pdcmback.exception;

import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.*;
import com.pd.pdcmback.util.StatusCode;
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
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_TYPE_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取组件类型成功");
        ajaxResponse.setData(ComponentTypes);
        return ajaxResponse;
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.LOGIN_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("登录成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse loginOutSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.LOGINOUT_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("退出成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse visitsuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("访问成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse registerSuccess(String userName){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.REGISTER_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("注册成功");
        ajaxResponse.setData(userName);
        return ajaxResponse;
    }

    public static AjaxResponse registerFailure(String msg){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.REGISTER_FAIL);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage(msg);
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse getComponentByUuidSuccess(Component component){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_BY_KEY_SUCCESS);
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
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_TYPE_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取组件最终类型成功");
        ajaxResponse.setData(componentTypes);
        return ajaxResponse;
    }

    public static AjaxResponse uploadComponentPictureSuccess(Map map){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.ADD_COMPONENT_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件图片成功");
        ajaxResponse.setData(map);
        return ajaxResponse;
    }

    public static AjaxResponse uploadCompomentFileSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.ADD_COMPONENT_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件zip文件成功");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse uploadComponentFirstSuccess(Map map){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.ADD_COMPONENT_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("上传组件初步成功");
        ajaxResponse.setData(map);
        return ajaxResponse;
    }

    public static AjaxResponse getComponentByCheckedComponentTypeSuccess(PageInfo<Component> componentPageInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_BY_KEY_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("通过所选类别获取组件成功");
        ajaxResponse.setData(componentPageInfo);
        return ajaxResponse;
    }

    public static AjaxResponse getHotComponentsSuccess(List<Component> components){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_BY_KEY_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取最热组件成功");
        ajaxResponse.setData(components);
        return ajaxResponse;
    }

    public static AjaxResponse getComponentBySearchKeyWordsSuccess(PageInfo<Component> componentPageInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_BY_KEY_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("通过查询关键字获取组件成功");
        ajaxResponse.setData(componentPageInfo);
        return ajaxResponse;
    }

    public static AjaxResponse getPersonalComponentSuccess(List<Component> components){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SELECT_COMPONENT_BY_KEY_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取个人组件成功");
        ajaxResponse.setData(components);
        return ajaxResponse;
    }

    public static AjaxResponse updateComponentSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.MODIFY_COMPONENT_SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("更新个人组件初步成功");
        return ajaxResponse;
    }

    public static AjaxResponse modifyPasswordSuccess(String msg){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage(msg);
        return ajaxResponse;
    }

    public static AjaxResponse getUserPersonalDataSuccess(UserCM userCM){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("获取用户资料成功");
        ajaxResponse.setData(userCM);
        return ajaxResponse;
    }

    public static AjaxResponse personalDataSettingSuccess(String msg){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage(msg);
        return ajaxResponse;
    }

    public static AjaxResponse insertUserLikedComponentSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("添加喜欢组件成功");
        return ajaxResponse;
    }

    public static AjaxResponse deleteUserLikedComponentSuccess(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.SUCCESS);
        ajaxResponse.setIssuccess(true);
        ajaxResponse.setMessage("删除喜欢组件成功");
        return ajaxResponse;
    }

    public static AjaxResponse error(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.LOGIN_FAIL);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("登录失败，登录信息有误，请重新输入");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse visitfailure(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.FAIL);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("访问失败，未登录");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse withoutPower(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.FAIL);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("权限不足，不能访问");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }

    public static AjaxResponse uploadFailure(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(StatusCode.ADD_COMPONENT_FAIL);
        ajaxResponse.setIssuccess(false);
        ajaxResponse.setMessage("上传失败");
        //ajaxResponse.setData("");
        return ajaxResponse;
    }
}

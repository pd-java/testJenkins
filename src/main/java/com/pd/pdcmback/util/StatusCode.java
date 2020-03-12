package com.pd.pdcmback.util;


/**
 * @author pengdong
 * @date 2020/3/12 15:00
 * @function
 * @describe
 */
public class StatusCode {

    //末尾从2开始，偶数代表成功，奇数为失败


    //通用消息

    public static final short SUCCESS = 200;    //成功

    public static final short FAIL = 300;    //失败


    //登录注册模块： 1xxx

    public static final short LOGIN_SUCCESS =  1002;      //登录成功

    public static final short LOGIN_FAIL =  1003;      //登录失败

    public static final short REGISTER_SUCCESS =  1004;      //注册成功

    public static final short REGISTER_FAIL =  1005;      //注册失败

    public static final short LOGINOUT_SUCCESS =  1006;      //退出成功

    public static final short LOGINOUT_FAIL =  1007;      //退出失败


    //组件crud（增删改查模块）模块 2xxx

    public static final short SELECT_COMPONENT_SUCCESS =  2002;      //查询组件成功

    public static final short SELECT_COMPONENT_FAIL =  2003;      //查询组件失败

    public static final short SELECT_COMPONENT_TYPE_SUCCESS =  2004;      //查询组件类型成功

    public static final short SELECT_COMPONENT_TYPE_FAIL =  2005;      //查询组件类型失败

    public static final short SELECT_COMPONENT_BY_KEY_SUCCESS =  2006;      //查询组件通过关键字成功

    public static final short SELECT_COMPONENT_BY_KEY_FAIL =  2007;      //查询组件通过关键字失败

    public static final short ADD_COMPONENT_SUCCESS =  2008;      //添加组件成功

    public static final short ADD_COMPONENT_FAIL =  2009;      //添加组件失败

    public static final short MODIFY_COMPONENT_SUCCESS =  2010;      //修改组件成功

    public static final short MODIFY_COMPONENT_FAIL =  2011;      //修改组件失败

    public static final short DELETE_COMPONENT_SUCCESS =  2012;      //删除组件成功

    public static final short DELETE_COMPONENT_FAIL =  2013;      //删除组件失败

    public static final short DOWNLOAD_COMPONENT_SUCCESS =  2014;      //下载组件成功

    public static final short DOWNLOAD_COMPONENT_FAIL =  2015;      //下载组件失败
}

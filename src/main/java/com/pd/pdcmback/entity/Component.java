package com.pd.pdcmback.entity;

import lombok.Data;

/**
 * @author pengdong
 * @date 2020/2/24 17:20
 * @function
 * @describe
 */
@Data
public class Component {

    private Integer id;     //组件id

    private String componentName;     //组件名

    private String componentUuidName;     //组件uuid生成名

    private String componentType;     //组件类型

    private String componentDescribe;     //组件描述

    private String componentCreator;     //组件创建者，上传者

    private String componentCreatDate;     //组件创建日期

    private String componentPicture;     //组件图片（路径）

    private boolean componentStatus;     //组件状态

    private boolean componentEnabled;     //组件是否可用

    private String componentModifyDate;     //组件修改日期

    private Integer componentDownloadTimes;     //组件修改日期

    private Integer componentBrowseTimes;     //组件修改日期

    private Integer componentPreferTimes;     //组件修改日期

    private String componentExhibitionAddress;  //组件演示地址

    private String componentDownloadAddress;  //组件下载地址

    private ComponentType componentTypes;     //组件含有的各种类型

}

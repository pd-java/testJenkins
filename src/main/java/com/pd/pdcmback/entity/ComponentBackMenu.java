package com.pd.pdcmback.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 10:54
 * @function
 * @describe
 */
@Data
public class ComponentBackMenu {

    private Integer id;

    private String menuName;

    private Integer menuLevel;

    private String menuCreatTime;

    private String menuCreator;

    private boolean menuStatus;

    private String menuPath;

    private List<ComponentBackMenu> sonMenus;
}

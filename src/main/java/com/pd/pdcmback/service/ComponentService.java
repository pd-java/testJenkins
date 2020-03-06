package com.pd.pdcmback.service;

import com.github.pagehelper.PageInfo;
import com.pd.pdcmback.entity.Component;

import java.util.List;
import java.util.Map;


/**
 * @author pengdong
 * @date 2020/2/24 17:26
 * @function
 * @describe
 */
public interface ComponentService {

    public PageInfo<Component> selectComponentAll(int pageNum, int pageSize);

    public Component selectComponentByUuid(String componentUuid);

    public Integer insertComponent(Component component);

    public Integer insertComponentPictureAndUuid(Map<String, Object> map);

    public Integer insertComponentType(Map<String, Object> map);

    public Integer insertComponentExhibitionAndDownloadAddress (Map<String, Object> map);

    public PageInfo<Component> selectComponentBycheckedComponentType(String checkedComponentType, int pageNum, int pageSize);

    public List<Component> selectHotComponentByPreferTimes();

    public PageInfo<Component> selectComponentBySearchKeyWords(String searchKeyWords, int pageNum, int pageSize);

}

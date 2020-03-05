package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.ComponentTypeLevel;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/5 9:39
 * @function
 * @describe
 */
public interface ComponentTypeLevelService {

    List<ComponentTypeLevel> selectComponentTypeLevelByFatherId(Integer fatherId);
}

package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.ComponentTypeLevel;
import com.pd.pdcmback.mapper.ComponentTypeLevelMapper;
import com.pd.pdcmback.service.ComponentTypeLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/5 9:39
 * @function
 * @describe
 */
public class ComponentTypeLevelServiceImpl implements ComponentTypeLevelService {

    @Autowired
    private ComponentTypeLevelMapper componentTypeLevelMapper;

    @Override
    public List<ComponentTypeLevel> selectComponentTypeLevelByFatherId(Integer fatherId) {
        return componentTypeLevelMapper.selectComponentTypeLevelByFatherId(fatherId);
    }
}

package com.pd.pdcmback.service.impl;

import com.pd.pdcmback.entity.ComponentBackMenuRelate;
import com.pd.pdcmback.mapper.ComponentBackMenuRelateMapper;
import com.pd.pdcmback.service.ComponentBackMenuRelateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 15:06
 * @function
 * @describe
 */
@Service
public class ComponentBackMenuRelateServiceImpl implements ComponentBackMenuRelateService {

    @Autowired
    private ComponentBackMenuRelateMapper componentBackMenuRelateMapper;

    @Override
    public List<ComponentBackMenuRelate> selectBackMenuRelatesByFatherId(Integer fatherId) {
        return componentBackMenuRelateMapper.selectBackMenuRelatesByFatherId(fatherId);
    }
}

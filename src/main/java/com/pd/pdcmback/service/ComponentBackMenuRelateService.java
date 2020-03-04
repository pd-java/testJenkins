package com.pd.pdcmback.service;

import com.pd.pdcmback.entity.ComponentBackMenuRelate;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 15:05
 * @function
 * @describe
 */
public interface ComponentBackMenuRelateService {

    public List<ComponentBackMenuRelate> selectBackMenuRelatesByFatherId(Integer fatherId);
}

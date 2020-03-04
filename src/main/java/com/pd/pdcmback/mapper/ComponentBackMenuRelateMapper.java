package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.ComponentBackMenuRelate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 15:05
 * @function
 * @describe
 */
@Repository
public interface ComponentBackMenuRelateMapper {

    List<ComponentBackMenuRelate> selectBackMenuRelatesByFatherId(Integer fatherId);
}

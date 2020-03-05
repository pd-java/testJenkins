package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.ComponentTypeLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/3/5 9:32
 * @function
 * @describe
 */
@Repository
public interface ComponentTypeLevelMapper {

    List<ComponentTypeLevel> selectComponentTypeLevelByFatherId(Integer fatherId);
}

package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.ComponentBackMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pengdong
 * @date 2020/2/28 10:56
 * @function
 * @describe
 */
@Repository
public interface ComponentBackMenuMapper {

    List<ComponentBackMenu> selectComponentBackMenuHead();

    ComponentBackMenu selectComponentBackMenuById(Integer backMenuId);
}

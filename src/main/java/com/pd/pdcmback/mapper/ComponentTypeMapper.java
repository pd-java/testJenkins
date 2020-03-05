package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.ComponentType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/3/3 10:19
 * @function
 * @describe
 */
@Repository
public interface ComponentTypeMapper {

    List<ComponentType> getComponentTypesAll();

    List<ComponentType> selectComponentTypeHead();

    ComponentType selectComponentTypeById(Integer sonId);

    ComponentType selectComponentTypeByTypeId(Integer componentId);

    Integer insertComponentRelatedType(Map<String, Object> map);

}

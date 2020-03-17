package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.Component;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/24 17:26
 * @function
 * @describe
 */
@Repository
public interface ComponentMapper {

    List<Component> selectComponentAll();

    Component selectComponentByUuid(String componentUuid);

    @Update("update component set component_browse_times = #{componentBrowseTimes} where component_uuid_name = #{componentUuid}")
    Integer updateComponentBrowseTimes(String componentUuid, Integer componentBrowseTimes);

    Integer insertComponent(Component component);

    Integer insertComponentPictureAndUuid(Map<String, Object> map);

    Integer insertComponentType(Map<String,Object> map);

    Integer insertComponentExhibitionAndDownloadAddress (Map<String, Object> map);

    List<Component> selectComponentBycheckedComponentType(String checkedComponentType);

    List<Component> selectHotComponentByPreferTimes(Integer amount);

    List<Component> selectComponentBySearchKeyWords(String searchKeyWords);

    List<Component> selectPersonalComponent();

    Integer updatePersonalComponentDisable(Map<String,Object> map);

    Integer deleteComponentByComponentId(Integer componentId);

    @Delete("delete from component_related_type where component_id = #{componentId}")
    Integer deleteComponentRelatedType(Integer componentId);

    Integer updateComponent(Map<String,Object> map);

    @Update("update component set component_prefer_times = component_prefer_times + 1 where id = #{componentId}")
    Integer updateAddOneComponentPreferTimes(Integer componentId);

    @Update("update component set component_prefer_times = component_prefer_times - 1 where id = #{componentId}")
    Integer updateReduceOneComponentPreferTimes(Integer componentId);
}

package com.pd.pdcmback.mapper;

import com.pd.pdcmback.entity.User;
import com.pd.pdcmback.entity.UserCM;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author pengdong
 * @date 2020/2/18 14:40
 */
@Repository
public interface UserCMMapper {

    //检验用户是否重复
    UserCM selectUserByUserNameForCheckRepeat(String username);

    //通过用户名获取用户资料
    UserCM getUserPersonalData(String username);
}

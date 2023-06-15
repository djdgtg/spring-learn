package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.BaseDics;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface DicsManageCustomMapper {

    int checkUniqueness(BaseDics baseDics);

    int deleteBatch(List<String> classids);

    int checkUniquenessByTypeOrName(BaseDics baseDics);
}

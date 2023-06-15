package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.BaseClasses;
import com.qinchao.cms.entity.BaseClassesExample;
import com.qinchao.cms.entity.custom.ClassesCustomBean;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface ClassesManageCustomMapper {

    List<ClassesCustomBean> selectByExample(BaseClassesExample example);

    int countByExample(BaseClassesExample example);

    int checkUniqueness(BaseClasses baseClasses);

    int deleteBatch(List<String> classids);
}

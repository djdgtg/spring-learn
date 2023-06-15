package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseClasses;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface ClassesService {

    ActionResult listCustom();

    ActionResult add(BaseClasses baseClasses);

    ActionResult update(BaseClasses baseClasses);

    ActionResult del(Integer classid);

    ActionResult treeList();

    boolean checkUniqueness(BaseClasses baseClasses);

}

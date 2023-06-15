package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseDics;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface DicsService {

    ActionResult list(BaseDics baseDics);

    boolean checkUniquenessByTypeOrName(BaseDics baseDics);

    boolean checkUniqueness(BaseDics baseDics);

    ActionResult add(BaseDics baseDics);

    ActionResult update(BaseDics baseDics);

    ActionResult del(BaseDics baseDics);

    ActionResult delBatch(String dicIds);


}

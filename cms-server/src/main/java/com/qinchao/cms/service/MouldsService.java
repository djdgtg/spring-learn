package com.qinchao.cms.service;


import com.qinchao.cms.entity.DbMoulds;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MouldsService {

    ActionResult add(DbMoulds dbMoulds);

    ActionResult update(DbMoulds dbMoulds);

    ActionResult delBatch(String mouldIds);

    ActionResult list();

    boolean checkUniqueness(DbMoulds dbMoulds);

}

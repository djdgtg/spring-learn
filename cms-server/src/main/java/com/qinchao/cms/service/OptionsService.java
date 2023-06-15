package com.qinchao.cms.service;


import com.qinchao.cms.entity.custom.OptionsSearchBean;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface OptionsService {

    ActionResult getMenuTreeOptionsByRole(OptionsSearchBean optionsSearchBean);

    ActionResult getClassTreeOptionsByParent(OptionsSearchBean optionsSearchBean);

}

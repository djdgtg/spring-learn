package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.DbMoulds;
import com.qinchao.cms.entity.custom.MouldsManageSearchBean;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MouldsManageCustomMapper {

    List<DbMoulds> listCustom();

    int count(MouldsManageSearchBean mouldsManageSearchBean);

    int checkUniqueness(DbMoulds dbMoulds);

    int deleteBatch(List<String> mouldids);
}

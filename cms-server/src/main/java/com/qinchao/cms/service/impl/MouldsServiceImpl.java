package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.DbMoulds;
import com.qinchao.cms.entity.DbMouldsExample;
import com.qinchao.cms.mapper.DbMouldsMapper;
import com.qinchao.cms.mapper.custom.MouldsManageCustomMapper;
import com.qinchao.cms.service.MouldsService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class MouldsServiceImpl implements MouldsService {

    @Autowired
    private DbMouldsMapper mouldsMapper;

    @Autowired
    private MouldsManageCustomMapper mouldsCustomMapper;

    public ActionResult list() {
        return ActionResult.ok(mouldsMapper.selectByExample(new DbMouldsExample()));
    }

    public ActionResult add(DbMoulds dbMoulds) {
        int count = mouldsMapper.insertSelective(dbMoulds);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult update(DbMoulds dbMoulds) {
        int count = mouldsMapper.updateByPrimaryKeySelective(dbMoulds);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult delBatch(String mouldIds) {
        String[] ids = mouldIds.split(",");
        for (String id : ids) {
            mouldsMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return ActionResult.ok();
    }

    public boolean checkUniqueness(DbMoulds dbMoulds) {
        return mouldsCustomMapper.checkUniqueness(dbMoulds) > 0;
    }
}

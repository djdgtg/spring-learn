package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseDics;
import com.qinchao.cms.entity.BaseDicsExample;
import com.qinchao.cms.mapper.BaseDicsMapper;
import com.qinchao.cms.mapper.custom.DicsManageCustomMapper;
import com.qinchao.cms.service.DicsService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class DicsServiceImpl implements DicsService {

    @Autowired
    private BaseDicsMapper dicsMapper;

    @Autowired
    private DicsManageCustomMapper dicsCustomMapper;

    public ActionResult list(BaseDics baseDics) {
        BaseDicsExample example = new BaseDicsExample();
        BaseDicsExample.Criteria criteria = example.createCriteria();
        if (baseDics.getIsdictype() != null) {
            criteria.andIsdictypeEqualTo(baseDics.getIsdictype());
        }
        if (baseDics.getDictype() != null) {
            criteria.andDictypeEqualTo(baseDics.getDictype());
        }
        return ActionResult.ok(dicsMapper.selectByExample(example));
    }

    public boolean checkUniquenessByTypeOrName(BaseDics baseDics) {
        return dicsCustomMapper.checkUniquenessByTypeOrName(baseDics) > 0;
    }

    public ActionResult add(BaseDics baseDics) {
        int count = dicsMapper.insert(baseDics);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult update(BaseDics baseDics) {
        int count = dicsMapper.updateByPrimaryKey(baseDics);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult del(BaseDics baseDics) {
        BaseDicsExample example = new BaseDicsExample();
        example.createCriteria().andDictypeEqualTo(baseDics.getDictype()).andIsdictypeEqualTo(baseDics.getIsdictype());
        int count = dicsMapper.deleteByExample(example);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult delBatch(String dicIds) {
        String[] ids = dicIds.split(",");
        for (String id : ids) {
            dicsMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return ActionResult.ok();
    }

    public boolean checkUniqueness(BaseDics baseDics) {
        return dicsCustomMapper.checkUniqueness(baseDics) > 0;
    }

}

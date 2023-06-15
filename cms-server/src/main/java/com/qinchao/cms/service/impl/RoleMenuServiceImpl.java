package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.entity.BaseMenusExample;
import com.qinchao.cms.entity.BaseRolemenu;
import com.qinchao.cms.entity.BaseRolemenuExample;
import com.qinchao.cms.entity.custom.Node;
import com.qinchao.cms.entity.custom.State;
import com.qinchao.cms.mapper.BaseMenusMapper;
import com.qinchao.cms.mapper.BaseRolemenuMapper;
import com.qinchao.cms.mapper.custom.SqlCustomMapper;
import com.qinchao.cms.service.RoleMenuService;
import com.qinchao.cms.utils.ActionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private BaseRolemenuMapper rolemenuMapper;

    @Autowired
    private SqlCustomMapper sqlCustomMapper;

    @Autowired
    private BaseMenusMapper menusMapper;

    public ActionResult setRoleMenus(Integer roleId, String menuIds) {
        try {
            BaseRolemenuExample example = new BaseRolemenuExample();
            example.createCriteria().andRoleidEqualTo(roleId);
            rolemenuMapper.deleteByExample(example);
            if (!StringUtils.isEmpty(menuIds)) {
                String[] menuIdList = menuIds.split(",");
                StringBuilder sqlSb = new StringBuilder("insert into base_rolemenu(roleid,menuid) values");
                for (String menuId : menuIdList) {
                    if (!StringUtils.isEmpty(menuId) && !menuId.equals("0"))
                        sqlSb.append("(").append(roleId).append(",").append(menuId).append("),");
                }
                sqlSb.deleteCharAt(sqlSb.length() - 1);
                sqlCustomMapper.alterTable(sqlSb.toString());
            }
            return ActionResult.ok();
        } catch (Exception e) {
            return ActionResult.build(400, "操作失败！");
        }
    }

    @Override
    public ActionResult listtree(Integer roleId) {
        BaseRolemenuExample example = new BaseRolemenuExample();
        example.createCriteria().andRoleidEqualTo(roleId);
        List<BaseRolemenu> rolemenus = rolemenuMapper.selectByExample(example);
        List<Integer> checkeds = new ArrayList<>();
        for (BaseRolemenu baseRolemenu : rolemenus) {
            checkeds.add(baseRolemenu.getMenuid());
        }
        List<BaseMenus> list = menusMapper.selectByExample(new BaseMenusExample());
        List<Node> root = new ArrayList<>();// 把所有资源转换成树模型的节点集合，此容器用于保存所有节点
        for (BaseMenus baseMenus : list) {
            if (baseMenus.getParentmenuid() == 0) {
                Node node = new Node();
                if (checkeds.contains(baseMenus.getMenuid())) {
                    State state = new State(true, true);
                    node.setState(state);
                }
                node.setText(baseMenus.getMenuname());
                node.setNodeId(baseMenus.getMenuid().toString());
                root.add(node);
            }
        }
        for (Node node : root) {
            // 递归生成菜单树
            node.setNodes(getChild(node.getNodeId(), list, checkeds));
        }
        return ActionResult.ok(root);
    }

    private List<Node> getChild(String nodeId, List<BaseMenus> list, List<Integer> checkeds) {
        List<Node> childs = new ArrayList<>();
        for (BaseMenus baseMenus : list) {
            if (baseMenus.getParentmenuid() != null && baseMenus.getParentmenuid().toString().equals(nodeId)) {
                Node node = new Node();
                if (checkeds.contains(baseMenus.getMenuid())) {
                    State state = new State(true, true);
                    node.setState(state);
                }
                node.setText(baseMenus.getMenuname());
                node.setNodeId(baseMenus.getMenuid().toString());
                childs.add(node);
            }
        }
        for (Node node : childs) {
            node.setNodes(getChild(node.getNodeId(), list, checkeds));
        }
        if (childs.size() == 0) {
            return null;
        }
        return childs;
    }

}

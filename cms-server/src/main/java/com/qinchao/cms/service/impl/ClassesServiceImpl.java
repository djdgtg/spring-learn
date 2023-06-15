package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseClasses;
import com.qinchao.cms.entity.BaseClassesExample;
import com.qinchao.cms.entity.custom.ClassesCustomBean;
import com.qinchao.cms.entity.custom.ListInfo;
import com.qinchao.cms.entity.custom.TreeBean;
import com.qinchao.cms.mapper.BaseClassesMapper;
import com.qinchao.cms.mapper.custom.ClassesManageCustomMapper;
import com.qinchao.cms.service.ClassesService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**

 *@description

 *@author qinc

 *@date 2018/12/11

 */
@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private BaseClassesMapper classesMapper;

	@Autowired
	private ClassesManageCustomMapper classesCustomMapper;

	@Override
	public ActionResult listCustom() {
		List<ClassesCustomBean> classList = classesCustomMapper.selectByExample(new BaseClassesExample());
		List<ClassesCustomBean> levelOneClsList = iterateClassTree(classList,0);
		return ActionResult.ok(levelOneClsList);
	}

	//多级分类查询方法
    private List<ClassesCustomBean> iterateClassTree(List<ClassesCustomBean> clsVoList,int pid){
        List<ClassesCustomBean> result = new ArrayList<>();
        for (ClassesCustomBean clsVo : clsVoList) {
            int clsId = clsVo.getClassid();//获取菜单的id
            int parentId = clsVo.getParentclassid();//获取菜单的父id
            if(parentId == pid){
                List<ClassesCustomBean> iterateCls = iterateClassTree(clsVoList,clsId);
                if(iterateCls.size() > 0){
                	clsVo.setChildren(iterateCls);
                }
                result.add(clsVo);
            }
        }
        return result;
    }

	@Override
	public ActionResult add(BaseClasses baseClasses) {
		int count = classesMapper.insert(baseClasses);
		if (count > 0) {
			return ActionResult.ok();
		}
		return ActionResult.build(400, "操作失败！");
	}

	@Override
	public ActionResult update(BaseClasses baseClasses) {
		int count = classesMapper.updateByPrimaryKey(baseClasses);
		if (count > 0) {
			return ActionResult.ok();
		}
		return ActionResult.build(400, "操作失败！");
	}

	@Override
	public ActionResult del(Integer classid) {
		int count = classesMapper.deleteByPrimaryKey(classid);
		if (count > 0) {
			return ActionResult.ok();
		}
		return ActionResult.build(400, "操作失败！");
	}

	@Override
	public ActionResult treeList() {
		List<ClassesCustomBean> list = classesCustomMapper.selectByExample(new BaseClassesExample());
		List<TreeBean> parentClassList = new ArrayList<>();
		List<TreeBean> childClassList = new ArrayList<>();
		for (ClassesCustomBean baseClasses : list) {
			TreeBean treeBean = new TreeBean();
			treeBean.setId(baseClasses.getClassid());
			treeBean.setText(baseClasses.getClassname());
			treeBean.setParentId(baseClasses.getParentclassid());
			if (baseClasses.getParentclassid() == 0) {
				parentClassList.add(treeBean);
			} else {
				childClassList.add(treeBean);
			}

		}
		List<TreeBean> classesTreeList = new ArrayList<>();

		TreeBean cNode = new TreeBean();
		cNode.setId(0);
		cNode.setText("--顶级分类--");
		cNode.setChildren(parentClassList);
		cNode.setParentId(-1);
		cNode.setNodes(parentClassList);
		classesTreeList.add(cNode);
		TreeBean.iteraterMenus(parentClassList,childClassList);
		ListInfo listInfo = new ListInfo();
		listInfo.setLength(classesTreeList.size());
		listInfo.setList(classesTreeList);
		return ActionResult.ok(listInfo);
	}

	@Override
	public boolean checkUniqueness(BaseClasses baseClasses) {
		return classesCustomMapper.checkUniqueness(baseClasses) > 0;
	}

}

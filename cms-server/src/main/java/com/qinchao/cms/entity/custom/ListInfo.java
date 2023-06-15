package com.qinchao.cms.entity.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class ListInfo {

    private int length = 0;

    private List list = new ArrayList();

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}

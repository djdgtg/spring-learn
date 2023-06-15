package com.qinchao.cms.entity.custom;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class Options {

    private int id;

    private String text;

    private boolean selected;

    private Object tag;

    private List<Options> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public List<Options> getChildren() {
        return children;
    }

    public void setChildren(List<Options> children) {
        this.children = children;
    }
}

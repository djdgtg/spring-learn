package com.qinchao.cms.entity.custom;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class State {

    private boolean checked;
    private boolean disabled;
    private boolean expanded;
    private boolean selected;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public State(boolean checked, boolean expanded) {
        super();
        this.checked = checked;
        this.expanded = expanded;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

package ssjk.cafein;

import java.util.ArrayList;

import ssjk.cafein.ChildRow;

/**
 * Created by wqe13 on 2016-11-22.
 */

public class ParentRow {
    private String name;
    private ArrayList<ChildRow> childList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildRow> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChildRow> childList) {
        this.childList = childList;
    }

    public ParentRow(String name, ArrayList<ChildRow> childList) {
        this.name = name;
        this.childList = childList;
    }

}

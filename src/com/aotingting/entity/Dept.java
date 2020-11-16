package com.aotingting.entity;

import java.util.ArrayList;
import java.util.List;

public class Dept {
    private int dept_id;
    private String dept_name;
    private String dept_description;
    private List<Income> income_list = new ArrayList<>();
    private List<BillItem> bill_items_list = new ArrayList<>();

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_description() {
        return dept_description;
    }

    public void setDept_description(String dept_description) {
        this.dept_description = dept_description;
    }

    public List<Income> getIncome_list(){
        return income_list;
    }
    public void setIncome_list(List<Income> income_list){
        this.income_list = income_list;
    }
}

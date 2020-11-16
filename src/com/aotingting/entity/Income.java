package com.aotingting.entity;

public class Income {
    private int income_id;
    private double daily_income;
    private String business_date;
    private String lst_mod_timestemp;
    private Dept dept;

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public double getDaily_income() {
        return daily_income;
    }

    public void setDaily_income(double daily_income) {
        this.daily_income = daily_income;
    }

    public String getBusiness_date() {
        return business_date;
    }

    public void setBusiness_date(String business_date) {
        this.business_date = business_date;
    }

    public String getLst_mod_timestemp() {
        return lst_mod_timestemp;
    }

    public void setLst_mod_timestemp(String lst_mod_timestemp) {
        this.lst_mod_timestemp = lst_mod_timestemp;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

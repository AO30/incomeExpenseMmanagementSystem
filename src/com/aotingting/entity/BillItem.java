package com.aotingting.entity;

public class BillItem {
    private int bill_item_id;
    private double bill_item_expense;
    private Dept dept;
    private Bill bill;

    public int getBill_item_id() {
        return bill_item_id;
    }

    public void setBill_item_id(int bill_item_id) {
        this.bill_item_id = bill_item_id;
    }

    public double getBill_item_expense() {
        return bill_item_expense;
    }

    public void setBill_item_expense(double bill_item_expense) {
        this.bill_item_expense = bill_item_expense;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}

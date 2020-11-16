package com.aotingting.entity;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int bill_id;
    private String bill_date;
    private String bill_due_date;
    private boolean bill_paid_flag;
    private double bill_amount;
    private Vendor vendor;
    private List<BillItem> bill_items_list = new ArrayList<>();
    private List<Payment> payments_list = new ArrayList<>();

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getBill_due_date() {
        return bill_due_date;
    }

    public void setBill_due_date(String bill_due_date) {
        this.bill_due_date = bill_due_date;
    }

    public boolean isBill_paid_flag() {
        return bill_paid_flag;
    }

    public void setBill_paid_flag(boolean bill_paid_flag) {
        this.bill_paid_flag = bill_paid_flag;
    }

    public double getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(double bill_amount) {
        this.bill_amount = bill_amount;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    public List<BillItem> getBill_items_list() {
        return bill_items_list;
    }

    public void setBill_items_list(List<BillItem> bill_items_list) {
        this.bill_items_list = bill_items_list;
    }

    public List<Payment> getPayments_list() {
        return payments_list;
    }

    public void setPayments_list(List<Payment> payments_list) {
        this.payments_list = payments_list;
    }
}

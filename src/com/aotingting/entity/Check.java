package com.aotingting.entity;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private int check_id;
    private double check_number;
    private List<Payment> payment_list = new ArrayList<>();
    public int getCheck_id() {
        return check_id;
    }

    public void setCheck_id(int check_id) {
        this.check_id = check_id;
    }

    public double getCheck_number() {
        return check_number;
    }

    public void setCheck_number(double check_number) {
        this.check_number = check_number;
    }
}

package com.aotingting.entity;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
    private int vendor_id;
    private String vendor_name;
    private String vendor_address;
    private String vendor_phone;
    private String vendor_fax;
    private String vendor_contact_person;
    private List<Bill> bill_list = new ArrayList<>();

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_address() {
        return vendor_address;
    }

    public void setVendor_address(String vendor_address) {
        this.vendor_address = vendor_address;
    }

    public String getVendor_phone() {
        return vendor_phone;
    }

    public void setVendor_phone(String vendor_phone) {
        this.vendor_phone = vendor_phone;
    }

    public String getVendor_fax() {
        return vendor_fax;
    }

    public void setVendor_fax(String vendor_fax) {
        this.vendor_fax = vendor_fax;
    }

    public String getVendor_contact_person() {
        return vendor_contact_person;
    }

    public void setVendor_contact_person(String vendor_contact_person) {
        this.vendor_contact_person = vendor_contact_person;
    }
}

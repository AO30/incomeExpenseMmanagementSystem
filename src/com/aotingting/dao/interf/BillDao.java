package com.aotingting.dao.interf;

import com.aotingting.entity.Bill;


import java.util.List;

public interface BillDao {
    /**
     * 根据Vendor_name查询bill
     */
    public List<Bill> queryByVendorName(String vendor_name);

    /**
     * 添加bill
     */
    public int addBill(int vendor_id,String bill_date,String bill_due_date,double bill_amount);

    /**
     * 支付，update
     *
     */
    public int updateBill(int bill_id);



}

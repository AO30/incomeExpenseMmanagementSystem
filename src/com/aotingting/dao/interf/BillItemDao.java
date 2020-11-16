package com.aotingting.dao.interf;

import com.aotingting.entity.BillItem;

import java.util.List;

public interface BillItemDao {
    /**
     * 添加billItem
     */
    public int addBillItem(int dept_id,int bill_id,double item_expense);

    /**
     * 根据bill_id查询bill
     */
    public List<BillItem> queryById(int bill_id);
}

package com.aotingting.dao.interf;

import com.aotingting.entity.Income;

import java.util.List;

public interface IncomeDao {
    /**
     * 默认当天账单部门名称排序
     */
    public List<Income> query();

    /**
     *更新
     */
    public int update_income(int income_id,double daily_income);

    /**
     * 增加
     */
    public int add_income(int dept_id, double daily_income);

    /**
     *根据日期查询
     */
    public List<Income> queryByTime(String business_date);

    /**
     *根据ID查询
     */
    public List<Income> queryById(int income_id);


}

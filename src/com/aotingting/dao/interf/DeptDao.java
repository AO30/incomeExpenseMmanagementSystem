package com.aotingting.dao.interf;

import com.aotingting.entity.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 增加dept
     */
    public int addDept(String dept_name, String dept_description);
    /**
     * 更新dept
     */
    public int updateDept(int dept_id, String dept_name, String dept_description);

    /**
     * 查询dept
     */
    public List<Dept> query();

    /**
     * 根据id查询dept
     */
    public List<Dept> queryById(int dept_id);

}

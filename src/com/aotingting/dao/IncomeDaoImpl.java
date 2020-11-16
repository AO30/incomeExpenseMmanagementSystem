package com.aotingting.dao;

import com.aotingting.dao.interf.IncomeDao;
import com.aotingting.entity.Dept;
import com.aotingting.entity.Income;
import com.aotingting.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IncomeDaoImpl implements IncomeDao {
    private Connection con;
    Statement st = null;
    ResultSet rs = null;
    int flag = 0;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();

    public IncomeDaoImpl(Connection con){
        this.con = con;
    }

    @Override
    public List<Income> query() {
        List<Income> incomeList = new ArrayList<Income>();
        try {
            st = con.createStatement();
            String date = formatter.format(calendar.getTime());
            String sql = "select i.income_id,i.business_date,i.lst_mod_timestemp,i.daily_income,d.dept_name from t_income i, t_dept d where business_date='"+ date +"' and i.dept_id=d.dept_id";
//            System.out.println("sql:" + sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Income income = new Income();
                Dept dept =new Dept();
                income.setIncome_id(Integer.parseInt(rs.getString("income_id")));
                income.setBusiness_date(rs.getString("business_date"));
                income.setLst_mod_timestemp(rs.getString("lst_mod_timestemp"));
                income.setDaily_income(rs.getDouble("daily_income"));
                dept.setDept_name(rs.getString("dept_name"));
                income.setDept(dept);
                incomeList.add(income);
            }
//            for (Income i : incomeList){
//                System.out.println(i.getBusiness_date());
//                System.out.println(i.getDept().getDept_name());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(rs, st, con);
        }
        return incomeList;
    }

    @Override
    public int update_income(int income_id, double daily_income) {
        try{
            st = con.createStatement();
            String date = formatter1.format(calendar.getTime());
            String sql = "update t_income set daily_income="+ daily_income +",lst_mod_timestemp='"+ date +"' where income_id="+ income_id +"";
            System.out.println("sql:" + sql);
            st.executeUpdate(sql);
            flag = 1;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return flag;
    }

    @Override
    public int add_income(int dept_id, double daily_income) {
        try {
            st = con.createStatement();
            String date = formatter.format(calendar.getTime());
            int id = dept_id;
            String sql = "insert into t_income(dept_id,daily_income,business_date,lst_mod_timestemp) values("+ dept_id +","+ daily_income+",'"+ date +"','')";
//            System.out.println("sql:" + sql);
            st.execute(sql);
            flag = 1;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.Close(rs, st, con);
        }
        return flag;
    }

    @Override
    public List<Income> queryByTime(String business_date) {
        List<Income> incomeList = new ArrayList<Income>();
        try {
            st = con.createStatement();
            String sql = "select i.income_id,i.business_date,i.lst_mod_timestemp,i.daily_income,d.dept_name from t_income i, t_dept d where business_date='"+ business_date +"' and i.dept_id=d.dept_id";
            System.out.println("sql:" + sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Income income = new Income();
                Dept dept =new Dept();
                income.setIncome_id(Integer.parseInt(rs.getString("income_id")));
                income.setBusiness_date(rs.getString("business_date"));
                income.setLst_mod_timestemp(rs.getString("lst_mod_timestemp"));
                income.setDaily_income(rs.getDouble("daily_income"));
                dept.setDept_name(rs.getString("dept_name"));
                income.setDept(dept);
                incomeList.add(income);
            }
            for (Income i : incomeList){
                System.out.println(i.getBusiness_date());
                System.out.println(i.getDept().getDept_name());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(rs, st, con);
        }
        return incomeList;
    }

    @Override
    public List<Income> queryById(int income_id) {
        List<Income> incomeList = new ArrayList<Income>();
        try {
            st = con.createStatement();
            String sql = "select i.income_id,i.daily_income,d.dept_name from t_income i, t_dept d where i.income_id="+ income_id +" and i.dept_id=d.dept_id";
            System.out.println("sql:" + sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                Income income = new Income();
                Dept dept =new Dept();
                income.setIncome_id(Integer.parseInt(rs.getString("income_id")));
                income.setDaily_income(rs.getDouble("daily_income"));
                dept.setDept_name(rs.getString("dept_name"));
                income.setDept(dept);
                incomeList.add(income);
            }
//            for (Income i : incomeList){
//                System.out.println(i.getDept().getDept_name());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(rs, st, con);
        }
        return incomeList;
    }
}

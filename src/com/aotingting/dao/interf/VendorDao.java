package com.aotingting.dao.interf;

import com.aotingting.entity.Vendor;

import java.util.List;

public interface VendorDao {
    /**
     * 查询vendor
     */
    public List<Vendor> queryVendor();

    /**
     * id查询vendor
     */
    public List<Vendor> queryVendorById(int vendor_id);

    /**
     * 添加vendor
     */
    public int addVendor(String vendor_name,String vendor_address,String vendor_phone,String vendor_fax,String vendor_contact_person);

    /**
     * update
     */
    public int updateVendor(int vendor_id, String vendor_name,String vendor_address,String vendor_phone,String vendor_fax,String vendor_contact_person);
}

package com.ojas.CMS.dao.admin;

import com.ojas.CMS.model.Customer;
//import com.ojas.CMS.model.Vendor;

public interface adminCustomer {
        public String addCustomer(String cname,long mobile ,String address,String wallet ,int rid);
        public Customer viewCustomer(int cid);
}

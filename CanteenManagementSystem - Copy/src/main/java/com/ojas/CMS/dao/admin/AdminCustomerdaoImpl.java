package com.ojas.CMS.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ojas.CMS.db.DBUtility;
import com.ojas.CMS.model.Customer;
import com.ojas.CMS.model.Vendor;
import com.ojas.CMS.query.query;

public class AdminCustomerdaoImpl implements adminCustomer {

	@Override
	public String addCustomer(String cname, long mobile, String address, String wallet, int rid) {

		String msg = null;
		try {
			Connection con = com.ojas.CMS.db.DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer(cname,mobilenumber,address,wallet,rid) VALUES(?,?,?,?,?)");
			ps.setString(1, cname);
			ps.setLong(2, mobile);
			ps.setString(3, address);
			ps.setString(4, wallet);
			ps.setInt(5, rid);
			int n = ps.executeUpdate();
			if (n != 0) {
				msg = "Successfully Customer added......";
			} else {
				msg = "No table to added.Please try again...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;

	
	}

	@Override
	public Customer viewCustomer(int cid) {
		Customer c = new Customer();
		try {

			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer where cid=?");
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setMob(rs.getLong(3));
				c.setAddress(rs.getString(4));
				c.setWallet(rs.getString(5));
				c.setRid(rs.getInt(6));
			}
			else {
				 System.out.println("rs is null");
			}

		} catch (Exception e) {

		}

		return c;
	
	}

}

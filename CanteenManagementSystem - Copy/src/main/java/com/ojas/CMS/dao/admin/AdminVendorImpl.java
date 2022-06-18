package com.ojas.CMS.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ojas.CMS.db.DBUtility;
import com.ojas.CMS.model.Vendor;
import com.ojas.CMS.query.query;

public class AdminVendorImpl implements adminVenderDao {

	@Override
	public String addVendor(String vname, String email, long mobile, String address) {

		String msg = null;
		try {
			Connection con = com.ojas.CMS.db.DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO vendor(vname,email,mobilenumber,address) VALUES(?,?,?,?)");
			ps.setString(1, vname);
			ps.setString(2, email);
			ps.setLong(3, mobile);
			ps.setString(4, address);
			int n = ps.executeUpdate();
			if (n != 0) {
				msg = "Successfully Vendror added......";
			} else {
				msg = "Notable to added.Please try again...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public Vendor viewvendor(int vid) {
		Vendor v = new Vendor();
		try {

			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from vendor where vid=?");
			ps.setInt(1, vid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				v.setVid(rs.getInt(1));
				v.setVname(rs.getString(2));
				v.setEmail(rs.getString(3));
				v.setMob(rs.getLong(4));
				v.setAdress(rs.getString(5));
			}
			else {
				 System.out.println("rs is null");
			}

		} catch (Exception e) {

		}

		return v;
	}

}

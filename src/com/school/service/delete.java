package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.school.dbHelp.jdbc;

import net.sf.json.JSONObject;

public class delete {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	public String deleteStudentMessage(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String s = json.getString("studentNum").substring(1,json.getString("studentNum").length()-1);
		String sql = "delete from student_login_message where id in (" + s + ")";
		System.out.println(sql);
		conn = jdbc.getConn();
		try {
			stat = conn.createStatement();
			//System.out.println(sql);
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbc.close(conn,stat,rs);
		}
		
		return "success";
	}
}

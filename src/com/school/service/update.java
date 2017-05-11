package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.school.beans.studentRegisterMessage;
import com.school.dbHelp.jdbc;

import net.sf.json.JSONObject;

public class update {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	/**
	 * 修改学生电话和邮件地址
	 * @param data
	 * @return
	 */
	public String changeStudentPE(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String sql = "update student_login_message set phone=" + "'" + json.getString("phone") + "'" + ",email=" + "'" + json.getString("email") + "'" + " where username=" + "'" + json.getString("username") + "'";
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
	
	/**
	 * 修改学生登陆密码
	 * @param data
	 * @return
	 */
	public String changeStudentPassword(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String sql = "update student_login_message set password=" + "'" + json.getString("password") + "'" + " where username=" + "'" + json.getString("username") + "'";
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

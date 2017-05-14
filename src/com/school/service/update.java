package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * 修改教师电话和邮箱地址
	 * @param data
	 * @return
	 */
	public String changeTeacherPE(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String sql = "update teacher_login_message set phone=" + "'" + json.getString("phone") + "'" + ",email=" + "'" + json.getString("email") + "'" + " where username=" + "'" + json.getString("username") + "'";
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
	 * 修改学生登陆密码和重置密码
	 * @param data
	 * @return
	 */
	public String changeStudentPassword(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String sql = "";
		//System.out.println(json.containsKey("examine"));
		if (json.getString("username").equals("")) {
			String s = json.getString("studentNum").substring(1,json.getString("studentNum").length()-1);
			if (json.containsKey("examine")) {
				if (json.getString("examine").equals("true")) {
					sql = "update student_login_message set examine=1 where id in (" + s + ")";
				}else if (json.getString("examine").equals("false")) {
					sql = "update student_login_message set examine=2 where id in (" + s + ")";
				}
			}else {
				sql = "update student_login_message set password='123456' where id in (" + s + ")";
			}
		}
		else {
			sql = "update student_login_message set password=" + "'" + json.getString("password") + "'" + " where username=" + "'" + json.getString("username") + "'";
		}
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
	 * 修改教师登陆密码
	 * @param data
	 * @return
	 */
	public String changeTeacherPassword(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		String sql = "update teacher_login_message set password=" + "'" + json.getString("password") + "'" + " where username=" + "'" + json.getString("username") + "'";
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

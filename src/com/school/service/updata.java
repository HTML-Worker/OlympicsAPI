package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.school.beans.studentRegisterMessage;
import com.school.dbHelp.jdbc;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class updata {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	public ArrayList<studentRegisterMessage> getStudentAllMessage(String data) {
		JSONArray json = JSONArray.fromObject(data);
		System.out.println(json);
		
		//studentRegisterMessage student = new studentRegisterMessage();
		//ArrayList<studentRegisterMessage> list = new ArrayList<studentRegisterMessage>();
//		String sql = "insert into student_login_message values()";
//		conn = jdbc.getConn();
//		ArrayList<studentRegisterMessage> list = new ArrayList<studentRegisterMessage>();
//		try {
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}finally {
//			jdbc.close(conn,stat,rs);
//		}
//		
		return null;
	}
}

package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.school.beans.studentRegisterMessage;
import com.school.dbHelp.jdbc;

import net.sf.json.JSONObject;


public class updata {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	public ArrayList<studentRegisterMessage> getStudentAllMessage(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		studentRegisterMessage student = new studentRegisterMessage();
		ArrayList<Object> list = student.pushData(json);
		String s = Pattern.compile("\\b([\\w\\W])\\b").matcher(list.toString().substring(1,list.toString().length()-1)).replaceAll("'$1'");  
		
		String sql = "insert into student_login_message values("+ s +")";
		conn = jdbc.getConn();
		try {
			stat = conn.createStatement();
			//System.out.println(sql);
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			jdbc.close(conn,stat,rs);
		}
		
		return null;
	}
}

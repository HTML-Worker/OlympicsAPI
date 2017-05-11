package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.school.beans.land;
import com.school.beans.studentRegisterMessage;
import com.school.beans.teacherRegisterMessage;
import com.school.dbHelp.jdbc;

import net.sf.json.JSONObject;


public class insert {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	/**
	 * 录入学生注册信息
	 * @param data
	 * @return
	 */
	public ArrayList<studentRegisterMessage> getStudentAllMessage(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		studentRegisterMessage student = new studentRegisterMessage();
		ArrayList<Object> list = student.pushData(json);
		String s = list.toString().substring(1,list.toString().length()-1);
		
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
	
	/**
	 * 录入教师注册信息
	 * @param data
	 * @return
	 */
	public ArrayList<teacherRegisterMessage> getTeacherAllMessage(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		teacherRegisterMessage teacher = new teacherRegisterMessage();
		ArrayList<Object> list = teacher.pushData(json);
		String s = list.toString().substring(1,list.toString().length()-1);
		
		String sql = "insert into teacher_login_message values("+ s +")";
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
	
	/**
	 * 录入登录信息
	 * @param data
	 * @return
	 */
	public void pushLoginData(String data) {
		JSONObject  json = JSONObject .fromObject(data);
		land loginData = new land();
		ArrayList<Object> list = loginData.pushData(json);
		String s = list.toString().substring(1,list.toString().length()-1);
		
		String sql = "insert into land values("+ s +")";
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
	}
}

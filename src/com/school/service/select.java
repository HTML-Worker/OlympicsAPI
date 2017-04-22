/**
 * 
 */
/**
 * @author Long
 *
 */
package com.school.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.school.beans.about;
import com.school.dbHelp.jdbc;


public class select {
	static String about = "select * from about";
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	/**
	 * 获取关于页面的数据
	 * @return
	 */
	public ArrayList<about> getAbout() {
		conn = jdbc.getConn();
		ArrayList<about> list = new ArrayList<about>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(about);
			while(rs.next()) {
				about about = new about();
				about.setAbout_id(rs.getString("id"));
				about.setAbout_title(rs.getString("about_title"));
				about.setAbout_content(rs.getString("about_content"));
				about.setAbout_time(rs.getString("about_time"));
				list.add(about);
//				System.out.println(rs.getString("about_title"));
//				System.out.println(about);
//				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			jdbc.close(conn,stat,rs);
		}
		
		return list;	
	}
	
	public ArrayList<about> getAboutContent(String tableName,int id) {
		String contentSql = "select * from " + tableName + " where id=" + id;
		conn = jdbc.getConn();
		ArrayList<about> list = new ArrayList<about>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(contentSql);
			while(rs.next()) {
				about about = new about();
				about.setAbout_id(rs.getString("id"));
				about.setAbout_title(rs.getString("about_title"));
				about.setAbout_content(rs.getString("about_content"));
				about.setAbout_time(rs.getString("about_time"));
				list.add(about);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			jdbc.close(conn,stat,rs);
		}
		
		return list;
	}
}
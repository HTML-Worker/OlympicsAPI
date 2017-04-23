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

import com.school.beans.document;
import com.school.dbHelp.jdbc;


public class select {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	
	/**
	 * 获取关于页面的文章内容
	 * @param tableName
	 * @param id
	 * @return
	 */
	public ArrayList<document> getContent(String tableName,int id) {
		String sql = "select id,content from " + tableName + " where id=" + id;
		conn = jdbc.getConn();
		ArrayList<document> list = new ArrayList<document>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				document document = new document();
				document.setId(rs.getString("id"));
				//document.setTitle(rs.getString("title"));
				document.setContent(rs.getString("content"));
				//document.setCount(rs.getString("count"));
				//document.setTime(rs.getString("time"));
				list.add(document);
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
	
	
	public ArrayList<document> getDocumentTitle(String tableName, int start, int end) {
		if (start <= 0) {
			start = 0;
		}
		if (end <= 0) {
			end = 7;
		}
		String sql = "select id,title,count,time from " + tableName + " order by id desc limit " + start + "," + end;
		conn = jdbc.getConn();
		ArrayList<document> list = new ArrayList<document>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				document document = new document();
				document.setId(rs.getString("id"));
				document.setTitle(rs.getString("title"));
				//document.setContent(rs.getString("content"));
				document.setCount(rs.getString("count"));
				document.setTime(rs.getString("time"));
				list.add(document);
				//System.out.println(rs.getString("title"));
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
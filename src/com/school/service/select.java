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
import java.sql.Statement;
import java.util.ArrayList;

import com.school.beans.idtest;
import com.school.dbHelp.jdbc;


public class select {
	static String sql = "select * from idtest";
	
	public ArrayList<idtest> getDBMessage(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<idtest> list = new ArrayList<idtest>();
		
		conn = jdbc.getConn();
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			idtest jj = new idtest();
			while(rs.next()){
				jj.setId(rs.getInt("id"));
				list.add(jj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			jdbc.close(conn,stat,rs);
		}
		return list;
	}
}
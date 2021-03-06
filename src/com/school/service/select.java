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

import com.school.beans.adminMessage;
import com.school.beans.backMessage;
import com.school.beans.document;
import com.school.beans.gameIssue;
import com.school.beans.land;
import com.school.beans.newsNotes;
import com.school.beans.studentRegisterMessage;
import com.school.beans.teacherRegisterMessage;
import com.school.dbHelp.jdbc;
import com.school.util.buildSqlString;

import net.sf.json.JSONObject;


public class select {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	
	
	/**
	 * 获取文章内容
	 * @param tableName
	 * @param id
	 * @return
	 */
	public ArrayList<document> getContent(String tableName,int id) {
		String sql = "select * from " + tableName + " where id=" + id;
		conn = jdbc.getConn();
		ArrayList<document> list = new ArrayList<document>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				document document = new document();
				document.setId(rs.getString("id"));
				document.setTitle(rs.getString("title"));
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
	
	/**
	 * get方法url传参获取文章标题
	 * @param tableName
	 * @param start
	 * @param end
	 * @return
	 */
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
	
	/**
	 * 条件查询文章标题
	 * @param data
	 * @return
	 */
	public ArrayList<document> searchTitle(String data) {
		String sql = "";
		JSONObject  json = JSONObject .fromObject(data);
		if(json.containsKey("id")) {
			sql = "select * from " + json.getString("table") + " where id=0";
		}else {
			if(json.getString("title").equals("")) {
				sql = "select * from " + json.getString("table") + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}else {
				sql = "select * from " + json.getString("table") + " where title like" + "'%" + json.getString("title") + "%'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}
		}
		//System.out.println(sql);
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
	
	/**
	 * 获取新闻的文章内容
	 * @param id
	 * @return
	 */
	public ArrayList<newsNotes> getContent(int id) {
		String sql = "select id,title,content from news_notes where id=" + id;
		conn = jdbc.getConn();
		ArrayList<newsNotes> list = new ArrayList<newsNotes>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				newsNotes news = new newsNotes();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				list.add(news);
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
	
	/**
	 * 验证登陆账号信息
	 * @param id
	 * @return
	 */
	public ArrayList<backMessage> checkLang(String data) {
		int i = 0;
		JSONObject  json = JSONObject .fromObject(data);
		ArrayList<backMessage> list = new ArrayList<backMessage>();
		buildSqlString buildSqlString = new buildSqlString();
		backMessage message = new backMessage();
		String str = buildSqlString.buildCheckLand(json);
		String sqlStu = "select * from student_login_message where " + str;
		String sqlTch = "select * from teacher_login_message where " + str;
		String sqlAdm = "select * from admin where " + str;
		conn = jdbc.getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sqlAdm);
			while(rs.next()) {
				i++;
				message.setName(rs.getString("username"));
				message.setExamine(1);
			}
			if (0 == i) {
				rs2 = stat.executeQuery(sqlTch);
				while(rs2.next()) {
					i++;
					message.setName(rs2.getString("username"));
					message.setExamine(rs2.getInt("examine"));
				}
				if (0 == i) {
					rs3 = stat.executeQuery(sqlStu);
					while(rs3.next()) {
						i++;
						message.setName(rs3.getString("username"));
						message.setExamine(rs3.getInt("examine"));
					}
					if (0 == i) {
						message.setFlag(false);
						message.setMessage("账号或密码错误");
					} else {
						message.setFlag(true);
						message.setMessage("student");
					}
				} else {
					message.setFlag(true);
					message.setMessage("teacher");
				}
			} else {
				message.setFlag(true);
				message.setMessage("admin");
			}
			
			list.add(message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbc.close(conn,stat,rs);
		}
		//System.out.println(list);
		return list;
	}
	
	/**
	 * 查询正在登陆的用户
	 * @return
	 */
	public ArrayList<land> getLogined() {
		String sql = "select * from land order by id desc limit 0,1";
		conn = jdbc.getConn();
		ArrayList<land> list = new ArrayList<land>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				land land = new land();
				land.setId(rs.getInt("id"));
				land.setUsername(rs.getString("username"));
				land.setIdentity(rs.getString("identity"));
				land.setLanding(rs.getInt("landing"));
				list.add(land);
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
	
	/**
	 * 查询学生信息
	 * @return
	 */
	public ArrayList<studentRegisterMessage> getStudentMessage(String userName) {
		String sql = "select * from student_login_message " + "where username=" + "'" + userName + "'";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<studentRegisterMessage> list = new ArrayList<studentRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				studentRegisterMessage student = new studentRegisterMessage();
				student.setId(rs.getInt("id"));
				student.setExamine(rs.getInt("examine"));
				student.setPay(rs.getInt("pay"));
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setPeopleId(rs.getString("peopleId"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
				student.setLanguage(rs.getString("language"));
				student.setTeacherName(rs.getString("teacherName"));
				student.setEntryType(rs.getString("entryType"));
				student.setGroup(rs.getString("group"));
				list.add(student);
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
	
	/**
	 * 条件查询学生信息
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<studentRegisterMessage> getAllStudentMessage(String data) {
		String sql = "";
		JSONObject  json = JSONObject .fromObject(data);
		if (json.containsKey("examine")) {
			//判断是否按审核状态查询
			if (json.getString("teacher").equals("")) {
				//按分页查询所有信息
				if (json.getString("name").equals("") && json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}else if (json.getString("name").equals("") && !json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					if (json.getString("examine").equals("审核通过")) {
						sql = "select * from student_login_message where examine='1' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("待审核")) {
						sql = "select * from student_login_message where examine='0' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("已拒绝")) {
						sql = "select * from student_login_message where examine='2' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					}
				} else if (!json.getString("name").equals("") && json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("end").equals("0") && !json.getString("examine").equals("全部")) {
					sql = "select * from student_login_message where examine = '1' order by id desc";
				} else {
					if (json.getString("examine").equals("审核通过")) {
						sql = "select * from student_login_message where examine='1' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("待审核")) {
						sql = "select * from student_login_message where examine='0' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("已拒绝")) {
						sql = "select * from student_login_message where examine='2' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					}
				}
			}
			else {
				//专属教师查询
				if (json.getString("name").equals("") && json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where teacherName=" + "'" + json.getString("teacher") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("name").equals("") && !json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					if (json.getString("examine").equals("审核通过")) {
						sql = "select * from student_login_message where examine='1' and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("待审核")) {
						sql = "select * from student_login_message where examine='0' and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("已拒绝")) {
						sql = "select * from student_login_message where examine='2' and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					}
				} else if (!json.getString("name").equals("") && json.getString("examine").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("end").equals("0")) {
					sql = "select * from student_login_message where teacherName=" + "'" + json.getString("teacher") + "'" +" order by id desc";
				} else {
					if (json.getString("examine").equals("审核通过")) {
						sql = "select * from student_login_message where examine='1' and " + "name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("待审核")) {
						sql = "select * from student_login_message where examine='0' and " + "name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					} else if (json.getString("examine").equals("已拒绝")) {
						sql = "select * from student_login_message where examine='2' and " + "name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
					}
				}
			}
		}else {
			//普通信息查询，不考虑审核状态
			if (json.getString("teacher").equals("")) {
				if (json.getString("name").equals("") && json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
				else if (json.getString("name").equals("") && !json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and grade=" + "'" + json.getString("grade") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
				else if (!json.getString("name").equals("") && json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}else if (json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' order by id desc";
				}else {
					sql = "select * from student_login_message where examine='1' and grade=" + "'" + json.getString("grade") + "'" + " and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
			}
			else {
				if (json.getString("name").equals("") && json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and teacherName=" + "'" + json.getString("teacher") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
				else if (json.getString("name").equals("") && !json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and grade=" + "'" + json.getString("grade") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
				else if (!json.getString("name").equals("") && json.getString("grade").equals("全部") && !json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}else if (json.getString("end").equals("0")) {
					sql = "select * from student_login_message where examine='1' and teacherName=" + "'" + json.getString("teacher") + "'" +" order by id desc";
				}else {
					sql = "select * from student_login_message where examine='1' and grade=" + "'" + json.getString("grade") + "'" + " and " + "name=" + "'" + json.getString("name") + "'" + " and " + "teacherName=" + "'" + json.getString("teacher") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
			}
		}
		conn = jdbc.getConn();
		//System.out.println(sql);
		ArrayList<studentRegisterMessage> list = new ArrayList<studentRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				studentRegisterMessage student = new studentRegisterMessage();
				student.setId(rs.getInt("id"));
				student.setExamine(rs.getInt("examine"));
				student.setPay(rs.getInt("pay"));
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setPeopleId(rs.getString("peopleId"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
				student.setLanguage(rs.getString("language"));
				student.setTeacherName(rs.getString("teacherName"));
				student.setEntryType(rs.getString("entryType"));
				student.setGroup(rs.getString("group"));
				list.add(student);
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
	
	/**
	 * 查询指定教师信息
	 * @param userName
	 * @return
	 */
	public ArrayList<teacherRegisterMessage> getTeacherMessage(String userName) {
		String sql = "select * from teacher_login_message " + "where username=" + "'" + userName + "'";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<teacherRegisterMessage> list = new ArrayList<teacherRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				teacherRegisterMessage teacher = new teacherRegisterMessage();
				teacher.setId(rs.getInt("id"));
				teacher.setExamine(rs.getInt("examine"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setPeopleId(rs.getString("peopleId"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setEmail(rs.getString("email"));
				teacher.setSchool(rs.getString("school"));
				teacher.setAddress(rs.getString("address"));
				teacher.setZipCode(rs.getString("zipCode"));
				list.add(teacher);
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
	
	/**
	 * 获取特派员账号信息
	 * @param userName
	 * @return
	 */
	public ArrayList<adminMessage> getAdminMessage(String userName) {
		String sql = "select * from admin " + "where username=" + "'" + userName + "'";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<adminMessage> list = new ArrayList<adminMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				adminMessage admin = new adminMessage();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setPhone(rs.getString("phone"));
				admin.setEmail(rs.getString("email"));
				admin.setAddress(rs.getString("address"));
				admin.setZipCode(rs.getString("zipCode"));
				list.add(admin);
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
	
	/**
	 * 获取所有教师信息
	 * @return
	 */
	public ArrayList<teacherRegisterMessage> getAllTeacherMessage() {
		String sql = "select * from teacher_login_message order by id desc";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<teacherRegisterMessage> list = new ArrayList<teacherRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				teacherRegisterMessage teacher = new teacherRegisterMessage();
				teacher.setId(rs.getInt("id"));
				teacher.setExamine(rs.getInt("examine"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setPeopleId(rs.getString("peopleId"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setEmail(rs.getString("email"));
				teacher.setSchool(rs.getString("school"));
				teacher.setAddress(rs.getString("address"));
				teacher.setZipCode(rs.getString("zipCode"));
				list.add(teacher);
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
	
	/**
	 * 特派员获取审核通过的教师信息接口
	 * @return
	 */
	public ArrayList<teacherRegisterMessage> getExamineTeacherMessage() {
		String sql = "select * from teacher_login_message where examine=1 order by id desc";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<teacherRegisterMessage> list = new ArrayList<teacherRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				teacherRegisterMessage teacher = new teacherRegisterMessage();
				teacher.setId(rs.getInt("id"));
				teacher.setExamine(rs.getInt("examine"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setPeopleId(rs.getString("peopleId"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setEmail(rs.getString("email"));
				teacher.setSchool(rs.getString("school"));
				teacher.setAddress(rs.getString("address"));
				teacher.setZipCode(rs.getString("zipCode"));
				list.add(teacher);
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
	
	/**
	 * 按条件查询教师信息
	 * @param data
	 * @return
	 */
	public ArrayList<teacherRegisterMessage> getTeacherMessageRule(String data) {
		String sql = "";
		JSONObject json = JSONObject .fromObject(data);
		if (json.containsKey("school")) {
			if (json.getString("name").equals("") && json.getString("school").equals("全部")) {
				sql = "select * from teacher_login_message where examine='1'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			} else if (json.getString("name").equals("") && !json.getString("school").equals("全部")) {
				sql = "select * from teacher_login_message where examine='1' and school=" + "'" + json.getString("school") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}else if (!json.getString("name").equals("") && json.getString("school").equals("全部")) {
				sql = "select * from teacher_login_message where examine='1' and name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}else if (!json.getString("name").equals("") && !json.getString("school").equals("全部")) {
				sql = "select * from teacher_login_message where examine='1' and school=" + "'" + json.getString("school") + "'" + " and name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}
		}else {
			if (json.getString("name").equals("") && json.getString("examine").equals("全部")) {
				sql = "select * from teacher_login_message" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			}else if (json.getString("name").equals("") && !json.getString("examine").equals("全部")) {
				if (json.getString("examine").equals("审核通过")) {
					sql = "select * from teacher_login_message where examine='1' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("examine").equals("待审核")) {
					sql = "select * from teacher_login_message where examine='0' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("examine").equals("已拒绝")) {
					sql = "select * from teacher_login_message where examine='2' order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
			} else if (!json.getString("name").equals("") && json.getString("examine").equals("全部")) {
				sql = "select * from teacher_login_message where name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
			} else {
				if (json.getString("examine").equals("审核通过")) {
					sql = "select * from teacher_login_message where examine='1' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("examine").equals("待审核")) {
					sql = "select * from teacher_login_message where examine='0' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				} else if (json.getString("examine").equals("已拒绝")) {
					sql = "select * from teacher_login_message where examine='2' and " + "name=" + "'" + json.getString("name") + "'" + " order by id desc limit " + json.getInt("start") + "," + json.getInt("end");
				}
			}
		}
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<teacherRegisterMessage> list = new ArrayList<teacherRegisterMessage>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				teacherRegisterMessage teacher = new teacherRegisterMessage();
				teacher.setId(rs.getInt("id"));
				teacher.setExamine(rs.getInt("examine"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setPeopleId(rs.getString("peopleId"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setEmail(rs.getString("email"));
				teacher.setSchool(rs.getString("school"));
				teacher.setAddress(rs.getString("address"));
				teacher.setZipCode(rs.getString("zipCode"));
				list.add(teacher);
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
	
	public ArrayList<gameIssue> getGameIssueMessage() {
		String sql = "select * from game_issue order by id desc limit 0,1";
		//System.out.println(sql);
		conn = jdbc.getConn();
		ArrayList<gameIssue> list = new ArrayList<gameIssue>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				gameIssue gameIssue = new gameIssue();
				gameIssue.setId(rs.getInt("id"));
				gameIssue.setName(rs.getString("name"));
				gameIssue.setType(rs.getString("type"));
				gameIssue.setTime_start(rs.getString("time_start"));
				gameIssue.setTime_end(rs.getString("time_end"));
				list.add(gameIssue);
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
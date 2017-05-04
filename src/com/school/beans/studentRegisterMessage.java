package com.school.beans;

import net.sf.json.JSONArray;

/**
 * 学生注册信息
 * @author Long
 *
 */
public class studentRegisterMessage {
	private int id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String peopleId;
	private String phone;
	private String email;
	private String school;
	private String grade;
	private String language;
	private String teacherName;
	private String entryType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	@Override
	public String toString() {
		return "{\"id\" : \"" + id + "\","
				+ "\"username\" : \"" + username + "\","
						+ "\"password\" : \"" + password + "\","
								+ "\"name\" : \"" + name + "\","
										+ "\"sex\" : \"" + sex + "\","
												+ "\"peopleId\" : \"" + peopleId + "\","
														+ "\"phone\" : \"" + phone + "\","
																+ "\"email\" : \"" + email + "\","
																		+ "\"school\" : \"" + school + "\","
																				+ "\"grade\" : \"" + grade + "\","
																						+ "\"language\" : \"" + language + "\","
																								+ "\"teacherName\" : \"" + teacherName + "\","
																										+ "\"entryType\" : \"" + entryType + "\"}";
	}
	
}

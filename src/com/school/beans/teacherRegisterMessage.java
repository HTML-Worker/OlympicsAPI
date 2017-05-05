package com.school.beans;

import java.util.ArrayList;

import net.sf.json.JSONObject;

public class teacherRegisterMessage {
	private int id;
	private int examine;//审核状态
	private String username;
	private String password;
	private String name;
	private String sex;
	private String peopleId;
	private String phone;
	private String email;
	private String school;
	private String address;
	private String zipCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExamine() {
		return examine;
	}
	public void setExamine(int examine) {
		this.examine = examine;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
																				+ "\"address\" : \"" + address + "\","
																						+ "\"zipCode\" : \"" + zipCode + "\","
																								+ "\"examine\" : \"" + examine + "\"}";
	}
	
	/**
	 * 生成数据录入的list格式方便拼装sql语言
	 * @param json
	 * @return
	 */
	public ArrayList<Object> pushData(JSONObject json) {
		ArrayList<Object> list = new  ArrayList<>();
		list.add(0);
		list.add("'" + json.getString("username") + "'");
		list.add("'" + json.getString("password") + "'");
		list.add("'" + json.getString("name") + "'");
		list.add("'" + json.getString("sex") + "'");
		list.add("'" + json.getString("peopleId") + "'");
		list.add("'" + json.getString("phone") + "'");
		list.add("'" + json.getString("email") + "'");
		list.add("'" + json.getString("school") + "'");
		list.add("'" + json.getString("address") + "'");
		list.add("'" + json.getString("zipCode") + "'");
		list.add(0);//审核状态默认为0
		//System.out.println(list);
		return list;
		
	}
}

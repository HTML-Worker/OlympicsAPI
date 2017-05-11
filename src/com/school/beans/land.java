package com.school.beans;

import java.util.ArrayList;

import net.sf.json.JSONObject;

public class land {
	private int id;
	private String identity;
	private int landing;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public int getLanding() {
		return landing;
	}
	public void setLanding(int landing) {
		this.landing = landing;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "{ \"id\" : \"" + id + "\", "
				+ "\"username\" : \"" + username + "\", "
						+ "\"identity\" :\"" + identity + "\", "
								+ "\"landing\" : \"" + landing + "\"}";
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
		list.add("'" + json.getString("identity") + "'");
		list.add(1);
		//System.out.println(list);
		return list;
	}
}

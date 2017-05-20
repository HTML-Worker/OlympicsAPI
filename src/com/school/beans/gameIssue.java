package com.school.beans;

import java.util.ArrayList;

import net.sf.json.JSONObject;

public class gameIssue {
	private int id;
	private String name;
	private String type;
	private String time_start;
	private String time_end;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	@Override
	public String toString() {
		return "{ \"id\" : \"" + id + "\", "
				+ "\"name\" : \"" + name + "\", "
					+ "\"type\" : \"" + type + "\", "
						+ "\"time_start\" : \"" + time_start + "\", "
							+ "\"time_end\" :\"" + time_end + "\"}";
	}
	
	public ArrayList<Object> pushData(JSONObject json) {
		ArrayList<Object> list = new  ArrayList<>();
		list.add(0);
		list.add("'" + json.getString("name") + "'");
		list.add("'" + json.getString("type") + "'");
		list.add("'" + json.getString("time_start") + "'");
		list.add("'" + json.getString("time_end") + "'");
		return list;
	}
	
}

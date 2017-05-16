package com.school.beans;

public class backMessage {
	private boolean flag;
	private String message;
	private String name;
	private int examine;
	
	public int getExamine() {
		return examine;
	}
	public void setExamine(int examine) {
		this.examine = examine;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "{ \"flag\" : \"" + flag + "\", "
				+ "\"message\" : \"" + message + "\", "
					+ "\"examine\" : \"" + examine + "\", "
							+ "\"name\" :\"" + name + "\"}";
	}
}

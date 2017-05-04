package com.school.beans;

public class document {
	private String id;
	private String title;
	private String content;
	private String count;
	private String time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "{ \"id\" : \"" + id + "\", "
				+ "\"title\" : \"" + title + "\", "
						+ "\"content\" :\"" + content + "\", "
								+ "\"count\" : \"" + count + "\" , "
										+ "\"time\" :\"" + time + "\"}";
	}
	
	
}

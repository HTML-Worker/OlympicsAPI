package com.school.beans;

public class about {
	private String about_id;
	private String about_title;
	private String about_content;
	private String about_time;
	
	public String getAbout_id() {
		return about_id;
	}
	public void setAbout_id(String about_id) {
		this.about_id = about_id;
	}
	public String getAbout_title() {
		return about_title;
	}
	public void setAbout_title(String about_title) {
		this.about_title = about_title;
	}
	public String getAbout_content() {
		return about_content;
	}
	public void setAbout_content(String about_content) {
		this.about_content = about_content;
	}
	public String getAbout_time() {
		return about_time;
	}
	public void setAbout_time(String about_time) {
		this.about_time = about_time;
	}
	
	@Override  
    public String toString() {
        return "{ \"aboutId\" : \"" + about_id + "\", \"aboutTitle\" : \"" + about_title + "\", \"aboutContent\" :\""  
                + about_content + "\", \"aboutTime\" :\"" + about_time + "\"}";
    }

}

package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.school.beans.teacherRegisterMessage;
import com.school.service.insert;
import com.school.service.select;
import com.school.service.update;

@Path("TeacherMessage")
public class TeacherMessageServices {
	
	/**
	 * 录入教师信息
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postStudentMessage(String data) {
        //System.out.println(data);
        insert student = new insert();
        student.getTeacherAllMessage(data);
        return "200";
    }
	
	/**
	 * 教师信息获取接口
	 * @param name
	 * @return
	 */
	@GET
	@Path("/teacherMessage/{name}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent(@PathParam("name") String name) {
		select select = new select();
		ArrayList<teacherRegisterMessage> list = select.getTeacherMessage(name);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	@POST
	@Path("/teacherPEChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPE(String data) {
        //System.out.println(data);
        update teacher = new update();
        String message = teacher.changeTeacherPE(data);
        return message;
    }
	
	/**
	 * 教师密码修改接口
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherPasswordChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPassword(String data) {
        //System.out.println(data);
        update teacher = new update();
        String message = teacher.changeTeacherPassword(data);
        return message;
    }
}
package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.school.beans.teacherRegisterMessage;
import com.school.service.delete;
import com.school.service.insert;
import com.school.service.select;
import com.school.service.update;

@Path("TeacherMessage")
public class TeacherMessageServices {
	
	/**
	 * ¼���ʦ��Ϣ
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postTeacherMessage(String data) {
        //System.out.println(data);
        insert student = new insert();
        student.getTeacherAllMessage(data);
        return "200";
    }
	
	/**
	 * ��ʦ��Ϣ��ȡ�ӿ�
	 * @param name
	 * @return
	 */
	@GET
	@Path("/teacherMessage/{name}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getTeacherMessage(@PathParam("name") String name) {
		select select = new select();
		ArrayList<teacherRegisterMessage> list = select.getTeacherMessage(name);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	/**
	 * ��ʦ�绰������Ϣ�޸�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherPEChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeTeacherPE(String data) {
        //System.out.println(data);
        update teacher = new update();
        String message = teacher.changeTeacherPE(data);
        return message;
    }
	
	/**
	 * ��ʦ�����޸Ľӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherPasswordChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeTeacherPassword(String data) {
        //System.out.println(data);
        update teacher = new update();
        String message = teacher.changeTeacherPassword(data);
        return message;
    }
	
	/**
	 * ��ѯ���н�ʦ��Ϣ
	 * @return
	 */
	@GET
	@Path("/allTeacherMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String  getAllTeacherMessage() {
		select select = new select();
		ArrayList<teacherRegisterMessage> list = select.getAllTeacherMessage();
		//System.out.println(list);
		return ""+ list +"";
	}
	
	/**
	 * ��������ѯ��ʦ��Ϣ
	 * @param data
	 * @return
	 */
	@POST
	@Path("/getTeacherMessageRule")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String  getTeacherMessageRule(String data) {
		select select = new select();
		ArrayList<teacherRegisterMessage> list = select.getTeacherMessageRule(data);
		//System.out.println(list);
		return ""+ list +"";
	}
	
	/**
	 * ��������ѯ��ʦ��Ϣ
	 * @param data
	 * @return
	 */
	@GET
	@Path("/getExamineTeacherMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String  getExamineTeacherMessage() {
		select select = new select();
		ArrayList<teacherRegisterMessage> list = select.getExamineTeacherMessage();
		//System.out.println(list);
		return ""+ list +"";
	}
	
	/**
	 * ��ʦ���״̬�޸Ľӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/teacherExamine")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String changeTeacherExamine(String data) {
		update update = new update();
		String message = update.changeTeacherExamine(data);
		//System.out.println(list);
		return message;
	}
	
	@POST
	@Path("/deleteTeacherMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String deleteTeacherMessage(String data) {
        //System.out.println(data);
        delete teacher = new delete();
        String message = teacher.deleteTeacherMessage(data);
        return message;
    }
}
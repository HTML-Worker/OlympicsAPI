package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.school.beans.studentRegisterMessage;
import com.school.service.select;
import com.school.service.update;
import com.school.service.delete;
import com.school.service.insert;

@Path("StudentMessage")
public class StudentMessageServices {
	
	/**
	 * ѧ����Ϣ¼��ӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/studentMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postStudentMessage(String data) {
        //System.out.println(data);
        insert student = new insert();
        student.getStudentAllMessage(data);
        return "200";
    }
	
	/**
	 * ѧ����Ϣ��ȡ�ӿ�
	 * @param name
	 * @return
	 */
	@GET
	@Path("/studentMessage/{name}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getStudentMessage(@PathParam("name") String name) {
		select select = new select();
		ArrayList<studentRegisterMessage> list = select.getStudentMessage(name);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	/**
	 * ��Ҫ���ѯѧ����Ϣ
	 * @param data
	 * @return
	 */
	@POST
	@Path("/allStudentMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String  getAllStudentMessage(String data) {
		select select = new select();
		ArrayList<studentRegisterMessage> list = select.getAllStudentMessage(data);
		//System.out.println(list);
		return ""+ list +"";
	}
	
	/**
	 * ѧ�������޸Ľӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/studentPasswordChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPassword(String data) {
        //System.out.println(data);
        update student = new update();
        String message = student.changeStudentPassword(data);
        return message;
    }
	
	/**
	 * ɾ��ѧ����Ϣ�ӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/deleteStudentMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String deleteStudentMessage(String data) {
        //System.out.println(data);
        delete student = new delete();
        String message = student.deleteStudentMessage(data);
        return message;
    }
	
	/**
	 * ѧ���绰�������ַ�޸Ľӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/studentPEChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPE(String data) {
        //System.out.println(data);
        update student = new update();
        String message = student.changeStudentPE(data);
        return message;
    }
	
	/**
	 * ѧ������״̬�޸Ľӿ�
	 * @param data
	 * @return
	 */
	@POST
	@Path("/changeStudentPay")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPay(String data) {
        //System.out.println(data);
        update student = new update();
        String message = student.studentPayChange(data);
        return message;
    }
}

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
	 * 学生信息录入接口
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
	 * 学生信息获取接口
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
	 * 按要求查询学生信息
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
	 * 学生密码修改接口
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
	 * 删除学生信息接口
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
	 * 学生电话及邮箱地址修改接口
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
	 * 学生报名状态修改接口
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

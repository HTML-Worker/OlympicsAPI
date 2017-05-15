package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.school.beans.adminMessage;
import com.school.service.select;
import com.school.service.update;

@Path("AdminMessage")
public class adminMessageServices {
	/**
	 * 特派员信息获取接口
	 * @param name
	 * @return
	 */
	@GET
	@Path("/adminMessage/{name}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent(@PathParam("name") String name) {
		select select = new select();
		ArrayList<adminMessage> list = select.getAdminMessage(name);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	/**
	 * 特派员基本信息修改接口
	 * @param data
	 * @return
	 */
	@POST
	@Path("/adminPEChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeStudentPE(String data) {
        //System.out.println(data);
        update admin = new update();
        String message = admin.changeAdminPE(data);
        return message;
    }
	
	@POST
	@Path("/adminPasswordChange")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String changeAdminPassword(String data) {
        //System.out.println(data);
        update admin = new update();
        String message = admin.changeAdminPassword(data);
        return message;
    }
}

/**
 * 
 */
/**
 * @author Long
 *
 */
package com.school.restws;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.school.beans.idtest;
import com.school.service.select;

/**
 * 
 * @author pavithra
 * 
 */

// ����@Path��������Ĳ��·����
// ָ������Դ���ṩ�����URI·����
@Path("UserInfoService")
public class UserInfo {

	// @GET��ʾ�����ᴦ��HTTP GET����
	@GET
	// ����@Path��������Ĳ��·����ָ������Դ���ṩ�����URI·����
	@Path("/name")
	// @Produces��������Դ�෽�������ɵ�ý�����͡�
	@Produces(MediaType.TEXT_XML)
	// @PathParam��@Path����ı��ʽע��URI����ֵ��
	public String userName() {

		return "<User>" + "<Name>" + "abc" + "</Name>" + "</User>";
	}

	@GET
	@Path("/age/{j}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String userAge(@PathParam("j") int j, @QueryParam("callback") String jsonpcallback) {

		int age = j;
		// return "<User>" + "<Age>" + age + "</Age>" + "</User>";
		return jsonpcallback + "(" + j + ")";
	}

	@GET
	@Path("/getUserJsonp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserJsonp(@QueryParam("data") String data, @QueryParam("callback") String jsonpcallback) {
		// System.out.println("data="+ data);
		// System.out.println("jsonpcallback="+ jsonpcallback);
		select select = new select();
		ArrayList<idtest> arrayList = select.getDBMessage();
		idtest dbMessage = arrayList.get(0);
	    System.out.println(dbMessage.getId());
		User user = new User();
		user.setAge("27");
		user.setUserId("005");
		user.setUserName("Fmand");
		// return jsonpcallback+"( {\"id\":\"1001\"})";
		return jsonpcallback + "(" + user.toString() + ")";
	}
}
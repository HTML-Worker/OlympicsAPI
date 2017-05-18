/**
 * 
 */
/**
 * @author Long
 *
 */
package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import com.school.beans.document;
import com.school.beans.newsNotes;
import com.school.beans.teacherRegisterMessage;
import com.school.service.select;
import com.school.service.update;

/**
 * 
 * @author pavithra
 * 
 */

// ����@Path��������Ĳ��·����
// ָ������Դ���ṩ�����URI·����
@Path("UserInfoService")
public class UserInfo {

	/**
	 * ����ҳ�水title��ѯ���¾������ݽӿ�
	 * @param name
	 * @param id
	 * @return
	 */
	@GET
	@Path("/document/{name}/{id}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent(@PathParam("name") String name, @PathParam("id") int id) {
		select select = new select();
		ArrayList<document> list = select.getContent(name, id);
		update update = new update();
		update.changeCount(name, id);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	/**
	 * �ȵ����±����ѯ�ӿ�
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	@GET
	@Path("/title/{name}/{statr}/{end}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	public String  getHotSpotTitle(@PathParam("name") String name, @PathParam("start") int start, @PathParam("end") int end) {
		select select = new select();
		ArrayList<document> list = select.getDocumentTitle(name, start, end);
		//System.out.println(name + start + end);
		return ""+ list +"";
	}
	
	/**
	 * ���ż��ش��¼����½ӿ�
	 * @param name
	 * @param id
	 * @return
	 */
	@GET
	@Path("/newsNotes/{id}")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent(@PathParam("id") int id) {
		select select = new select();
		ArrayList<newsNotes> list = select.getContent(id);
		//System.out.println(name + id);
		return ""+ list +"";
	}
	
	/**
	 * ��������ѯtitle
	 * @return
	 */
	@POST
	@Path("/searchTitle")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  searchTitle(String data) {
		select select = new select();
		ArrayList<document> list = select.searchTitle(data);
		//System.out.println(data);
		return ""+ list +"";
	}

}
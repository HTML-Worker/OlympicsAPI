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

// 这里@Path定义了类的层次路径。
// 指定了资源类提供服务的URI路径。
@Path("UserInfoService")
public class UserInfo {

	/**
	 * 关于页面按title查询文章具体内容接口
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
	 * 热点文章标题查询接口
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
	 * 新闻及重大事件文章接口
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
	 * 按条件查询title
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
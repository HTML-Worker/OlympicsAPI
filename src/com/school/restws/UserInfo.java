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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.school.beans.about;
import com.school.service.select;

/**
 * 
 * @author pavithra
 * 
 */

// 这里@Path定义了类的层次路径。
// 指定了资源类提供服务的URI路径。
@Path("UserInfoService")
public class UserInfo {

//	@GET
//	@Path("/aboutTitle")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getAboutTitle(@QueryParam("callback") String data, @QueryParam("callback") String jsonpcallback) {
//		// System.out.println("data="+ data);
//		// System.out.println("jsonpcallback="+ jsonpcallback);
//		select select = new select();
//		ArrayList<about> list = select.getAbout();
//		//System.out.println(list);
//		return jsonpcallback + "(" + list + ")";
//	}
	
	@GET
	@Path("/aboutTitle")
	@Produces({MediaType.APPLICATION_JSON})
	public String  getAboutTitle() {
		select select = new select();
		ArrayList<about> list = select.getAbout();
		//System.out.println(list);
		return ""+ list +"";
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String  getAboutID(@PathParam("id") int id) {
//		select select = new select();
//		ArrayList<about> list = select.getAbout();
		System.out.println(id);
		return ""+ id +"";
	}
}
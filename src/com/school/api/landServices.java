package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.school.beans.backMessage;
import com.school.beans.land;
import com.school.service.select;
import com.school.service.insert;

@Path("LandMessage")
public class landServices {
	@POST
	@Path("/land")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postLand(String data) {
        //System.out.println(data);
		select select = new select();
		ArrayList<backMessage> message = select.checkLang(data);
        return "" + message + "";
    }
	
	@POST
	@Path("/loginIn")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String pushLoginData(String data) {
        //System.out.println(data);
		insert updata = new insert();
		updata.pushLoginData(data);
		return "success";
    }
	
	/**
	 *ÒÑµÇÂ¼ÕËºÅ»ñÈ¡
	 * @param name
	 * @param id
	 * @return
	 */
	@GET
	@Path("/loginIned")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent() {
		select select = new select();
		ArrayList<land> list = select.getLogined();
		return ""+ list +"";
	}
}

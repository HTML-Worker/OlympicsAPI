package com.school.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.school.beans.gameIssue;
import com.school.service.insert;
import com.school.service.select;
import com.school.service.update;

@Path("GameIssue")
public class gameIssueServices {
	
	/**
	 * 发布新赛事接口
	 * @param data
	 * @return
	 */
	@POST
	@Path("/newGameIssue")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postLand(String data) {
        //System.out.println(data);
		insert insert = new insert();
		String message = insert.pushGameIssue(data);
		if(message.equals("success")) {
			update update = new update();
			update.allStudentPayChange();
		}else {
			message = "fales";
		}
        return message;
    }
	
	/**
	 * 获取赛事信息接口
	 * @return
	 */
	@GET
	@Path("/getGameIssue")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.TEXT_PLAIN_TYPE})
	@Consumes("application/x-www-form-urlencoded")
	public String  getContent() {
		select select = new select();
		ArrayList<gameIssue> list = select.getGameIssueMessage();
		return ""+ list +"";
	}
}

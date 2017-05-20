package com.school.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.school.service.insert;
import com.school.service.update;

@Path("GameIssue")
public class gameIssueServices {
	
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
}

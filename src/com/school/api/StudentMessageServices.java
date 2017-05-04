package com.school.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.school.service.updata;

@Path("StudentMessage")
public class StudentMessageServices {
	
	@POST
	@Path("/studentMessage")
	@Produces("text/plain;charset=gbk")
	//@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
    public String postStudentMessage(String data) {
        System.out.println(data);
        updata student = new updata();
        student.getStudentAllMessage(data);
        //student.getStudentAllMessage(data);
        
        return "123";
    }  
}

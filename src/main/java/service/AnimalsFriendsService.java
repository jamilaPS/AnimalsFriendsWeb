package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sun.research.ws.wadl.Application;

@Path("/AnimalsFriends")
@ApplicationPath("/resource")
public class AnimalsFriendsService extends Application{
	
	@GET
	@Path("/hello")
	public String getHello() {
		return "Hello Web Service";
	}

}

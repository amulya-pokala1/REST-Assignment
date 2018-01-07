package com.accolite.mini_au.Messgener.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.accolite.mini_au.Messgener.model.Profile;
import com.accolite.mini_au.Messgener.service.ProfileService;

@Path("messages")
public class ProfileResource {
	ProfileService pf=new ProfileService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getMessageFromService() throws ClassNotFoundException, SQLException
	{
		return pf.getProfile();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public Profile getProfile(@PathParam("name") String name) throws ClassNotFoundException, SQLException
	{
		return pf.getProfile(name);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public String addProfile(Profile profile) throws ClassNotFoundException, SQLException
	{
		return pf.addnewProfile(profile)?"success":"fail";
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public boolean updateProfile(@PathParam("name") String name, Profile profile) throws ClassNotFoundException, SQLException
	{
		return pf.update(name,profile );
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public String deleteProfile(@PathParam("name") String name) throws ClassNotFoundException, SQLException
	{
		if(pf.deleteProfile(name)) return "deleted successfully";
		return "failed to delete profile";
	}
}
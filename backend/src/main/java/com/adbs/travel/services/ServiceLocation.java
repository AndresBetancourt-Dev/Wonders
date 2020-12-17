package com.adbs.travel.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adbs.travel.dao.LocationDAO;
import com.adbs.travel.exceptions.DatabaseException;
import com.adbs.travel.models.Location;

@Path("locations")
public class ServiceLocation {
	
	private LocationDAO locationDAO;
	
	public ServiceLocation() {
		locationDAO = new LocationDAO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocations(){
		List<Location> list;
		try {
			list = locationDAO.getLocations();
			return Response.ok(list).build();
		} catch (DatabaseException e) {
			e.printStackTrace();		
		}
		return Response.serverError().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertLocation(Location location){
		try {
			locationDAO.insertLocation(location);
			return Response.accepted().build();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
}

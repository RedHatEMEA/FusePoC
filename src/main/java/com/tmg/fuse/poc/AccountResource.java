package com.tmg.fuse.poc;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.util.log.Log;

@Path("/accountservice")
public class AccountResource {


public AccountResource() {
}

	@GET
	@Path("/accounts/{id}")
	public Account getAccount(@PathParam("id") String id) {
		
		
		return null;
	}
	
	@PUT
	@Path("/accounts")
	public Response createAccount(Account account) {
		
		return null;
		
	}
}

package com.tmg.fuse.poc;



import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.tmg.fuse.poc.account.AccountDetails;

@Path("/accountservice/")
public class AccountResource {

    // NOTE: The instance member variables will not be available to the
    // Camel Exchange. They must be used as method parameters for them to
    // be made available
    @Context
    private UriInfo uriInfo;

    public AccountResource() {
    }

    @GET
    @Path("/account/{id}/")
    @Produces("application/json")
    public AccountDetails retrieveAccount(@PathParam("id") String id) {
        return null;
    }

    @PUT
    @Path("/account")
    @Produces("text/xml")
    public Response createAccount(Account account) {
        return null;
    }
}

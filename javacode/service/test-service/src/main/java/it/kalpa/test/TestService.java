package it.kalpa.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("testbody")
public class TestService {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response checkBody(@FormParam("parameter") String parameter) {
		if (parameter == null || parameter.isEmpty())
			return Response.status(Status.BAD_REQUEST).build();
		return Response.ok().build();
	}

}

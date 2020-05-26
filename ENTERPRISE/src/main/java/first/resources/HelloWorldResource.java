package first.resources;

import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
@Api("Hello World Resource")
public class HelloWorldResource {

    @GET
    public String getHelloWorld() { return "Hello World"; }

    @GET
    @Path("ok")
    public Response ok(@QueryParam("lastname") String lastname) {
        return Response.ok().entity(lastname).build();
    }

    @GET
    @Path("/hello/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response hello(@PathParam("id") String id) {
        return Response.ok().entity("<hello>HALLO" + id + "</hello>").build();
    }

    @GET
    @Path("/error")
    public Response get() {
        return Response.serverError().entity("Er ging iets mis!").build();
    }
}

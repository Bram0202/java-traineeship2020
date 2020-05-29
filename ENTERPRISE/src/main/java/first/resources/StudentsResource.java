package first.resources;

import first.domain.Student;
import first.domain.Students;
import first.services.StudentService;
import io.swagger.annotations.Api;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Api("Students Resource")
@SessionScoped
public class StudentsResource implements Serializable {

    @Inject
    private StudentService studentService;

    // CREATE
    @POST // create
    public Student post(Student student) {
        return studentService.add(student);
    }

    // READ
    @GET
    @Path("{id}")
    public Student get(@PathParam("id") int id) {
        return studentService.get(id);
    }

    @GET @Path("q")
    public Students get(@QueryParam("lastname") String lastname) {
        return studentService.find(lastname);
    }

    @GET
    public Students getAll() { return studentService.getAll(); }

    // UPDATE
    // Not yet implemented...
    // TODO: implement Update

    // DELETE
    @DELETE
    @Path("{id}")
    public Student delete(@PathParam("id") int id) {
        return studentService.remove(id);
    }

}

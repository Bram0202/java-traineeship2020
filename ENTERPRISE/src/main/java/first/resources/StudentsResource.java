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
    @POST
    public Student post(Student student) {
        if (studentService.add(student)) {
            return student;
        }
        throw new RuntimeException("Student not added.");
    }

    // DELETE
    @DELETE
    @Path("{id}")
    public Student delete(@PathParam("id") int id) {
        return studentService.remove(id);
    }

}

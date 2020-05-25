package first.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/helloworld")
public class HelloWorldResource {

    private List<Student> students;

    @GET
    public String getHelloWorld() {
        return "Hallo World!";
    }

    @POST
    @Path("/post")
    public Student post(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(student);
        System.out.println("students.size()=" + students.size());
        return student;
    }
}

package first.resources;

import first.App;
import first.domain.Students;
import first.services.StudentService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class StudentResourceIT {

    @ArquillianResource
    private URL deploymentURL;

    private String studentsResource;

    @Before
    public void setup() {
        studentsResource = deploymentURL + "resources/students";
    }

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(App.class)
                .addClass(StudentService.class)
                .addPackage(StudentsResource.class.getPackage())
                .addPackage(Students.class.getPackage());
    }
    @Test
    public void getStudentsReturnsStudents() {
        System.out.println("studentsResource=" + studentsResource);
        String message = ClientBuilder.newClient()
                .target(studentsResource)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println(message);

        assertThat(message, containsString("{\"students\":["));
    }

}

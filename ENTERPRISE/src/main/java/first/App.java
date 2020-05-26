package first;

import com.github.phillipkruger.apiee.ApieeService;
import first.resources.HelloWorldResource;
import first.resources.StudentsResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("resources")
public class App extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(
                StudentsResource.class,
                HelloWorldResource.class,
                // add more resources here...
                ApieeService.class
        ));
    }
}

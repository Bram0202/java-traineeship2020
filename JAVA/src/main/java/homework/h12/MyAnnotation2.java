package homework.h12;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MyAnnotation2 {
    String value() default "Hello2";
}

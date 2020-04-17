package homework.h12;

import homework.h10.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;

@MyAnnotation
public class Main {

    @MyAnnotation
    @MyAnnotation2
    public static void main(String[] args) {
        new Main();
    }

    Main() {
        printAnnotatedClasses();
        printAnnotatedMethods();
    }

    void printAnnotatedClasses() {
        Class[] declaredClasses = Person.class.getDeclaredClasses();

        for (Class clazz : declaredClasses) {
            Annotation[] declaredAnnotations = clazz.getAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println("Class: " + clazz.getName());
                System.out.println("Annotation: " + declaredAnnotation.toString() + "\n");
            }
        }
    }

    void printAnnotatedMethods() {
        Method[] declaredMethods = Person.class.getDeclaredMethods();

        for (Method method : declaredMethods) {
            Annotation[] declaredAnnotations = method.getAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println("Method: " + method.getName());
                System.out.println("Annotation: " + declaredAnnotation.toString() + "\n");
            }
        }
    }

}

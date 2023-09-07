package pl.nobleprog.advanced.day4.c2reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Class class

        // instantiate objects by reflection
        Foo foo = createObjectByReflection(Foo.class,"bar");
        System.out.println("Value of 'bar' field: " + foo.bar);

        // calling method by reflection
        invokeMethod(foo,"print", "Hello");

        // scanning object fields by reflection
        readAllFields(foo);
    }

    public static <T> T createObjectByReflection(Class<T> clazz, String param) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor(String.class).newInstance(param);
    }

    public static void invokeMethod(Object obj, String methodName, String parameter) throws InvocationTargetException, IllegalAccessException {
        final Optional<Method> method = Arrays.stream(obj.getClass().getDeclaredMethods())
                .peek(m -> System.out.printf("%s %s\n",m.getName(), m.getModifiers()))
                .filter(m -> Objects.equals(m.getName(), methodName))
                .findAny();
        if (method.isEmpty()){
            System.out.printf("Can't call method '%s', ", methodName);
            return;
        }
        Method m = method.get();
        if (m.getModifiers() != Modifier.PUBLIC) {
            m.setAccessible(true);
        }
        m.invoke(obj, parameter);
    }

    public static void readAllFields(Object obj){
        System.out.println("Field list: ");
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Arrays.stream(declaredFields)
                .map(Field::getName)
                .forEach(System.out::println);
    }
}

class Foo{
    public String bar;
    // instance block
    {
        // System.setSecurityManager(new SecurityManager());
    }
    public Foo() {

    }

    public Foo(String bar) {
        this.bar = bar;
    }

    private void print(String param){
        System.out.printf("Calling method with param: %s\n", param);
    }

}

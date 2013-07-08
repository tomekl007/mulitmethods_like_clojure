import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 7/8/13
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArgPolym {
    Object invokeIfArgumentHasSuchMethod( Object arg1, String methodName) throws IllegalAccessException, InstantiationException, InvocationTargetException, ArgDontHaveSuchMethod {

        //Class<?> testClass = Class.forName(nameOfClass);
        Class<?> testClass = arg1.getClass();
       // Object object = testClass.newInstance();
        // Sample s = new Sample();


        for (Method m : testClass.getDeclaredMethods()) {
            if (m.getName().equals(methodName)) {

                System.out.println("this obj have method : " + methodName);
                Object result = m.invoke(arg1);
                return result;
            }
        }
        //return this;
        throw new ArgDontHaveSuchMethod("Class : " + testClass + " dont have method  : " + methodName);


    }
}


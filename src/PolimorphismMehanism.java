import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 7/8/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class PolimorphismMehanism {

     boolean shouldInvokeIfHasMethod( String nameOfMethod) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Class<?> testClass = Class.forName(nameOfClass);
         Class<?> testClass = this.getClass();
        Object object = testClass.newInstance();
        // Sample s = new Sample();


        for (Method m : testClass.getDeclaredMethods()) {
            if(m.getName().equals(nameOfMethod) ){

            System.out.println("this obj have method : " + nameOfMethod);
            m.invoke(object);
            return true;
            }
        }
        return false;

  }
}



import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 7/8/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, ArgDontHaveSuchMethod {

        MyObj myObj = new MyObj();
        //PolimorphismMehanism pm = new PolimorphismMehanism();
        //pm.shouldInvokeIfHasMethod(MyObj.class, "method1");

        ArgPolym myObj3 = new MyObj3();
        //myObj3.shouldInvokeIfHasMethod("method3");

        PolimorphismMehanism myObj2 = new MyObj2();

       //  myObj3.shouldInvokeIfHasMethod("method2");
         myObj2.shouldInvokeIfHasMethod("method2");
        OperationMultiply operationMultiply = new OperationMultiply<Integer>();
        System.out.println(operationMultiply.multiply(new MyObj(), 2));

        myObj3.invokeIfArgumentHasSuchMethod(myObj, "method1");
        //System.out.println(o);
        System.out.println("normal flow");
    }



}

class MyObj{
    void method1() {
        System.out.println("method1");
    }
    /*int intValue(){
        return 1;
    }        */
}

class MyObj2 extends  PolimorphismMehanism{
    void method2(){
        System.out.println("method2");
    }
}


class MyObj3 extends ArgPolym{
           void method3(){
               System.out.println("method3");
           }
}

class OperationSum extends PolimorphismMehanism{
    int add(int x, int y){
        return x + y;

    }
}

class OperationMultiply <T> extends ArgPolym{
      Integer multiply(T firstOperand, T secondOperand) throws IllegalAccessException, InvocationTargetException, InstantiationException {


          Integer value1 = null;
          Integer value2 = null;
          try {
              value1 = (Integer) this.invokeIfArgumentHasSuchMethod(firstOperand, "intValue");
              value2 = (Integer) this.invokeIfArgumentHasSuchMethod(secondOperand,"intValue");
          } catch (ArgDontHaveSuchMethod argDontHaveSuchMethod) {
              argDontHaveSuchMethod.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
              return 0;
          }

        return value1 * value2 ;

        }
}




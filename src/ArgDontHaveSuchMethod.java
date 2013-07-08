/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 7/8/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArgDontHaveSuchMethod extends Exception {

    String message;

    public ArgDontHaveSuchMethod(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;//To change body of overridden methods use File | Settings | File Templates.
    }
}

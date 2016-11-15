/**
 * Created by soffietto on 15.11.16.
 */
public class ErrorLogger extends Logger {

    public ErrorLogger(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

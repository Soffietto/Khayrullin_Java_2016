/**
 * Created by soffietto on 15.11.16.
 */
public class InfoLogger extends Logger {

    public InfoLogger(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

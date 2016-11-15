/**
 * Created by soffietto on 15.11.16.
 */
public class WarnLogger extends Logger {
    public WarnLogger(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("WARNING: " + message);
    }
}

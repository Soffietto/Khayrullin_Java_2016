/**
 * Created by soffietto on 15.11.16.
 */
public class ErrorLogger extends Logger {

    Logger next = new InfoLogger();

    @Override
    void writeMessage() {
        System.out.println("ERROR: " + message);
        if(next != null){
            next.writeMessage();
        }
    }
}

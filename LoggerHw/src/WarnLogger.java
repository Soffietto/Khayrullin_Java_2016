/**
 * Created by soffietto on 15.11.16.
 */
public class WarnLogger extends Logger {

    Logger next=null;

    @Override
    void writeMessage() {
        System.out.println("WARN: " + message);
        if(next != null){
            next.writeMessage();
        }
    }
}

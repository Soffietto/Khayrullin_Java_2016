/**
 * Created by soffietto on 15.11.16.
 */
public class InfoLogger extends Logger {

    Logger next=null;

    @Override
    void writeMessage()  {
        System.out.println("INFO: " + message);
        if(next != null){
            next.writeMessage();
        }
    }
}

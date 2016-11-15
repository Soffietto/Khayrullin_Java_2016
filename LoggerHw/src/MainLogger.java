/**
 * Created by soffietto on 15.11.16.
 */
public class MainLogger{
    private static String message;

    public static String getMessage() {
        return message;
    }

    public void log(String level, String someMessage){
        message = someMessage;
        switch (level){
            case "ERROR":
                new ErrorLogger().writeMessage();
                break;
            case "WARN":
                new WarnLogger().writeMessage();
                break;
            case "INFO":
                new InfoLogger().writeMessage();
                break;
        }
    }
}

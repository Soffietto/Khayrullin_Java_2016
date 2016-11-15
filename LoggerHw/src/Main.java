/**
 * Created by soffietto on 15.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger(Level.ERROR);
        Logger warnLogger = new WarnLogger(Level.WARN);
        Logger infoLogger = new InfoLogger(Level.INFO);

        errorLogger.setNext(infoLogger);

        errorLogger.writemessage("Сообщение из ERROR-логгера", Level.ERROR);
        warnLogger.writemessage("Сообщение из WARN-логгера", Level.WARN);
        infoLogger.writemessage("Сообщение из INFO-логгера", Level.INFO);
    }

}

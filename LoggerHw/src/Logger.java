/**
 * Created by soffietto on 15.11.16.
 */
public abstract class Logger {
    int priority;

    public Logger(int priority) {
        this.priority = priority;
    }

    Logger next;

    public void setNext(Logger next){
        this.next=next;
    }

    public void writemessage(String message, int level){
        if(level <= priority){
            write(message);
        }
        if(next != null){
            next.writemessage(message, level);
        }
    }

    protected abstract void write(String message);

}

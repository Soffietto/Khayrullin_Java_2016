public abstract class Logger {

    protected String level;
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public void log(String message) {
        if (this.level.equals(getLevel(message))) {
            String[] s = message.split(" : ");
            String text = s[1];
            if (next != null) {
                next.log(message);
            }
            writeMessage(text);
        } else {
            if (next != null) {
                next.log(message);
            }
        }
    }

    private String getLevel(String message) {
        String[] s = message.split(" : ");
        String pr = s[0];
        pr = pr.substring(1, pr.length() - 1);
        return pr;
    }

    abstract void writeMessage(String message);

}

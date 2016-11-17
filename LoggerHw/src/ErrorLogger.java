public class ErrorLogger extends Logger {

    public ErrorLogger(){
        this.level = "ERROR";
    }

    @Override
    void writeMessage(String message) {
        System.out.println("ERROR: " + message);
    }
}

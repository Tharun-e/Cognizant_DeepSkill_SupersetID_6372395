public class Main {
    public static void main(String[] args) {
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();
        logger1.log("First message");
        logger2.log("Second message");
    }
}
class Logger {
    private static Logger instance=new Logger();
    private Logger() {
        System.out.println("Logger Initialized.");
    }
    public static Logger getInstance() {
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

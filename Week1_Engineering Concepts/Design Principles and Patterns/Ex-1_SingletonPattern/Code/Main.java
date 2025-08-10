public class Main{
    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();
        logger1.log("Message1");
        logger2.log("Message2");
        if(logger1==logger2){
            System.out.println("Singleton");
        } 
        else{
            System.out.println("Not a Singleton");
        }
    }
}
class Logger{
    private static Logger instance=new Logger();
    private Logger(){
        System.out.println("Logger Initialization done.");
    }
    public static Logger getInstance(){
        return instance;
    }
    public void log(String msg){
        System.out.println("Log: " + msg);
    }
}

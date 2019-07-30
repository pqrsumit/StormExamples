import java.util.logging.Logger;

public class ApplicationMain {

    static Logger toLog = Logger.getLogger(ApplicationMain.class.getName());
    public static void main(String[] args) {

        toLog.info("This message is from Application Main" +
                ":: Hello World...");

    }
}

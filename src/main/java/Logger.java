import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance; // единст.объект класса
    protected int num = 1;

    public void log(String msg) {
        LocalDateTime dateTime = LocalDateTime.now(); //текущее время и дата
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("[" + dateTime.format(formatter) + " " + num++ + "] " + msg);
    }

    private Logger() {
    } //запрет пользователям создавать объект

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }
}
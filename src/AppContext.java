import java.util.Scanner;

public class AppContext {
    public static Scanner sc = new Scanner(System.in);

    public static WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static WiseSayingService wiseSayingService = new WiseSayingService();
    public static WiseSayingController wiseSayingController = new WiseSayingController();
    public static SystemController systemController = new SystemController();
}

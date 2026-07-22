import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    String cmd = "";
    WiseSayingController wiseSayingController = new WiseSayingController(sc);

    public void run(){
        System.out.println("== 명언 앱 ==");

        while (!cmd.equals("종료")) {

            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if(cmd.startsWith("삭제")){
                wiseSayingController.actionDelete(cmd);
            } else if(cmd.startsWith("수정")){
                wiseSayingController.actionModify(cmd);
            }
        }
    }


}

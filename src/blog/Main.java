package blog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WiseSaying[] wiseSayings= new WiseSaying[10];
        String cmd = "";
        int lastNo = 0; // 가장 최근 생성된 명언 번호

        System.out.println("== 명언 앱 ==");

        while (!cmd.equals("종료")) {

            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                WiseSaying wiseSaying=new WiseSaying();
                wiseSayings[lastNo]=wiseSaying;

                System.out.print("명언: ");
                String content = sc.nextLine();

                System.out.print("작가: ");
                String author = sc.nextLine();

                wiseSaying.no=++lastNo;
                wiseSaying.content=content;
                wiseSaying.author=author;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.no));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = lastNo-1; i >= 0; i--) {
                    WiseSaying target=wiseSayings[i];

                    System.out.println("%d / %s / %s".formatted(target.no, target.author, target.content));
                }
            }
        }
    }
}

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    WiseSaying[] wiseSayings= new WiseSaying[10];
    String cmd = "";
    int lastId = 0; // 가장 최근 생성된 명언 번호
    int lastIndex = 0; //가장 최근 생성된 배열 인덱스

    public void run(){
        System.out.println("== 명언 앱 ==");

        while (!cmd.equals("종료")) {

            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if(cmd.startsWith("삭제")){
                actionDelete(cmd);
            } else if(cmd.startsWith("수정")){
                actionModify(cmd);
            }
        }
    }

    private void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = lastIndex-1; i >= 0; i--) {
            WiseSaying target=wiseSayings[i];

            if (target.getContent().isEmpty())
                continue;

            System.out.println("%d / %s / %s".formatted(target.getId(), target.getAuthor(), target.getContent()));
        }
    }

    private WiseSaying write(String content, String author){
        WiseSaying wiseSaying=new WiseSaying(++lastId, author, content);
        wiseSayings[lastIndex++]=wiseSaying;

        return wiseSaying;
    }

    private void actionWrite(){
        System.out.print("명언: ");
        String content = sc.nextLine();

        System.out.print("작가: ");
        String author = sc.nextLine();

        WiseSaying wiseSaying= write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private void actionDelete(String cmd){
        //삭제?id=1에서 1만 가져오는 법
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());
        int targetIdx=-1;

        for(int i=0;i<lastIndex;i++){
            WiseSaying w1=wiseSayings[i];
            if(w1.getId() == id)
                targetIdx=i;
        }

        if(targetIdx==-1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        for(int i=targetIdx;i<lastId;i++){
            wiseSayings[i]=wiseSayings[i + 1];
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));

        lastIndex--;
    }

    private void actionModify(String cmd) {
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());
        int targetIdx=-1;

        for(int i=0;i<lastIndex;i++){
            WiseSaying w1=wiseSayings[i];
            if(w1.getId() == id)
                targetIdx=i;
        }

        if(targetIdx==-1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying w1 = wiseSayings[targetIdx];

        System.out.println("명언(기존) : %s" .formatted(w1.getContent()));
        System.out.print("명언 : ");
        String content=sc.nextLine();
        w1.setContent(content);

        System.out.println("작가(기존) : %s" .formatted(w1.getAuthor()));
        System.out.print("작가 : ");
        String author = sc.nextLine();
        w1.setAuthor(author);
    }
}

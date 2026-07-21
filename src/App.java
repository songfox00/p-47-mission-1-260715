import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    Scanner sc = new Scanner(System.in);
    ArrayList<WiseSaying> wiseSayings= new ArrayList<>();
    String cmd = "";
    int lastId = 0; // 가장 최근 생성된 명언 번호

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

        for (int i = wiseSayings.size()-1; i >= 0; i--) {
            WiseSaying target=wiseSayings.get(i);

            if (target.getContent().isEmpty())
                continue;

            System.out.println("%d / %s / %s".formatted(target.getId(), target.getAuthor(), target.getContent()));
        }
    }

    private WiseSaying write(String content, String author){
        WiseSaying wiseSaying=new WiseSaying(++lastId, author, content);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    private void actionWrite(){
        System.out.print("명언: ");
        String content = sc.nextLine();

        System.out.print("작가: ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private void actionDelete(String cmd){
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());

        boolean rst = wiseSayings.removeIf(w -> w.getId() == id);

        if(rst)
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        else
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    public int findIndexById(int id){

        return IntStream.range(0, wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    private void actionModify(String cmd) {
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());

        int targetIdx = findIndexById(id);

        if(targetIdx==-1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying w1 = wiseSayings.get(targetIdx);

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

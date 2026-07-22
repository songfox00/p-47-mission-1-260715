import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    Scanner sc = new Scanner(System.in);
    WiseSayingService wiseSayingService = new WiseSayingService();

    public WiseSayingController(Scanner sc){
        this.sc = sc;
    }

    public void actionList(){

        List<WiseSaying> list =wiseSayingService.findAllIdDesc();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(WiseSaying target:list){
            System.out.println("%d / %s / %s".formatted(target.getId(),
                    target.getAuthor(),
                    target.getContent()));
        }
    }

    public void actionWrite(){
        System.out.print("명언: ");
        String content = sc.nextLine();

        System.out.print("작가: ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }


    public void actionDelete(String cmd){
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());

        boolean rst = wiseSayingService.delete(id);

        if(rst)
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        else
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }



    public void actionModify(String cmd) {
        int id = Integer.parseInt(cmd.substring(cmd.indexOf("=")+1).trim());

        WiseSaying wiseSaying=wiseSayingService.findById(id);

        if(wiseSaying==null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("명언(기존) : %s" .formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String content=sc.nextLine();

        System.out.println("작가(기존) : %s" .formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(wiseSaying, content, author);
    }

}

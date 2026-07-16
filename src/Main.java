import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> sayList = new ArrayList<>();

        System.out.println("== 명언 앱 ==");
        
        while(true){
            System.out.print("명령) ");
            String str=sc.nextLine();

            if(str.equals("종료")){
                break;
            }
            else if(str.equals("등록")){
                System.out.print("명언: ");
                String saying=sc.nextLine();

                System.out.print("작가: ");
                String author=sc.nextLine();

                sayList.add(new ArrayList<>(Arrays.asList(saying, author)));
                int num=sayList.size();

                System.out.println(num+"번 명언이 등록되었습니다.");
            }
            else if(str.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int i=sayList.size()-1;i>=0;i--){
                    if(sayList.get(i).get(0).isEmpty())
                        continue;

                    String author=sayList.get(i).get(1);
                    String saying=sayList.get(i).get(0);
                    System.out.println(i+1 + " / "+ author + " / " + saying);
                }
            }
            else if(str.contains("삭제?id=")) {
                int idx=Integer.parseInt(str.substring(6))-1;

                if(idx < sayList.size() && !sayList.get(idx).get(0).isEmpty()){
                    sayList.get(idx).set(0,"");
                    sayList.get(idx).set(1,"");
                    System.out.println(idx+1 + "번 명언이 삭제되었습니다.");
                }
                else{
                    System.out.println(idx+1 + "번 명언은 존재하지 않습니다.");
                }
            }
            else if(str.contains("수정?id=")) {
                int idx=Integer.parseInt(str.substring(6))-1;

                if(idx < sayList.size() && !sayList.get(idx).get(0).isEmpty()){
                    String saying = sayList.get(idx).get(0);
                    String author = sayList.get(idx).get(1);

                    System.out.println("명언(기존) : " + saying);
                    System.out.print("명언 : ");
                    String new_saying=sc.nextLine();

                    sayList.get(idx).set(0,new_saying);

                    System.out.println("작가(기존) : " + author);
                    System.out.print("작가 : ");
                    String new_author=sc.nextLine();

                    sayList.get(idx).set(1, new_author);
                }
                else{
                    System.out.println(idx+1 + "번 명언은 존재하지 않습니다.");
                }
            }
            else{
            }
        }
    }
}

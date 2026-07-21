public class RqTest {

    public static void main(String[] args){

//        testActionName();
//        testGetParam();
//        testGetParamEx();
//        testGetParamEx2();
//        testGetParamEx3();
        testGetParamAsInt();
    }

    public static void testGetParamAsInt(){
        Rq rq = new Rq("삭제?id=3");
        int id = rq.getParamAsInt("id", -1);

        System.out.println(id);

        Rq rq2 = new Rq("삭제?id=");
        int id2 = rq2.getParamAsInt("id", -1);

        System.out.println(id2);
    }

    public static void testGetParamEx3(){
        Rq rq = new Rq("목록?searchKeywrod&keyword=kkk");
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"
        String keyword = rq.getParam("keyword", ""); // "영광"

        System.out.println(searchKeyword);
        System.out.println(keyword);

    }

    public static void testGetParamEx2(){
        Rq rq = new Rq("목록?searchKeywrod=");
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        System.out.println(searchKeyword); //
    }

    public static void testGetParamEx(){
        Rq rq = new Rq("목록?");
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        System.out.println(searchKeyword); //
    }

    public static void testGetParam(){
        Rq rq = new Rq("목록?searchKeyword=영광");
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        System.out.println(searchKeyword); //영광

        Rq rq2 = new Rq("목록?keywordType=content");
        String keywordType = rq2.getParam("keywordType", ""); // "영광"

        System.out.println(keywordType); //content

        Rq rq3 = new Rq("목록?keywordType=author");
        String keywordType2 = rq3.getParam("keywordType", ""); // "영광"

        System.out.println(keywordType2); //content
;    }

    public static void testActionName(){
        Rq rq1 = new Rq("삭제?id=1");
        String action = rq1.getActionName();

        System.out.println(action);

        Rq rq2 = new Rq("수정?id=1");
        String action2 = rq2.getActionName();

        System.out.println(action2);
    }
}

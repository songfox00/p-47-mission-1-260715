import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingService {

    ArrayList<WiseSaying> wiseSayings= new ArrayList<>();
    int lastId=0;

    public int findIndexById(int id){

        return IntStream.range(0, wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    public WiseSaying findById(int id){
        int idx = findIndexById(id);
        if(idx==-1)
            return null;

        return wiseSayings.get(idx);
    }

    public WiseSaying write(String content, String author){
        WiseSaying wiseSaying=new WiseSaying(++lastId, author, content);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public void modify(WiseSaying w1, String content, String author){
        w1.setContent(content);
        w1.setAuthor(author);
    }

    public boolean delete(int id){
        boolean rst=wiseSayings.removeIf(
                wiseSaying -> wiseSaying.getId()==id
        );

        return rst;
    }

    public List<WiseSaying> findAllIdDesc(){
        return wiseSayings.reversed();
    }
}

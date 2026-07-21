import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String cmd;
    private String actionName;
    private Map<String, String> paramMap = new HashMap<>();

    public Rq(String cmd) {
        this.cmd=cmd;

        //목록?keywordType=content&keyword=과거
        String[] cmdBits = cmd.split("\\?");
        actionName=cmdBits[0];

        String params = cmdBits.length > 1 ? cmdBits[1]: "";

        if(params.equals(""))
            return;

        String[] paramBits = params.split("&");

        for(String param : paramBits){
            String[] keyValue = param.split("=");

            if(keyValue.length<2)
                continue;

            paramMap.put(keyValue[0], keyValue[1]);
        }
    }

    public String getActionName(){

        return actionName;
    }

    public String getParam(String key, String defaultValue){

        return paramMap.getOrDefault(key,defaultValue);

    }

    public int getParamAsInt(String key, int defaultValue){

        String rst = getParam(key,"");

        try{
            return Integer.parseInt(rst);
        } catch (NumberFormatException e){
            return defaultValue;

        }
    }
}

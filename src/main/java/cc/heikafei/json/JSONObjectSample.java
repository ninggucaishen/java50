package cc.heikafei.json;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * JSONObject test
 */
public class JSONObjectSample {
    public static void main(String[] args) {

        createJson();

//        createJsonByHashMap();
    }

    //直接构建
    private static void createJson() {
        JSONObject obj = new JSONObject();
        obj.put("id", "001");
        obj.put("name", "ning");
        obj.put("age", "27");
        obj.put("isStudent", false);
        obj.put("hobbies", new String[]{"hiking", "swimming", "fishing"});
        System.out.println(obj);
    }

    //使用HashMap构建
    private static void createJsonByHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "001");
        map.put("name", "ning");
        map.put("age", "27");
        map.put("isStudent", false);
        map.put("hobbies", new String[]{"hiking", "swimming", "fishing"});
        System.out.println(map);

        JSONObject obj = new JSONObject(map);
        System.out.println(obj);
    }
}

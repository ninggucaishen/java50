package cc.heikafei.JSONObject;


import org.json.JSONArray;

/**
 * JsonArray 测试
 */
public class JsonArrayTest {
    public static void main(String[] args) {
        jsonArray();
    }

    private static void jsonArray() {
        JSONArray arr = new JSONArray();

        arr.put("001");
        arr.put("ning");
        arr.put(27);
        arr.put("isStudent?");
        arr.put("false");
        arr.put("swimming");

        System.out.println(arr);
    }
}

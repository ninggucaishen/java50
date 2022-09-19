package cc.heikafei.leetCode;

import java.util.*;

/**
 * @ClassName LetterCombinations
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/19 18:01
 * @Version 1.0
 */
public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "45";
        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            queue_letterCombinations(queue, map.get(digits.charAt(i)));
        }

        for (String str : queue) {
            combinations.add(str);
        }

        return combinations;

    }

    private static Queue<String> queue_letterCombinations(Queue<String> queue, String[] letters) {

        if (queue.size() == 0) {
            for (String letter : letters) {
                queue.add(letter);
            }
        } else {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                String str = queue.poll();
                for (String letter : letters) {
                    queue.add(str + letter);
                }
            }
        }
        return queue;

    }
}

package cc.heikafei.myPractice;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.system.JvmInfo;
import cn.hutool.system.JvmSpecInfo;
import cn.hutool.system.SystemUtil;

import java.util.Iterator;

/**
 * 雪花算法测试
 */
public class SnowFlakeTest {

    public static void main(String[] args) {
        //long i = snowFlowTest();
        //System.out.println("SnowFlakeId:" + i);

        parseTest();

        //information();

        //emoji();

    }


    private static void emoji() {
        String alias = EmojiUtil.toAlias("😊");
        System.out.println(alias);

        String s = EmojiUtil.toUnicode(":smile:");
        System.out.println(s);

        String toHtml = EmojiUtil.toHtml("🙂");
        System.out.println(toHtml);
    }

    private static void information() {

        JvmSpecInfo info = SystemUtil.getJvmSpecInfo();
        System.out.println(info);

        JvmInfo info1 = SystemUtil.getJvmInfo();
        System.out.println(info1);
    }

    private static void parseTest() {

        TokenizerEngine engine = TokenizerUtil.createEngine();

        String text = "这两个方法的区别在于返回值";

        Result result = engine.parse(text);

        String resultStr = CollUtil.join((Iterator< Word >) result, " ");

        System.out.println(resultStr);
    }

    private static long snowFlowTest() {

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);

        long id = snowflake.nextId();

        return id;
    }
}

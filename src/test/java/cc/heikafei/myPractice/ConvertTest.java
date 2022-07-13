package cc.heikafei.myPractice;

import cn.hutool.core.convert.Convert;

import java.util.Date;
import java.util.List;

/**
 * hutool转换工具类测试
 */
public class ConvertTest {

    public static void main(String[] args) {
        convert();
    }

    private static void convert() {

        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        long[] b = {1, 2, 3, 4, 5};
        String bStr = Convert.toStr(b);
        System.out.println(bStr);

        String data = "2022-06-27";
        Date dataVaule = Convert.toDate(data);
        System.out.println(dataVaule);

        Object[] aa = {"你", "好", "hello", "ning"};
        //List<?> list = Convert.toList(List.class, aa);
        List<?> list1 = Convert.toList(aa);
        //System.out.println(list);
        System.out.println(list1);
    }
}

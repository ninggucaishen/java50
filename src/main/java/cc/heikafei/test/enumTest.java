package cc.heikafei.test;

/**
 * 枚举测试
 */
public class enumTest {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("today is weekday, have fun!");
        } else {
            System.out.println("work at office!");
        }
    }

    enum Weekday {
        SUN, MON, TUE, WED, THU, FRI, SAT,
    }

}

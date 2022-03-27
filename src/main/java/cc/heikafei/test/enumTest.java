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

        String name = Weekday.SUN.name();
        System.out.println(name);       //SUN

        int ordinal = Weekday.FRI.ordinal();
        System.out.println(ordinal);        //5
    }

    /**
     * enum常量自身带有类型信息，编译器会自行检查出类型错误
     */
    enum Weekday {
        SUN, MON, TUE, WED, THU, FRI, SAT,
    }

}

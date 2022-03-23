package cc.heikafei.se50;

/**
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class myPractice10 {
    public static void main(String[] args) {
        float height = 100;
        int time = 10;
        distance(height, time);
    }

    private static void distance(float height, int time) {
        float length = 0;
        for (int i = 0; i < time; i++) {
            length += height;
            height /= 2.0f;
            //System.out.println("经过第" + (i + 1) + "次反弹后，小球共经过" + length + "米，" + "第" + (i + 1) + "次反弹高度为" + height + "米");
        }
        System.out.println("经过第10次反弹后，小球共经过" + length + "米，" + "第10次反弹高度为" + height + "米");

    }
}

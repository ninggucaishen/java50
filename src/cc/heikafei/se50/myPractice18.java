package cc.heikafei.se50;

import java.util.ArrayList;

/**
 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。
 * 已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 */
public class myPractice18 {
    String a, b, c;     //甲队成员

    private myPractice18(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "a的对手是" + a + " " + "b的对手是" + b + " " + "c的对手是" + c + " ";
    }

    public static void main(String[] args) {
        String[] racer = {"x", "y", "z"};       //乙队成员
        ArrayList<myPractice18> arrayList = new ArrayList<myPractice18>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    myPractice18 my18 = new myPractice18(racer[i], racer[j], racer[k]);
                    if (!my18.a.equals(my18.b) && my18.a.equals(my18.c) && !my18.b.equals(my18.c) &&
                            !my18.a.equals("x") && !my18.c.equals("x") && !my18.c.equals("z")) {
                        arrayList.add(my18);
                    }
                    for (Object obj : arrayList) {
                        System.out.println(obj);
                    }
                }
            }
        }

    }
}

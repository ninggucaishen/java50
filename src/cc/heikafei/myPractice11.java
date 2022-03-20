package cc.heikafei;

/**
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
 */
public class myPractice11 {
    public static void main(String[] args) {
        int count = 0;
        int n = 0;
        //百位
        for (int i = 1; i < 5; i++) {
            //十位
            for (int j = 1; j < 5; j++) {
                if (i == j) {
                    continue;
                }
                //个位
                for (int k = 1; k < 5; k++) {
                    if (k != i && k != j) {
                        n = i * 100 + j * 10 + k;
                        System.out.print(n + " ");
                        //每行打印4个输出结果
                        if ((++count) % 4 == 0) {
                            System.out.println();
                        }
                    }
                }
            }
        }
        //若一行需要打印5个，则需要把下面注释打开
        //System.out.println();
        System.out.println("符合条件的数共：" + count + "个");
    }
}

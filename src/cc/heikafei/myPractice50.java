package cc.heikafei;

import java.io.*;

/**
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算出平均成绩，
 * 将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
 */
public class myPractice50 {
    //定义学生模型
    String[] stuId = new String[5];
    String[] name = new String[5];
    float[][] grade = new float[5][3];
    float[] sum = new float[5];

    public static void main(String[] args) throws IOException {
        myPractice50 stu = new myPractice50();
        stu.input();
        stu.output();
    }

    //输入学号、姓名、成绩
    private void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRecord = true;
        while (isRecord) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("请输入学号：");
                    stuId[i] = reader.readLine();
                    System.out.print("请输入姓名：");
                    name[i] = reader.readLine();
                    for (int j = 0; j < 3; j++) {
                        System.out.print("请输入第" + (j + 1) + "门科成绩：");
                        grade[i][j] = Integer.parseInt(reader.readLine());
                    }
                    System.out.println();
                    sum[i] = grade[i][0] + grade[i][1] + grade[i][2];
                }
                isRecord = false;
            } catch (NumberFormatException e) {
                System.out.println("请输入数字！");
                ;
            }
        }
    }

    //输出文件到磁盘中
    private void output() throws IOException {
        FileWriter fw = new FileWriter("D:\\workspace\\java50\\file.stud.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("NO. " + "Name " + "grade1 " + "grade2 " + "grade3 " + "average ");
        bw.newLine();
        for (int i = 0; i < 5; i++) {
            bw.write(stuId[i]);
            bw.write(" " + name[i]);
            for (int j = 0; j < 3; j++) {
                bw.write(" " + grade[i][j]);
            }
            bw.write(" " + (sum[i] / 3));
            bw.newLine();
        }
        bw.close();
    }

}

package cc.heikafei.test;

import java.util.concurrent.Callable;

/**
 * 多线程案例
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {

        //下面这种方式会竞争输出
        /*MyThread myThread = new MyThread();
        MyRunnable myRunnable = new MyRunnable();
        MyCallable myCallable = new MyCallable();

        myThread.start();
        myRunnable.run();
        myCallable.call();*/

        //下面这种方式不会竞争，会按照顺序输出
        /*MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();

        MyCallable myCallable = new MyCallable();
        myCallable.call();*/

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);     //暂停1000ms，即1s
        myThread.interrupt();       //中断myThread线程
        myThread.join();        //等待myThread线程结束
        System.out.println("end");

    }

    //方法一：继承Thread类
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("1.继承Thread类的多线程方法！");
        }
    }

    //方法二：实现Runnable接口
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("2.实现Runnable接口的多线程方法！");
        }
    }

    //方法三：实现Callable接口
    private static class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("3.实现Callable接口的多线程方法！");
            return null;
        }
    }


}
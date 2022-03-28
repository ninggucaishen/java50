package cc.heikafei.test;

import java.util.concurrent.*;

/**
 * 线程池测试
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        //创建一个固定大小的线程池
        /*ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            executorService.submit(new Task("" + i));
        }

        //关闭线程池
        executorService.shutdown();*/

        //定义一个可扩容的线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.submit(new Task("" + i));
        }

        //关闭线程池
        threadPoolExecutor.shutdown();

    }

    private static class Task implements Runnable {

        private final String name;

        private Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("start task " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end task " + name);
        }
    }

}

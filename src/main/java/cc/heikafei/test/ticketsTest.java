package cc.heikafei.test;

/**
 * 多线程实现同步售票
 */
public class ticketsTest implements Runnable {
    //定义总票数
    private int tickets = 50;
    //定义一个多线程同步对象
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //同步锁
            synchronized (obj) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出第" + tickets + "张票");
                    tickets--;
                } else {
                    System.out.println("票已售完，下次请早点来！");
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        //获取对象
        ticketsTest test = new ticketsTest();
        //把对象放入线程中
        for (int i = 1; i < 10; i++) {
            new Thread(test, "窗口" + i).start();
        }
    }
}

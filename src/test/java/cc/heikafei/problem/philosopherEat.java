package cc.heikafei.problem;

/**
 * @ClassName philosopherEat
 * @Description 哲学家进餐问题
 * @Auther Ning
 * @Date 2022/8/9 10:02
 * @Version 1.0
 */
public class philosopherEat {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[5];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[i + 1 % philosophers.length];
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            new Thread(philosophers[i], "哲学家" + (i + 1) + "号").start();
        }
    }

    private static class Philosopher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        private Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    doAction("思考生命、宇宙....");
                    synchronized (leftChopstick) {
                        doAction("拿起左边筷子");
                        synchronized (rightChopstick) {
                            doAction("拿起右边筷子，开始吃饭");
                            doAction("吃完放下右边筷子");
                        }
                        doAction("放下左边筷子");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + action);
            Thread.sleep((long) (Math.random()*10));
        }
    }
}

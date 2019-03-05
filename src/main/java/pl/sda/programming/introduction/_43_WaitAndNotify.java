package pl.sda.programming.introduction;

final class _43_WaitAndNotify {

    static volatile boolean go = true;

    public static void main(String[] args) {

        // DON'T USE IT, THERE ARE ALWAYS BETTER OPTIONS

        Object monitor = new Object();

        Thread t0 = new Thread(() -> {
            System.out.println("Thread-0 started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                go = false;
                monitor.notifyAll();
            }
            System.out.println("Thread-0 stopped");
        });
        t0.start();

        System.out.println("BEFORE WAIT");
        synchronized (monitor) {
            while (go) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("AFTER WAIT");

    }
}

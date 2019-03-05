package pl.sda.programming.introduction;

final class _42_ManyThreads {
    public static void main(String[] args) {

        Thread t0 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // let's start them
        t0.start();
        t1.start();
        t2.start();

        // synchronized
        // monitor

        // atomic's

        // locks

        // semaphores and phaser

        // cyclic barriers, latches, exchanger

        // concurrent collections, example: ConcurrentHashMap, CopyOnWriteArrayList

        // thread pools and executors
        // (fork join pool)

        // futures (promises), completable future

        // queues, example: BlockingPriorityQueue
    }
}

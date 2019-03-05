package pl.sda.programming.introduction;

final class _41_Threads {

    public static void main(String[] args) {
        // main is a thread
        System.out.println(Thread.currentThread().getName());

        // how to create a thread?
        Thread t0 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        // how to start a thread?
        t0.start();
        System.out.println("Thread0 started");
    }
}

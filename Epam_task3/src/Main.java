public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingBuffer<String> boundedBlockingBuffer = new BoundedBlockingBuffer<>();
        String s = "Armenia";

        Thread thread1 = new Thread(() -> {
            try {
                boundedBlockingBuffer.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                boundedBlockingBuffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();



    }
}

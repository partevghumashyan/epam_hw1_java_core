public class BoundedBlockingBuffer<T>{
    private T data;
    private boolean isPut = false;

    public T take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (isPut){
                    isPut = false;
                    T newData = this.data;
                    this.data = null;
                    notify();
                    Thread.sleep(1000);
                    System.out.println(newData);
                    return newData;
                }
                wait();
//                while (!isPut) {
//                    wait();
//                    isPut = false;
//                    T newData = this.data;
//                    this.data = null;
//                    notify();
//                    Thread.sleep(1000);
//                    System.out.println(newData);
//                    return newData;
//                }
//        if (isPut){
//            isPut = false;
//            T newData = this.data;
//            this.data = null;
//            return newData;
//        }

            }
        }
    }

    public void put(T data) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isPut){
                    this.data = data;
                    isPut = true;
                    notify();
                    System.out.println(this.data);
                    Thread.sleep(1000);
                }
                wait();

//                while (!isPut) {
//                    wait();
//                    this.data = data;
//                    isPut = true;
//                    notify();
//                    System.out.println(this.data);
//                    Thread.sleep(1000);
//                }
//        if (!isPut){
//            this.data = data;
//            isPut = true;
//        }

            }
        }
    }

    @Override
    public String toString() {
        return "BoundedBlockingBuffer{" +
                "data=" + data +
                '}';
    }
}

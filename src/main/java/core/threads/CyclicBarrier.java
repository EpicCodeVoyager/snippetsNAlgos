package core.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier {

    public static class Task1 implements Runnable {
        java.util.concurrent.CyclicBarrier cb;
        int millis;

        public  Task1(java.util.concurrent.CyclicBarrier cb, int millis){
            this.cb = cb;
            this.millis=millis;
        }

        @Override
        public void run() {

            while(true){
                try {
                    Thread.sleep(millis);
                    cb.await();

          System.out.println(Thread.currentThread().getId() + ": " +Thread.currentThread().getName());
          Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }


        }
    }

  public static void main(String[] args) {
      java.util.concurrent.CyclicBarrier cb = new java.util.concurrent.CyclicBarrier(2);

      ExecutorService es = Executors.newFixedThreadPool(3);

      es.submit(new Task1(cb,1000));
      es.submit(new Task1(cb,2000));
      es.submit(new Task1(cb,3000));


      cb = new java.util.concurrent.CyclicBarrier(3);
      es.shutdown();
  }
}

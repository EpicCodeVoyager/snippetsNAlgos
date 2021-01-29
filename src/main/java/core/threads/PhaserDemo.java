package core.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static class Task1 implements Runnable {
        Phaser cb;
        int millis;

        public  Task1(Phaser cb, int millis){
            this.cb = cb;
            this.millis=millis;
        }

        @Override
        public void run() {
            while(true){

                try {
                    Thread.sleep(millis);
                    cb.arriveAndAwaitAdvance();

                    System.out.println(
                            Thread.currentThread().getId()+
                            ":"+ cb.getPhase() +
                            ":"+Thread.currentThread().getName()
                    );

                    Thread.sleep(1000);

                     } catch (InterruptedException e) {
                     e.printStackTrace();
                     }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // this is the total number of parties.
        Phaser cb = new Phaser(2);

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Task1(cb,1000));
        es.submit(new Task1(cb,2000));
        es.submit(new Task1(cb,3000));
        es.shutdown();

        Thread.sleep(3000);
    }
}

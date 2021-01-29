package core.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class CounterAtomicAdderAccumulator {

    public static class Task implements Runnable{

        private final AtomicLong counter;

        public Task(AtomicLong counter){
            this.counter=counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }

    public static class Task2 implements Runnable{

        private final LongAdder counter;

        public Task2(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    public static class Task3 implements Runnable{

        private final LongAccumulator counter;

        public Task3(LongAccumulator counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.accumulate(1);
        }
    }

  public static void main(String[] args) throws InterruptedException {

      ExecutorService es = Executors.newFixedThreadPool(5);
      AtomicLong counter = new AtomicLong(0);
      for(int i=0;i<10;i++){
          es.submit(new Task(counter));
      }
      es.shutdown();
      es.awaitTermination(1, TimeUnit.MINUTES);
      System.out.println(counter.get());
///////////////////////////////////////
      ExecutorService es2 = Executors.newFixedThreadPool(5);
      LongAdder counter2 = new LongAdder();
      for(int i=0;i<5;i++){
          es2.submit(new Task2(counter2));
      }
      es2.shutdown();
      es2.awaitTermination(1, TimeUnit.MINUTES);
      System.out.println(counter2.sum());
///////////////////////////////////////
      ExecutorService es3 = Executors.newFixedThreadPool(6);
      LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y ,0 );
      for(int i=0;i<5;i++){
          es3.submit(new Task3(longAccumulator));
      }
      es3.shutdown();
      es3.awaitTermination(1, TimeUnit.MINUTES);
      System.out.println(longAccumulator.get());
  }
}

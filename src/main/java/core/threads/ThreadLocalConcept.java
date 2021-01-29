package core.threads;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalConcept {

    static ConcurrentHashMap<Long,Integer> threadIdFreq = new ConcurrentHashMap<>();

    public static class TaskTracker implements Runnable{

        private Map<Long,Integer> freqMap = new HashMap<>();

        public Map<Long,Integer> getFreqMap(){
                return  this.freqMap;
        }

        @Override
        public void run() {

        }

        public synchronized void insert(Long threadId){
            if (freqMap.containsKey(threadId) ){
                int freq = freqMap.get(threadId);
                freqMap.put(threadId,++freq);
            }else{
                freqMap.put(threadId,1);
            }
        }
    }


  public static class Task implements Runnable {
    LocalDate date;

    public Task(LocalDate date) {
      this.date = date;
    }

    @Override
    public void run() {
    Long id = Thread.currentThread().getId();

      if (!threadIdFreq.containsKey(id)) {
        threadIdFreq.put(id, 1);
      }else{
        int freq = threadIdFreq.get(id);
        threadIdFreq.put(id,++freq);
      }

      this.date = LocalDate.of(getRandom(1990, 2019), getRandom(1, 12), getRandom(1, 27));
        System.out.println(Thread.currentThread().getId() + ":" + date.toString() );
    }
  }

  public static int getRandom(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }


  public static void main(String[] args) throws InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(10);

    ThreadLocal<LocalDate> localDate =
        new ThreadLocal<LocalDate>() {
          @Override
          protected LocalDate initialValue() {
            return LocalDate.of(1900, 1, 1);
          }
          @Override
          public LocalDate get() {
            return super.get();
          }
        };

    for(int i = 0; i < 10000; i++) {
      es.submit(new Task(localDate.get()));
    }
    es.shutdown();
    localDate.remove();
    es.awaitTermination(1, TimeUnit.MINUTES);
    int num = threadIdFreq.keySet().size();
    int freqSum = threadIdFreq.values().stream().reduce(0,(x,y)->x+y);

    System.out.println("Total Thread is "+num);
    threadIdFreq.forEach(
        (k, v) -> {
          System.out.println("ThreadId: "+k+ "=>" +Math.round((v*100/(double)freqSum))+"%");
        });
  }
}
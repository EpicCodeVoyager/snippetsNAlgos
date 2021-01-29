package core.threads;

import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {


    public static class Fibonacci extends RecursiveTask<Integer>{
        final int n;

        Fibonacci(int n){
            this.n = n;
        }

        public Integer compute(){
            if(n<2)
                return n;

            Fibonacci fib1 = new Fibonacci(n-1);
            Fibonacci fib2 = new Fibonacci(n-2);

            fib1.fork();
            fib2.fork();

            return fib1.join()+fib2.join();
        }

    }

  public static void main(String[] args) {
    //

      Fibonacci f1 = new Fibonacci(6);
    System.out.println(f1.compute());
  }
}

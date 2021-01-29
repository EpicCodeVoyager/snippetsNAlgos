package core.threads;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    private static Object NullPointerException;

    public static void main(String[] args) {

      int[] arr = {81,24,75,63,51,43,34,23,13,35,36,54,32,11,63,74,69,42};

    Arrays.stream(arr)
        .forEach(
            x -> {
              CompletableFuture.supplyAsync(() -> evenOdd(x))
                  .thenApply(num -> evenOdd(num))
                      .exceptionally(throwable ->{ System.out.println(throwable.getStackTrace());
                      return -1;
                      });
            });
  }

  public static int evenOdd(int x){
      return x%2;
  }

  public static String evenOddToString(int x){
      return String.valueOf(x);
    }

}

package core.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReadFilesConcurrently {

    public static ArrayList<String> readFile(String filePath){

        ArrayList<String> fileLines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        try {

            File f = new File(filePath);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";


            while ((readLine = b.readLine()) != null) {
                fileLines.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return fileLines;
    }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
      ExecutorService es = Executors.newFixedThreadPool(4);
      Future<ArrayList> fileLines = es.submit(()->readFile("/home/saurabh/FoodsToEat.txt"));

      ArrayList<String> lines = fileLines.get();
     // ArrayList<String> lines = readFile("/home/saurabh/FoodsToEat.txt");

    System.out.println(lines.toString());
    }
}

package core.codesnippets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaders {

    public static void main(String[] args) {
        BufferedReader reader;
        String filePath = "/home/saurabh/authlogdump.log";

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package core.codesnippets;

import java.util.Scanner;

public class CliReader {
    public static void main(String[] args) {
        System.out.println("Enter your Name and Age: ");
        Scanner scanner = new Scanner(System.in);

        String fName = scanner.nextLine();
        Integer age = scanner.nextInt();
        // Just because nextInt() do not captures the \n character.
        scanner.nextLine();
        String lName = scanner.nextLine();

        System.out.println(String.format("%s, %d, %s", fName, age, lName));
    }
}

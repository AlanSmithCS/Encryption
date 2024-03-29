package Tools;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Tools {
    static Scanner scanner = new Scanner(System.in);
    public static void messageBox(String content) {
        int length = content.length();

        StringBuilder divider = new StringBuilder();
        divider.append("-".repeat(length));

        System.out.println("\n"+divider+"\n"+content+"\n"+divider+"\n");
    }

    public static int getInputInt(String prompt) {
        messageBox(prompt);
        System.out.print("> ");

        return scanner.nextInt();
    }
    public static String getInputStr(String prompt) {
        scanner = new Scanner(System.in);

        messageBox(prompt);
        System.out.print("> ");

        return scanner.nextLine();
    }
}

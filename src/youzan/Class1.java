package youzan;

import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] params = input.split(";");
        String A = params[0];
        String B = params[1];
    }
}

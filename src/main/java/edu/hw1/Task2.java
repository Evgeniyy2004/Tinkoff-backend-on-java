package edu.hw1;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public final class Task2 {
    private Task2() {
        //not used
    }

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.out.println(countDigits(parseInt(str)));
        } catch (Exception e) {
            return;
        }
    }

    public static int countDigits(int number) {
        int i = 1;
        int newNumber = number/10;
        while (newNumber != 0) {
            newNumber = newNumber / 10;
            i += 1;
        }
        return i;
    }
}

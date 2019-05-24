package nl.dev4all.hackerrank.interview.warmup;

import java.util.Scanner;

public class CountingValleys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        String steps = in.next();

        int currentLevel = 0;
        int valleys = 0;
        for (int i = 0; i < steps.length(); i++) {
            if (steps.charAt(i) == 'U') {
                currentLevel++;
            } else if (steps.charAt(i) == 'D') {
                if (currentLevel == 0) {
                    valleys++;
                }
                currentLevel--;
            }
        }
        System.out.println(valleys);
    }
}
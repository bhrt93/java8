package java8;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        ArrayList<Long> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a list of numbers: ");
        while (in.hasNextLong()) {
            long input = 0;
            try {
                input = in.nextLong();
            } catch (Exception e) {
                break;
            }
            numbers.add(input);
        }
        numberSum(numbers);

    }

    static int digSum(long n) {
        int sum = 0;

        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static void numberSum(ArrayList<Long> numbers) {
        for (Long i : numbers) {
            System.out.println(i+" --> "+digSum(i));
        }
    }
}

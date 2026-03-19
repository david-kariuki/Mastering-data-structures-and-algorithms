package dk.learning.arrays.learning_arrays.projects;

import java.util.Scanner;

/**
 * Calculate Average Temperature and find out how many days are above average temperature
 *
 * @author David Kariuki
 */
public class CalculateAverageTemperature {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nHow many days temperature will you record?");
        int numDays = scanner.nextInt();
        int[] temps = new int[numDays];
        int sum = 0;
        int numDaysAboveAverage = 0;

        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter temperature in day " + (i + 1) + " : ");
            int next = scanner.nextInt();
            temps[i] = next; // Record temperature in array
            sum += next;
        }

        // Get average temperature
        double average = sum / numDays;
        System.out.println("\n\nAverage temperature : " + average);

        for (int i = 0; i < numDays; i++) {
            if (temps[i] > average) {
                numDaysAboveAverage++;
            }
        }

        System.out.println("\n\nThere are " + numDaysAboveAverage + " days with temperatures above average!");
    }
}

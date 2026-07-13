import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        Random rnd = new Random();

        int[] dataPoints = new int[100];

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        for (int i = 0; i < dataPoints.length; i++) {
            System.out.printf("%d | ", dataPoints[i]);
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        int searchValue1 = SafeInput.getRangedInt(pipe, "Enter a value to search for", 1, 100);

        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue1) {
                count++;
            }
        }
        System.out.println("The value " + searchValue1 + " was found " + count + " times in dataPoints.");

        int searchValue2 = SafeInput.getRangedInt(pipe, "Enter another value to search for", 1, 100);

        boolean found = false;
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue2) {
                position = i;
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The value " + searchValue2 + " was found at array index " + position);
        } else {
            System.out.println("The value " + searchValue2 + " was not found in dataPoints.");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value in dataPoints is: " + min);
        System.out.println("The maximum value in dataPoints is: " + max);

        double[] dataPointsAsDouble = new double[dataPoints.length];
        for (int i = 0; i < dataPoints.length; i++) {
            dataPointsAsDouble[i] = dataPoints[i];
        }
        System.out.println("Average of dataPoints is: " + getAverage(dataPointsAsDouble));
    }

    public static double getAverage(double values[]) {
        double total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total / values.length;
    }
}
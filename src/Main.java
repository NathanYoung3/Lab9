import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] dataPoints = new int[100];
        int sum;
        int average;
        int min;
        int max;

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = (int) (Math.random() * 100) + 1;
        }
        for (int i = 0; i < dataPoints.length; i++) { //this loop can be combined with prior loop but instructions said make a second loop ¯\_(ツ)_/¯
            System.out.print(dataPoints[i] + " | ");
        }

        sum = sum(dataPoints);
        min = min(dataPoints);
        max = max(dataPoints);
        average = sum / 100;
        System.out.printf("\n%-10s %5d", "Sum:", sum);
        System.out.printf("\n%-10s %5d", "Average:", average);
        System.out.printf("\n%-10s %5d", "Min:", min);
        System.out.printf("\n%-10s %5d", "Max:", max);

        //PART 2
        Scanner scan = new Scanner(System.in);
        int userNum = InputHelper.getRangedInt(scan, "\n\nPick a number between 1 and 100: ", 1, 100);
        int occurenceSpot;
        if (contains(dataPoints, userNum)) {
            occurenceSpot = occurenceScan(dataPoints, userNum);
            System.out.println("The value " + userNum + " was found at array index " + occurenceSpot + ".");
        } else {
            System.out.println("The number " + userNum + " did not appear in the array of numbers.");
        }
    }


    public static int min(int[] values){
        int lowest = 1000000;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < lowest) {
                lowest = values[i];
            }
        }
        return lowest;
    }

    public static int max(int[] values){
        int highest = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > highest) {
                highest = values[i];
            }
        }
        return highest;
    }

    public static int occurenceScan(int[] values, int target){ //in the instructions this was supposed to find how many times the user's number was in the array but part 2 doesn't need that, it needs the index number of the first time that number occurs if it occurs so that is what I am using it as
        int occurAmount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                occurAmount = i;
            }
        }
        return occurAmount;
    }

    public static int sum(int[] values){
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static boolean contains(int[] values, int target){
        boolean containsTarget = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                containsTarget = true;
                break;
            }
        }
        return containsTarget;
    }
}
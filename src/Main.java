import javax.print.attribute.standard.PagesPerMinute;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        int val = rnd.nextInt(100); // gives a value from 0 to 99
        int avgPoint = 0;
        int[] dataPoint = new int[100];
        int favNum = 0;
        int favNumCounter = 0;

        for (int i = 0; i < dataPoint.length; i++)
        {
            dataPoint[i] = rnd.nextInt(100);
        }
        for (int i = 0; i < dataPoint.length; i++)
        {
            System.out.printf("| %2d ", dataPoint[i]);
        }
        System.out.print("|\n");

        System.out.println("Total Points: " + sum(dataPoint));
        System.out.println("Average Points: " + getAverage(dataPoint));

        favNum = SafeInput.getRangedInt(scan, "Enter your favorite number", 1, 100);
        favNumCounter = occuranceScan(dataPoint, favNum);
        System.out.println("Your favorite number " + favNum + " was found " + favNumCounter + " times");

        favNum = SafeInput.getRangedInt(scan, "Enter your second favorite number", 1, 100);
        for (int i = 0; i < dataPoint.length; i++)
        {
            if (contains(dataPoint, favNum))
            {
                System.out.println("Your number " + favNum + " was found at spot " + (i + 1) + " of the array");
                break;
            }
            else if (i == dataPoint.length - 1)
            {
                System.out.println("Your number " + favNum + " is not in the array");
            }
        }

        System.out.println("The minimum of the array: " + min(dataPoint));
        System.out.println("The maximum of the array: " + max(dataPoint));
    }

    public static double getAverage(int values[])
    {
        double avgPoints = 0;
        for (int i = 0; i < values.length; i++)
        {
            avgPoints += values[i];
        }
        avgPoints = avgPoints / values.length;

        return avgPoints;
    }

    public static int min(int values[])
    {
        int min = 0;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] < min)
                min = values[i];
        }

        return min;
    }

    public static int max(int values[])
    {
        int max = 0;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] < max)
                max = values[i];
        }

        return max;
    }

    public static int occuranceScan(int values[], int target)
    {
        int counter = 0;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] == target)
                counter++;
        }

        return counter;
    }

    public static int sum(int values[])
    {
        int total = 0;
        for (int i = 0; i < values.length; i++)
        {
            total += values[i];
        }

        return total;
    }

    public static boolean contains(int values[], int target)
    {
        boolean targetFound = false;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] == target)
                targetFound = true;
        }

        return targetFound;
    }
}
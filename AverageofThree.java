import java.util.*;
import java.util.Scanner;

public class AverageofThree {
    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Ener the first Number:");
        float A = sc.nextFloat();

        System.out.println("Enter the second Number:");
        float B= sc.nextFloat();

        System.out.println("Enter the third Number:");
        float C= sc.nextFloat();

        Float Sum = A + B + C;
        double Average = (double) Sum / 3; // Use double for averag

        System.out.println("The average of three no is: " + Average);
    }
}

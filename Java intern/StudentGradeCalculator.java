import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        if (numGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive integer.");
            return;
        }

        int[] grades = new int[numGrades];
        int sum = 0;

        for (int i = 0; i < numGrades; i++) {
            System.out.println("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            sum += grades[i];
        }

        double average = (double) sum / numGrades;
        System.out.println("Average grade: " + average);

        scanner.close();
    }
}

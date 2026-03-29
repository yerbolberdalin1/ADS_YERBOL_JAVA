import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select task (1-4):");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter n: ");
            System.out.println("Result: " + Task1(scanner.nextInt()));
        } else if (choice == 2) {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("Sum of array: " + Task2(arr, 3));
        } else if (choice == 3) {
            System.out.print("Enter b and n: ");
            System.out.println("Result: " + Task3(scanner.nextInt(), scanner.nextInt()));
        } else if (choice == 4) {
            System.out.print("Enter N: ");
            Task4(scanner.nextInt());
        }
    }

                                // Task 1: sum of squares
                                // Complexity: O(n)
                                // Explanation: The function calls itself n times, performing one square and one addition per call.
    public static int Task1(int n) {
        if (n <= 1) return 1;
        return (n * n) + Task1(n - 1);
    }

                                // Task 2: Sum of array
                                // Complexity: O(n)
                                 // Explanation: It visits each of the n elements once through recursion.
    public static int Task2(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + Task2(arr, n - 1);
    }

                                // Task 3
                                // Complexity: O(n)
                                // Explanation: It calculates and adds n powers, growing linearly with the size of n.
    public static int Task3(int b, int n) {
        if (n == 0) return 1;
        return (int) Math.pow(b, n) + Task3(b, n - 1);
    }

                                // Task 4: Reverse sequence
                                // Complexity: O(n)
                                // Explanation: It reads n numbers into the call stack and prints them when returning.
    public static void Task4(int count) {
        if (count == 0) return;
        int number = scanner.nextInt(); // Store number in memory
        Task4(count - 1); // Call next
        System.out.print(number + " "); // Print on the way back
    }
}
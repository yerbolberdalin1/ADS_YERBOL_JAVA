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
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) arr[i] = scanner.nextInt();
            System.out.print("How many first elements to sum (n): ");
            int n = scanner.nextInt();
            if (n <= size) {
                System.out.println("Sum of array: " + Task2(arr, n));
            } else {
                System.out.println("Error: n is larger than array size!");
            }
        } else if (choice == 3) {
            System.out.print("Enter b and n: ");
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            // Вызываем Task3, передаем b, n и начальную степень b^0 = 1
            System.out.println("Result: " + Task3(b, n, 1));
        } else if (choice == 4) {
            System.out.print("Enter N: ");
            Task4(scanner.nextInt());
        }
    }

    // Task 1: sum of squares
    // Complexity: O(n)
    public static int Task1(int n) {
        if (n <= 0) return 0;
        return (n * n) + Task1(n - 1);
    }

    // Task 2: Sum of array
    // Complexity: O(n)
    public static int Task2(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + Task2(arr, n - 1);
    }

    // Task 3: Sum of powers (БЕЗ Math.pow)
    // Complexity: O(n)
    // Explanation: We pass the current power (currentP) to the next call,
    // multiplying it by 'b' each time. This gives us O(n) time.
    public static int Task3(int b, int n, int currentP) {
        if (n < 0) return 0;
        // Прибавляем текущую степень и считаем следующую
        return currentP + Task3(b, n - 1, currentP * b);
    }

    // Task 4: Reverse sequence
    // Complexity: O(n)
    public static void Task4(int count) {
        if (count == 0) return;
        int number = scanner.nextInt();
        Task4(count - 1);
        System.out.print(number + " ");
    }
}
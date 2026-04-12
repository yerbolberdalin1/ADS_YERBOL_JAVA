import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // task 1
    static void problem1() {
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) row.add(sc.nextInt());
            lines.add(row);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x >= 1 && x <= lines.size() && y >= 1 && y <= lines.get(x - 1).size()) {
                System.out.println(lines.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }
    }

    // task 2
    static void problem2() {
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String op = sc.next();
            if (op.equalsIgnoreCase("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
            } else if (op.equalsIgnoreCase("Delete")) {
                int x = sc.nextInt();
                list.remove(x);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    // task 3
    static void problem3() {
        int n = sc.nextInt();
        ArrayDeque<Integer> shelf = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) shelf.addFirst(sc.nextInt());
            else if (op == 2) shelf.addLast(sc.nextInt());
            else if (op == 3) System.out.print(shelf.removeFirst() + " ");
            else if (op == 4) System.out.print(shelf.removeLast() + " ");
        }
        System.out.println();
    }

    // task 4
    static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) { stack.push(element); return; }
        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    static void problem4() {
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) stack.push(sc.nextInt());
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // task 5
    static void problem5() {
        int n = sc.nextInt();
        int[] st = new int[n];
        int[] sa = new int[n];
        for (int i = 0; i < n; i++) st[i] = sc.nextInt();
        for (int i = 0; i < n; i++) sa[i] = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        for (int x : st) q.add(x);
        for (int i = n - 1; i >= 0; i--) s.push(sa[i]);
        int streak = 0;
        while (!q.isEmpty() && streak < q.size()) {
            if (q.peek().equals(s.peek())) {
                q.poll(); s.pop(); streak = 0;
            } else {
                q.add(q.poll()); streak++;
            }
        }
        System.out.println(q.size());
    }

    // task 6
    static void minHeapify(int[] arr, int n, int i) {
        int smallest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] < arr[smallest]) smallest = l;
        if (r < n && arr[r] < arr[smallest]) smallest = r;
        if (smallest != i) {
            int tmp = arr[i]; arr[i] = arr[smallest]; arr[smallest] = tmp;
            minHeapify(arr, n, smallest);
        }
    }

    static void problem6() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i = n / 2 - 1; i >= 0; i--) minHeapify(arr, n, i);
        System.out.println("Array: " + Arrays.toString(arr));
        int level = 0, nodes = 1, index = 0;
        while (index < n) {
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < nodes && index < n; i++) {
                System.out.print(arr[index++] + " ");
            }
            System.out.println();
            nodes *= 2;
            level++;
        }
    }

    public static void main(String[] args) {
        if (sc.hasNextInt()) {
            int task = sc.nextInt();
            switch (task) {
                case 1 -> problem1();
                case 2 -> problem2();
                case 3 -> problem3();
                case 4 -> problem4();
                case 5 -> problem5();
                case 6 -> problem6();
            }
        }
    }
}
public class Partition {
    public static void main(String[] args) {
        // error handling
        if (args.length != 1) throw new IllegalArgumentException("argument must be a single integer");
        int n;
        n = Integer.parseInt(args[0]);
        if (n <= 0) throw new IllegalArgumentException("argument must be positive");

        // print the partitions
        printPartitions(n);
    }

    // Print all partitions of n in nonincreasing order, one per line like in the quiz
    private static void printPartitions(int n) {
        int[] parts = new int[n]; // worst case: 1+1+...+1
        backtrack(n, n, parts, 0);
    }

    // remaining: how much left to sum to
    // maxNext: largest next part allowed (keeps order nonincreasing)
    // parts[0..length-1]: current partial partition
    // recursively goes through
    private static void backtrack(int remaining, int maxNext, int[] parts, int length) {
        if (remaining == 0) {
            printLine(parts, length);
            return;
        }
        int start = Math.min(remaining, maxNext);
        for (int p = start; p >= 1; p--) {
            parts[length] = p;
            backtrack(remaining - p, p, parts, length + 1);
        }
    }

    private static void printLine(int[] parts, int length) {
        StringBuilder LinePart = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) LinePart.append(" + ");
            LinePart.append(parts[i]);
        }
        System.out.println(LinePart.toString());
    }
}
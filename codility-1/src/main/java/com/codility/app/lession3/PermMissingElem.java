package com.codility.app.lession3;

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElem sol = new PermMissingElem();

        // Test cases
        int[] A1 = {2, 3, 1, 5};
        System.out.println(sol.solution(A1));  // Output: 4

        int[] A2 = {};
        System.out.println(sol.solution(A2));  // Output: 1 (when N = 0)
    }

    public int solution_sort(int[] A) {
        int N = A.length;

        // Handle case when array A is empty
        if (N == 0) {
            return 1; // The missing element when N=0 is logically 1
        }

        // Sort the array
        java.util.Arrays.sort(A);

        // Check the first element
        if (A[0] != 1) {
            return 1; // If the smallest element is not 1, return 1 as missing
        }

        // Iterate through the sorted array to find the missing element
        for (int i = 1; i < N; i++) {
            if (A[i] != A[i - 1] + 1) {
                return A[i - 1] + 1;
            }
        }

        // If all elements are in order from 1 to N+1, then the missing element is N+1
        return A[N - 1] + 1;
    }

    public int solution(int[] A) {
        int N = A.length;

        // Handle case when array A is empty
        if (N == 0) {
            return 1; // The missing element when N=0 is logically 1
        }

        // Initialize a boolean array to mark presence of numbers 1 to N+1
        boolean[] found = new boolean[N + 2]; // N+2 because elements are in range [1..N+1]

        // Mark the presence of each number in A
        for (int num : A) {
            found[num] = true;
        }

        // Find the missing element
        for (int i = 1; i <= N + 1; i++) {
            if (!found[i]) {
                return i;
            }
        }

        // Should not reach here as there's guaranteed to be exactly one missing element
        throw new IllegalArgumentException("No missing element found");
    }

    public int solution1(int[] A) {
        int N = A.length;

        // If N is 0, the missing element is 1 (N + 1 = 0 + 1 = 1)
        if (N == 0) {
            return 1;
        }

        // Calculate the expected sum of numbers from 1 to N+1
        long expectedSum = (long)(N + 1) * (N + 2) / 2;

        // Calculate the actual sum of elements in array A
        long actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }

        // The missing element is the difference between expectedSum and actualSum
        int missingElement = (int)(expectedSum - actualSum);

        return missingElement;
    }
}

import java.util.*;

public class PalindromeTriplets {

    public static void main(String[] args) {
        String[] input = {"race", "car", "ecar", ""};
        List<List<Integer>> triplets = findTriplets(input);
        System.out.println(triplets);
    }

    public static List<List<Integer>> findTriplets(String[] input) {
        List<List<Integer>> result = new ArrayList<>();
        int n = input.length;

        // Convert strings to lowercase to ignore case
        String[] lowerCase = new String[n];
        for (int i = 0; i < n; i++) {
            lowerCase[i] = input[i].toLowerCase();
        }

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    // check only where triplets indices are different
                    if (i != j && j != k && i != k) {
                        String s = lowerCase[i] + lowerCase[j] + lowerCase[k];

                        if (isPalindrome(s)) {

                            // Create a new list for triplet
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(i);
                            triplet.add(j);
                            triplet.add(k);

                            // Add the triplet to the result
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        // Return after all triplets have been checked
        return result;
    }

    // Check if string is a palindrome (helper method)
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


}


/*
Sources:
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
https://algo.monster/liteproblems/336
ChatGPT
 */
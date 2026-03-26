import java.util.*;

public class RadixSort {

    public static void main(String[] args) {
        String[] arr = {
                "google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo",
                "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"
        };

        radixSortStrings(arr);

        // Print lexicographically sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void radixSortStrings(String[] arr) {

        // Check if array is null or empty
        if (arr == null || arr.length == 0) return;

        // Check for the longest String in the array
        int maxLength = 0;
        for (String s : arr) {
            maxLength = Math.max(maxLength, s.length());
        }

        // LSD - Loop through each character position
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            Map<Integer, List<String>> buckets = new HashMap<>();

            // Put strings into buckets
            for (String s : arr) {
                int key;
                if (pos < s.length()) {
                    key = s.charAt(pos);
                } else {
                    key = -1;
                }
                buckets.putIfAbsent(key, new ArrayList<>());
                buckets.get(key).add(s);
            }

            // Put buckets back into array
            int index = 0;
            for (int k = -1; k <= 255; k++) { // ASCII order, -1 first
                if (buckets.containsKey(k)) {
                    for (String s : buckets.get(k)) {
                        arr[index++] = s;
                    }
                }
            }
        }
    }
}

/*
Sources:
https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
https://www.cs.yale.edu/homes/aspnes/pinewiki/RadixSort.html
https://www.scss.tcd.ie/David.Gregg/cs3014/notes/18RadixSort.pdf
https://www.youtube.com/watch?v=t447vgH3Ixg
https://www.youtube.com/watch?v=XiuSW_mEn7g
ChatGPT formatting and ASCII Buckets
 */
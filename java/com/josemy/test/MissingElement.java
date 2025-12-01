import java.util.Arrays;

public class MissingElement {

    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3, 5};

        MissingElement missingElement = new MissingElement();
//        int missing = missingElement.findMissing(input);
//        int missing = missingElement.findMissingBinarySearch(input);
        int missing = missingElement.findMissingMath(input);
        if (missing >= 0) {
            System.out.println("Missing Number: " + missing);
        } else {
            System.out.println("There is not missing numbers");
        }
    }

    public static int findMissing(int[] input) {

        //Sort array
        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
            if (input[i] != i) {
                return i;
            }
        }
        return input.length;
    }

    public static int findMissingBinarySearch(int[] input) {

        int left = 0;
        int right = input.length -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (input[mid] == mid) {
                //All the elements from left to mid are OK. Move left to mid+1 position
                left = mid + 1;
            }
            else {
                //Missing element is from midle to left. Move right to mid-1 position
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * BONUS: Mathematical approach - O(n) time but O(1) space
     * Uses Gauss formula: sum of 0 to n = n*(n+1)/2
     */
    public static int findMissingMath(int[] numbers) {
        int n = numbers.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(numbers).sum();
        return expectedSum - actualSum;
    }
}

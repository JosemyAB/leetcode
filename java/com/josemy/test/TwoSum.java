import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 1; i < nums.length; i++){
            int difference = nums[i] - target;
            if (!index.containsKey(difference)) {
                index.put(difference, i);
            }
        }
        return null;
    }

}

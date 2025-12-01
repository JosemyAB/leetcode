import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] list = {1,2,3,3};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.hasDuplicate(list));
        System.out.println(cd.hasDuplicate_1(list));
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            }
            seen.add(nums[i]);
        }

        return false;
    }

    public boolean hasDuplicate_1(int[] nums) {
        return Stream.<int[]>of(nums).distinct().count() < nums.length;
    }

}



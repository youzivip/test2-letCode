package leetCode;

public class $136SingleNum {
    public int singleNumber(int[] nums) {
        int i = 0;
        for(int num:nums){
            i = i^num;
        }
        return i;
    }
}

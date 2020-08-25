package leetCode;

public class $137SingleNum2 {
    public int singleNumber(int[] nums) {
        int i = 0;
        for(int num:nums){
            i &= num;
        }
        for(int num:nums){
            i ^= num;
        }
        return i;
    }
}

package structure.array;

public class MaxBalance1 {
    public static void main(String[] args) {
        //System.out.println(a);
        int[] nums =  {7,1,5,3,6,4,9,45,17,89};
        int max = 0;
        int sum = 0;
        for (int i = 1;i<nums.length;i++){
            int r = nums[i] - nums[i-1];
            if (sum +r>0) sum+=r ;
            System.out.print(sum+" ");
            max = max>sum?max:sum;
        }
        System.out.println(sum);
        System.out.println(max);

    }




}

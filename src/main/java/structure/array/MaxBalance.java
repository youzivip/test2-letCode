package structure.array;

public class MaxBalance {
    public static void main(String[] args) {
        //System.out.println(a);
        int[] nums =  {7,1,5,3,6,4,9,45,17,89};
        int max = 0;
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    int r =  nums[j]-nums[i];
                    max = max>r?max:r;
                }
            }
        }
        System.out.println(max);

        // 2
        int[] r = new int[nums.length-1];
        int max3 = 0;
        for(int i = 0;i<nums.length-1;i++){
            r[i] = nums[i+1]-nums[i];
       //     System.out.print(r[i]+" ");
       //     max3 = max3>max3+r[i]?max3:max3+r[i];
        }
        System.out.println();
        int max_ending_here = 0;
        int max_so_far = 0;
        for (int i = 0; i < r.length; i++) {
            max_ending_here = max_ending_here + r[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        System.out.println(max_so_far);

  //      System.out.println(max3);
  //     int max2 =  findMax(nums,0,0);
   //     System.out.println(max2);
    }




    public static int findMax(int[] nums,int start,int max){
        if(start>=nums.length-1) return max;
   //     max = max > max+nums[start]?max: max+nums[start];

        int max2 =  findMax(nums,start,max+nums[start]);
        max = max-nums[start];
       int max1 =  findMax(nums,start,max);
       return max1>max2?max1:max2;
    }
}

package suanfa.fast;

import java.util.Random;
import java.util.UUID;

public class paidui {
    public static void main(String[] args) {
        int[] nums = new int[5000];
        for (int i = 0;i<nums.length;i++){
            nums[i] = i%2;
        }
        long start = System.currentTimeMillis();
        paidui2(nums);
        // paidui(nums,0 ,nums.length-1);
        long end = System.currentTimeMillis();
        System.out.println("使用了："+(end-start));
        for (int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void paidui2(int[] nums){
        int l = 0;
        int h = nums.length-1;
        while (l<h){
            if(nums[l] == 0) l++;
            else{
                if(nums[h] == 1) h--;
                else {
                    nums[h] = 1;
                    nums[l] =0;
                    l++;
                    h--;
                }
            }
        }

    }


    public static void paidui(int[] nums,int l,int h){
        if(l == h) return;
        if(nums[l] == 0) paidui(nums,++l,h);
        if(nums[l] == 1 && nums[h] == 0){
            nums[h] = 1;
            nums[l] = 0;
            paidui(nums,++l,--h);
        }
        if(nums[l] == 1 && nums[h] == 1) paidui(nums,l,--h);
    }



    public static void paidui1(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int index = (start+end)/2;
        int compare =  nums[index];
        while(start<end){
            while (start<index){
                if(nums[start] == compare) start++;
                else  {
                    nums[index] = nums[start];
                    index = start;
                }
            }
            while (end>index){
                if(nums[end] == compare) end--;
                else  {
                    nums[index] = nums[end];
                    index = end;
                }
            }
        }
        nums[index] = compare ;

    }
}

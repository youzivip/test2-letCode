package suanfa.fast;


import java.util.Random;

public class FastSort2 {
    public static void main(String[] args) {
        int[] nums = {2,45,2,55,67,3,56,78,9,0,9,0};
//        int[] nums = new int[50];
    /*    for (int i=0;i<50;i++){
            nums[i] = new Random().;
            System.out.print(i+",");
        }*/
        //      quickSort(nums,0,nums.length-1);
        quickSort(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+"<");
        }
    }

    public static void quickSort(int[] nums,int l,int h){
        if(l>=h) return;
        int index = findIndex2(nums,l,h);
        quickSort(nums,l,index-1);
        quickSort(nums,index+1,h);
    }

    private static int findIndex2(int[] nums, int l, int h) {
        int index = (l+h)/2;
        int compare = nums[index];
        while (l<h){
            while (l<index){
                if(nums[l]<=compare) l++;
                else {
                    nums[index]=nums[l]  ;
                    index = l;
                    break;
                }
            }
            while (h>index){
                if (nums[h]>compare) h--;
                else {
                    nums[index]=nums[h] ;
                    index = h;
                    break;
                }
            }
        }
        nums[index] =compare;
       return index;
    }

}

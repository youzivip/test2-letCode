package suanfa.fast;

public class FastSort3 {
    public static void main(String[] args) {
        int[] nums = {2,45,2,55,67,3,56,78,9,0,9,0};
//        int[] nums = new int[50];
    /*    for (int i=0;i<50;i++){
            nums[i] = new Random().;
            System.out.print(i+",");
        }*/
            sort3(nums,0,nums.length-1);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }

    }

    static void sort3(int nums[] ,int l, int h){
        if(l<h) {
            int index = findIndex(nums, l, h);
            if (l < index-1) sort3(nums, l, index - 1);
            if (h > index+1) sort3(nums, index + 1, h);
        }

    }

    static int findIndex(int[] nums,int l,int h){
        int index = l;
        int compare = nums[index];
        while (l<h){
            while (l<index){
                if(nums[l]<=compare) l++;
                else {
                    nums[index] = nums[l];
                    index = l;
                }
            }
            while (h>index){
                if(nums[h]>compare) h--;
                else {
                    nums[index] = nums[h];
                    index = h;
                }
            }
        }
        nums[index] = compare;
        return index;
    }

}

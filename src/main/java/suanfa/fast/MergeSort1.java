package suanfa.fast;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] nums = {2,45,2,55,67,3,56,78,9,0,9,0};
        sort1(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+"<");
        }
    }

    private static void sort1(int[] nums, int l, int h) {
        if(l<h){
            int mid = (l+h)/2;
            sort1(nums,l,mid);
            sort1(nums,mid+1,h);
            merge(nums,l,mid,h);
        }
    }

    private static void merge(int[] nums,int l,int mid,int h){
        int[] temp = new int[nums.length];
        int left = l,right = mid+1,i = l;
        while (left<=mid && right<=h){
            if(nums[left]<=nums[right]){
                temp[i++] = nums[left++];
            }else{
                temp[i++] = nums[right++];
            }
        }
        while (left<=mid){
            temp[i++] = nums[left++];
        }
        while (right<=h){
            temp[i++] = nums[right++];
        }
        for (int j = l;j<=h;j++){
            nums[j] = temp[j];
        }


    }


}

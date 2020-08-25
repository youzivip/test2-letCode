package suanfa.fast;

import java.util.stream.Stream;

public class FastSort {
    public static void main(String[] args) {
        int[] nums = {2,45,2,55,67,3,56,78};
  //      quickSort(nums,0,nums.length-1);
        fastSort(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+"<");
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }




    public static void fastSort(int[] nums,int l,int r){
        if(l >= r  ) return;
        int index = findIndex(nums,l,r);
        fastSort(nums,l,index-1);
        fastSort(nums,index+1,r);
    }



    public static int findIndex(int[] nums,int l ,int h){
     //   if(l==h) return 0;
        int i = (l+h)/2;
        int compare = nums[i];
        int index = i;
        while (l<h) {
            while (l < index) {
                if (nums[l] <= compare) {
                    l++;
                } else {
                    nums[index] = nums[l];
                    index = l;
                }
            }
            while (h > index) {
                if (nums[h] > compare) {
                    h--;
                } else {
                    nums[index] = nums[h];
                    index = h;
                }
            }
        }
        nums[index] = compare;
        return index;
    }
}

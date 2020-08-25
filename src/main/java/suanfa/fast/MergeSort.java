package suanfa.fast;

//归并排序 把数组两两排好序，然后合并排序数组
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2,45,2,55,67,3,56,78,9,0,9,0};
        sort(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+"<");
        }
    }

    public static void sort(int[] nums,int l,int h){
        if(l<h) {
            int mid = (l + h) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, h);
            merge(nums, l, mid, h);
        }
    }

    private static void merge(int[] nums, int l, int mid, int h) {
        int a = l ,b = mid+1,index = 0;
        int[] temp = new int[nums.length];
        while(a<=mid && b<=h){
            if(nums[a]<nums[b]){
                temp[index++] = nums[a++];
            }else {
                temp[index++] = nums[b++];
            }
        }
        while (a<=mid){
            temp[index++] = nums[a++];
        }
        while (b<=h){
            temp[index++] = nums[b++];
        }
        for (int i = l;i<=h;i++){
            nums[i] = temp[i-l];
        }
    }


    public static void mergeAndSort(int[] nums,int l,int h){
      //  if(l>=h) return;
        if(l<h) {
            int mid = (l + h )/ 2;
            mergeAndSort(nums, l, mid);
            mergeAndSort(nums, mid + 1, h);
            mergeNum(nums, l, mid, h);
        }
    }



    public static void mergeNum(int[] nums,int l,int mid,int h){
      //  if(l==h) return;
       int numTemp[] = new int[nums.length];
//       int index = 0;
//       int a=l,b=mid+1;
        int a = l ,b = mid+1,index = 0;
       while (a<=mid && b<=h){
           if(nums[a]<nums[b]){
               numTemp[index++] = nums[a++];
           }else {
               numTemp[index++] = nums[b++];
           }
       }
        while (a<=mid){
            numTemp[index++] = nums[a++];
        }
        while (b<=h){
            numTemp[index++] = nums[b++];
        }
//       for (int i = 0;i<index;i++){
//           nums[i+l] = numTemp[i];
//       }

        for (int i = l;i<=h;i++){
           nums[i] = numTemp[i-l];
       }
    }
}

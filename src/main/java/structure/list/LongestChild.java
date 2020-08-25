package structure.list;

import java.util.*;

/**
 *
 */
public class LongestChild {





    static int findLongest(int[] nums){
         //1  找到第一个重复的
        // 2  从第一重复的再开始找到下一个重复的
        int start=0;
        int l = 0;
        do{
            int newStart = findRepeatIndex(nums,start);
            l = l> newStart - start?l:newStart-start;
            start = newStart;
        }while (start<nums.length-1);
        // 3 到length
        return l;

    }

    static int findRepeatIndex(int[] nums,int start){
        int l = 0;
       // int r = 0;
        int index = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])  ) {
                int first = map.get(nums[i]);
                l = (i-index)> i - first?(i-index):i-first;
                index = index+1;
            }else if(i == nums.length-1){
                l = l>i-index?l+1:i-index+1;
            }
         //   l++;
            map.put(nums[i],i);
        }

     //   System.out.println("index-->"+index+","+nums[index]);
        return l;
    }

    static int findRepeat(int[] nums,int start,int end,int a){
        int repeat = 0;
        for(int i = start;i<end;i++){
            if(nums[i] == a) {
                repeat = repeat>end-i?repeat:end-i;
            }
        }
        if(repeat ==0 ) repeat= end+1 - start;
        return repeat;
    }
    public static int lengthOfLongestSubstring(String s)
    {
        int num=0;//记录最长子串长度
        int current=0;//记录当前子串长度
        char[] arr=s.toCharArray();
        LinkedList<Character> temp=new LinkedList<>();

        for (int i=0;i<arr.length ;i++ )
        {
            if (!temp.contains(arr[i]))
            {
                temp.add(arr[i]);
                current=temp.size();
                if (current>num)
                    num=current;
            }
            else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
            {
                temp.add(arr[i]);
                int first=temp.indexOf(arr[i]);

                for (int j=0;j<first ;j++ )
                    temp.remove();

                temp.remove();
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,1,5,6,7,8,9,4,5,11,17,78,90};
        System.out.println(findRepeatIndex(nums,0));
        String[] strs =new String[nums.length];
        String s="";
        for(int i = 0;i<nums.length;i++){
            strs[i]= nums[i]+"";
            s = s+nums[i];
        }
        System.out.println(lengthOfLongestSubstring("1234546789"));
    }
}

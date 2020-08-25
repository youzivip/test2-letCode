package structure.list;

import java.util.LinkedList;

public class LongestChild1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("1234546789"));
    }

    private static int lengthOfLongestSubstring1(String s) {
        char[] as = s.toCharArray();
        int max = 0;
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0;i<as.length;i++){
            if(list.contains(as[i])){
                max = list.size()>max?list.size():max;
                int index = list.indexOf(as[i]);
                for (int j = 0;j<=index;j++) {
                    list.removeFirst();
                }
            }
            list.add(as[i]);
        }
        max = list.size()>max?list.size():max;
        return max;
    }


}

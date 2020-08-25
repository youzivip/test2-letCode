package suanfa.dp;

public class HuiWen1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(hw("babadsassssssdasdasddssssssssssfafafdddddasdfasfaddfafasf"));
        long dur = System.currentTimeMillis()-start;
        System.out.println("--"+dur);
    }

    public static String hw(String s) {
        int len = s.length();
        int start = 0;
        int max = 1;
        // h[start][end] = 1
        int[][] h= new int[len][len];
        for (int i = 0;i<len;i++){
            h[i][i] = 1;
            if(i<len-1 && s.charAt(i) == s.charAt(i+1)){
                h[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }


        for(int l = 2;l <= len ;l++){
            for (int i = 0;i<len-l+1;i++){
                int end = i+l-1;
                if(s.charAt(i) == s.charAt(end) && h[i+1][end-1] == 1){
                    h[i][end] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        System.out.println("最长"+max);
        return s.substring(start,start+max-1);
    }
}

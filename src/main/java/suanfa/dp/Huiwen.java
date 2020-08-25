package suanfa.dp;

/**
 * dp[i][i]=1;//单个字符是回文串
 * dp[i][i+1]=1 if s[i]=s[i+1];//连续两个相同字符是回文串
 */
public class Huiwen {
    public static void main(String[] args) {
        System.out.println(longest("babadsassssssdasdasddssssssssssfafafdddddasdfasfaddfafasf"));
    }

    public static String longest(String s){
        int len = s.length();
        // 1 字回文
        if(len == 0 || len == 1) return s;
        int start = 0;
        int max = 1;
        int dp[][] = new int[len][len];
        for (int i = 0;i<len;i++){
            dp[i][i] = 1;
            if(i<len-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }

        for (int l = 3;l<=len;l++){
            for (int i = 0;i+l-1<len;i++){
                int j = l+i-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){  //状态转移
                    dp[i][j] = 1;  //是一，不是字母l
                    start = i;
                    max = l;
                }
            }
        }
        System.out.println("最长"+max);
        return s.substring(start,start + max);   //获取最长回文子串

    }
}

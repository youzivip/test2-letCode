package suanfa.dp;

import java.util.HashMap;
import java.util.Map;

public class dpTest {
    public static void main(String[] args) {
        System.out.println(uniqPath(3,4));
        System.out.println(net(19,24));

    }

    static int uniqPath(int m,int n){
        if(m<=0 || n<=0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i= 0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<m;i++){
            for (int j=i;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    static Map<String,Long> map =new HashMap<>();

    //网格最近
    static long net(int x,int y){
        if(x == 0 || y == 0){
            return 0;
        }
        if(x== 1 || y ==1){
            return 1;
        }
        String k1 = x-1+""+y;
        String k2 = x+""+(y-1);
        if(map.get(k1)==null){
            map.put(k1,net(x-1,y));
        }
        if(map.get(k2)==null){
            map.put(k2,net(x,y-1));
        }

         return map.get(k1)+map.get(k2);
    }

}

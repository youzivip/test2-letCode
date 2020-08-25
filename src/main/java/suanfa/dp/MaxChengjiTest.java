package suanfa.dp;

public class MaxChengjiTest {
    public static void main(String[] args) {
        double[] nums = {1,3,4,0.1,-2,3,5,6,15,0.1,13,0.1,3,2};
        System.out.println(findMax(nums));
    }

    static double findMax(double[] nums){
        int len = nums.length;
        double[][] dp = new double[len][len];
        double max = 0;
        int start = 0,end = 0;
        // i开始 j 结束位置   dp[i][j] = dp[i][j-1]*nums[j]
         // dp[j][j] =
        for (int i = 0;i<len;i++){
            dp[i][i] = nums[i];
            if(max < nums[i]){
                max = nums[i];
                start = i;
                end = i;
            }
        }
        for(int i = 0;i<len-1;i++){
            for(int j = i+1;j<len;j++){
                dp[i][j] = dp[i][j-1]*nums[j];
                if(max < dp[i][j]){
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(String.format("开始位置：%s,结束位置：%s",start,end));
        return max;
    }

}

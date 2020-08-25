package structure.array;

public class Candy {

    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4,3,3};
        System.out.println(candy(nums));
    }

    public static int candy(int[] ratings) {
        int g[] = new int[ratings.length];
        g[0] = 1;
//        if(ratings[0]<= ratings[1] ) g[0] = 1;
//        else g[0] = 2;
        for (int i = 1;i<ratings.length ;i++){
            if(ratings[i]>ratings[i-1]) g[i] = g[i-1]+1;
            else g[i] = 1;
        }
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) g[i] = g[i]>g[i+1]+1?g[i]:g[i+1]+1;
        }
        int sum = 0;
        for (int i:g){
            sum+=i;
        }
        return sum;
    }
}

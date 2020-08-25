package others;

public class AddTwoStr {
    public static void main(String[] args) {
        long a = 9814241846283l;
        long b = 8786543l;
        int x = (int)((a+"").charAt(12));
        int y = (b+"").charAt(6);
        int z = x+y;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(addStr(a+"",b+""));
        System.out.println(a+b);


    }

    static String addStr(String s1,String s2){
        String r = "";
        int i = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while(len1>0 && len2>0){
            int x = s1.charAt(--len1)-48;
            int y = s2.charAt(--len2)-48;
            int a = x+y+i;
            r=(a%10)+r;
            i = a/10;
        }
        while(len1>0){
            int x = s1.charAt(--len1)-48;
            int a = x+i;
            r=(a%10)+r;
            i = a/10;
        }
        while(len2>0){

            int y = s2.charAt(--len2)-48;
            int a = y+i;
            r=(a%10)+r;
            i = a/10;
        }
        if(i == 1) r=1+r;
        return r;
    }
}

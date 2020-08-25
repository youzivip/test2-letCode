package suanfa.huisu;

public class QuanPai {
    public static void main(String[] args) {
        qp("dasdasdasdasdasdads",'s');
    }
    public static void qp(String s,char c){
        if(s.length()==0) {
            System.out.println(c);
            return;
        }
        System.out.println(s+c);
        System.out.println(c+s);
        qp(s.substring(0,s.length()-1),s.charAt(s.length()-1));
    }
}

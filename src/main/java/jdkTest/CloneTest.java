package jdkTest;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("da","db");
        Person person1 = person;
        Person person2 =( person.clone());
        System.out.println("=="+(person==person1));
        System.out.println("clone=="+(person==person2)+" "+person2);
        person1.a = "dasda";
        person2.a = "22222";
        System.out.println(person.a);
    }
}

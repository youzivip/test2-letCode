package jdkTest;

public class Person implements Cloneable{
    String a;
    String b;

    public Person(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "a:"+a+",b:"+b;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

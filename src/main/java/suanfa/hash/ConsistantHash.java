package suanfa.hash;

import java.util.Map;

import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistantHash {
    static TreeMap<Integer,String> nodes = new TreeMap<>();
    static {
        nodes.put(1000,"node1");
        nodes.put(2000,"node1");
        nodes.put(3000,"node1");
        nodes.put(4000,"node1");
    }
    public static void main(String[] args) {
        String a = "dasdasd";
        int i = a.hashCode()%4000;


    }
}

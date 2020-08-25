package suanfa.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMapTest {
    public static void main(String[] args) {
        //testMyMap();
      //  Map<String ,Integer> map = new HashMap<>();

        Map<String ,Integer> map = new ConcurrentHashMap<>();
        map.put("test",1);
        map.put("test",2);
        map.get("test");

        ExecutorService pool = Executors.newFixedThreadPool(30);
        for(int i = 0;i<100000;i++){
            pool.execute(()->{
                int r = new Random().nextInt();
                map.put(r+"",r);
                System.out.println(r+"--"+map.get(r+""));
            });
        }
    }

    private static void testMyMap() {
        MyMap<String ,Integer> map = new MyMap<>();
        map.put("1213",2);
        System.out.println(map.get("1213"));
    }
}

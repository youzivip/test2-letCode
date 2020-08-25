package structure.list;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSkipTest {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0;i<10000;i++){
            pool.execute(()->{
                Integer in = new Random().nextInt();
                set.add(in);
                System.out.println(set.contains(in));
            });
        }
    }
}

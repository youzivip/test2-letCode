package structure.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class queueTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String ss = topics.replaceAll("\n",",");
        System.out.println(ss);
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(1);
//        queue.add(29);
//        queue.add(23);
//        System.out.println(queue.offer(1));
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());

    }

    static String topics="PaySettle_Order_Split\n" +
            "idn_duizhang_success\n" +
            "orderbank_pdb1_task_0015\n" +
            "orderbank_pdb2_task_0015\n" +
            "orderbank_pdb3_task_0015\n" +
            "orderbank_pdb4_task_0015\n" +
            "orderbank_pdb5_task_0015\n" +
            "orderbank_pdb6_task_0015\n" +
            "orderbank_pdb7_task_0015\n" +
            "orderbank_pdb8_task_0015\n" +
            "orderbank_pdb9_task_0015\n" +
            "orderbank_pdb1_task_unlock\n" +
            "orderbank_pdb2_task_unlock\n" +
            "orderbank_pdb3_task_unlock\n" +
            "orderbank_pdb4_task_unlock\n" +
            "orderbank_pdb5_task_unlock\n" +
            "orderbank_pdb6_task_unlock\n" +
            "orderbank_pdb7_task_unlock\n" +
            "orderbank_pdb8_task_unlock\n" +
            "orderbank_pdb9_task_unlock\n" +
            "orderbank_pdb10_task_0015\n" +
            "orderbank_pdb11_task_0015\n" +
            "orderbank_pdb12_task_0015\n" +
            "orderbank_pdb13_task_0015\n" +
            "orderbank_pdb14_task_0015\n" +
            "orderbank_pdb15_task_0015\n" +
            "orderbank_pdb16_task_0015\n" +
            "orderbank_pdb17_task_0015\n" +
            "orderbank_pdb18_task_0015\n" +
            "orderbank_pdb19_task_0015\n" +
            "orderbank_pdb20_task_0015\n" +
            "orderbank_pdb21_task_0015\n" +
            "orderbank_pdb22_task_0015\n" +
            "orderbank_pdb23_task_0015\n" +
            "orderbank_pdb24_task_0015\n" +
            "orderbank_pdb24_task_0010\n" +
            "orderbank_pdb23_task_0010\n" +
            "orderbank_pdb22_task_0010\n" +
            "orderbank_pdb21_task_0010\n" +
            "orderbank_pdb20_task_0010\n" +
            "orderbank_pdb19_task_0010\n" +
            "orderbank_pdb18_task_0010\n" +
            "orderbank_pdb17_task_0010\n" +
            "orderbank_pdb16_task_0010\n" +
            "orderbank_pdb15_task_0010\n" +
            "orderbank_pdb14_task_0010\n" +
            "orderbank_pdb12_task_0010\n" +
            "orderbank_pdb4_task_0010\n" +
            "orderbank_pdb11_task_0010\n" +
            "orderbank_pdb10_task_0010\n" +
            "orderbank_pdb9_task_0010\n" +
            "orderbank_pdb5_task_0010\n" +
            "orderbank_pdb6_task_0010\n" +
            "orderbank_pdb7_task_0010\n" +
            "orderbank_pdb8_task_0010\n" +
            "orderbank_pdb3_task_0010\n" +
            "orderbank_pdb2_task_0010\n" +
            "orderbank_pdb1_task_0010\n" +
            "orderbank_pdb13_task_0010\n" +
            "orderbank_pdb24_task_unlock\n" +
            "orderbank_pdb23_task_unlock\n" +
            "orderbank_pdb22_task_unlock\n" +
            "orderbank_pdb21_task_unlock\n" +
            "orderbank_pdb20_task_unlock\n" +
            "orderbank_pdb19_task_unlock\n" +
            "orderbank_pdb18_task_unlock\n" +
            "orderbank_pdb17_task_unlock\n" +
            "orderbank_pdb16_task_unlock\n" +
            "orderbank_pdb15_task_unlock\n" +
            "orderbank_pdb14_task_unlock\n" +
            "orderbank_pdb13_task_unlock\n" +
            "orderbank_pdb12_task_unlock\n" +
            "orderbank_pdb11_task_unlock\n" +
            "orderbank_pdb10_task_unlock\n" +
            "PS_DuiZhang_Success_YaCe\n" +
            "PaySettle_DB_Sync_YaCe\n" +
            "PaySettle_DZ_Wait_YaCe\n" +
            "PaySettle_Pay_Surplus_YaCe\n" +
            "PS_DuiZhang_Pos_YaCe\n" +
            "PaySettle_MorePayRefund_YaCe\n" +
            "monitor_call_ordermid_YaCe";
}

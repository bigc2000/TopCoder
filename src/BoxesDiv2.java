import java.util.*;

/**
 * SRM 622,DIV2 ,2
 * @author Free
 */

public class BoxesDiv2 {
    public BoxesDiv2() {
    }


    public int findSize(int[] candyCounts) {
        Arrays.sort(candyCounts);
        for (int i = 0; i < candyCounts.length; i++) {
            int v = candyCounts[i];
            int j = 1;
            while (j < v) {
                j <<= 1;
            }
            candyCounts[i] = j;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(candyCounts.length);
        for (int i = 0; i < candyCounts.length; i++) {
            pq.add(candyCounts[i]);
        }
        while (!pq.isEmpty()) {
            Integer v1 = pq.peek();
            pq.poll();
            if (pq.isEmpty()) {
                return v1;
            }
            Integer v2 = pq.peek();
            pq.poll();
            int v3 = v1 + v2;
            int j = 1;
            while (j < v3) {
                j <<= 1;
            }
            pq.add(j);
        }
        return 1;
    }

    public static void main(String args[]) {
        BoxesDiv2 box = new BoxesDiv2();
        System.out.println(box.findSize(new int[]{1, 7}));
    }

}

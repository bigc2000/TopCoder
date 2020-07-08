import java.util.Arrays;
import java.util.TreeSet;

public class P239 {
    static class PQ {
        int value;
        int idx;

        public String toString() {
            return value + "," + idx;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        PQ pq[] = new PQ[k + 1];
        for (int i = 0; i < k; i++) {
            pq[i + 1] = new PQ();
            pq[i + 1].value = nums[i];
            pq[i + 1].idx = i;
        }
        for (int i = k / 2; i >= 1; i--) {
            sink(pq, i);
        }
        int c = 0;
        do {
            ans[c] = pq[1].value;
            if (c + k >= nums.length) {
                break;
            }
            int i = 1;
            for (i = 1; i < pq.length; i++) {
                if (pq[i].idx == c) {
                    break;
                }
            }
            if (i >= pq.length) {
                System.out.println("error");
            }

           // swap(pq, i, k);
            pq[i].value = nums[c + k];
            pq[i].idx = c + k;
            sink(pq, i);
            //shifup
            siftup(pq, i);
            c++;
        } while (c < nums.length - k + 1);
        return ans;
    }

    void swap(PQ pq[], int i, int j) {
        int t = pq[i].value;
        pq[i].value = pq[j].value;
        pq[j].value = t;
        t = pq[i].idx;
        pq[i].idx = pq[j].idx;
        pq[j].idx = t;
    }

    void siftup(PQ pq[], int i) {
        int j;
        while (i > 1) {
            j = i / 2;
            if (pq[j].value >= pq[i].value) {
                break;
            } else {
                swap(pq, i, j);
                i = i / 2;
            }
        }
    }

    void sink(PQ pq[], int i) {
        while (i * 2 < pq.length) {
            int ch1 = i * 2;
            int ch2 = i * 2 + 1;
            int parent = i;
            int big = ch1;
            if (ch2 < pq.length && pq[ch1].value < pq[ch2].value) {
                big = ch2;
            }
            if (pq[parent].value < pq[big].value) {
                swap(pq, parent, big);
                i = big;
            } else {
                break;
            }
        }
    }
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }

        int remain = n;
        int  cur = 0;

        TreeSet<Integer> v = new TreeSet();
        v.add(1);

        do{
            cur = v.pollFirst();
            remain--;
            System.out.println(v.size());
            if(cur < Integer.MAX_VALUE/2){
                v.add(2*cur);
            }
            if(cur < Integer.MAX_VALUE/3){
                v.add(3*cur);
            }
            if(cur < Integer.MAX_VALUE/5){
                v.add(5*cur);
            }
        }while(remain!=0);
        return cur;
    }

    public static void main(String args[]) {
        P239 p239 = new P239();
        p239.nthUglyNumber(1690);
      //  Arrays.stream(p239.maxSlidingWindow(new int[]{1, 3, -1, -3, 0, 0, 0, 2, 5, 3, 6, 0, 5, 4, 3, -2, 7, -1, -1, 7}, 5)).forEach(System.out::println);


        Arrays.stream(p239.maxSlidingWindow(new int[]{-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7}, 7)).forEach(System.out::println);

    }

}

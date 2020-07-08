import java.util.*;

public class WordLadder {
    static boolean oneChange(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff >= 2) {
                return false;
            }
        }
        return diff == 1;
    }

    static class PairCmp implements Comparator<PairCmp>, Comparable<PairCmp> {
        int parent;
        int cur;
        int level;

        PairCmp(int parent, int cur, int level) {
            this.parent = parent;
            this.cur = cur;
            this.level = level;
        }

        @Override
        public int compare(PairCmp left, PairCmp right) {
            return left.level < right.level ? -1 : left.level == right.level ? 0 : 1;
        }

        @Override
        public int compareTo(PairCmp pairCmp) {
            return compare(this, pairCmp);
        }

        @Override
        public String toString() {
            return "PairCmp{" +
                    "parent=" + parent +
                    ", cur=" + cur +
                    ", level=" + level +
                    '}';
        }
    }

    ;

    int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //set<string> open;
        //open.insert(wordList.begin(), wordList.end());
        Set<Integer> closed = new HashSet<>();
        PriorityQueue<PairCmp> q = new PriorityQueue<>();

        q.add(new PairCmp(-1, -1, 0));
        if (!wordList.contains(endWord)) {
            return 0;
        }
        while (!q.isEmpty()) {
            PairCmp cur = q.poll();

            String str;
            if (cur.cur == -1) {
                str = beginWord;
            } else {
                str = wordList.get(cur.cur);
            }
          //  System.out.println(cur + "" + str);
            if (str.equals(endWord)) {
                return cur.level + 1;
            }

            for (int i = 0; i < wordList.size(); i++) {
                if (oneChange(str, wordList.get(i)) && !closed.contains(i)) {
                    closed.add(i);
                    q.add(new PairCmp(cur.cur, i, cur.level + 1));
                }
            }
        }
        return 0;
    }
    static class PQ{
        int value;
        int idx;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        PQ pq[] = new PQ[k+1];
        for(int i=0;i<k;i++){
            pq[i+1]= new PQ();
            pq[i+1].value = nums[i];
            pq[i+1].idx= i;
        }
        for (int i=k/2;i>=1;i--){
            sink(pq,i);
        }
        int c=0;
        do{
            ans[c]=pq[1].value;
            int i=1;
            int idx=0;
            for(i=1;i<pq.length;i++){
                if(pq[i].idx ==c){
                    break;
                }
            }
            swap(pq,i,k);
            sink(pq,i);

            pq[k].idx = pq[i].idx+k;
            if(pq[k].idx >k){
                break;
            }
            pq[k].value = nums[pq[k].idx];
            //shifup
            siftup(pq,k);
            c++;
        }while(c<nums.length-k+1);
        return ans;
    }

    void swap(PQ pq[],int i,int j){
        int t = pq[i].value;
        pq[i].value = pq[j].value;
        pq[j].value=t;
        t = pq[i].idx;
        pq[i].idx= pq[j].idx;
        pq[j].idx=t;
    }
    void siftup(PQ pq[],int i){
        int j;
        while(i>=1){
            j=i/2;
            if(pq[j].value >=pq[i].value){
                break;
            }
            else{
                swap(pq,i,j);
                i=i/2;
            }
        }
    }
    void sink(PQ pq[],int i){
        while(i*2 < pq.length){
            int ch1 = i*2;
            int ch2 = i*2+1;
            int parent = i;
            int big=ch1;
            if(ch2<pq.length && pq[ch1].value<pq[ch2].value){
                big = ch2;
            }
            if(pq[parent].value < pq[big].value){
                swap(pq,parent,big);
                i=big;
            }
        }
    }


    public static void main(String args[]) {

        int val = new WordLadder().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(val);
    }
}

import java.util.*;

public class CombinationSum3 {
    static class Pair {
        int n, k,largest;
        List<List<Integer>> ans = new ArrayList<>();


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return n == pair.n &&
                    k == pair.k && largest == pair.largest
                    ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, k,largest);
        }
    }

    Set<Pair> cache = new HashSet<Pair>();


    public List<List<Integer>> combinationSum3(int k, int n,int largest) {
        if(k==1){
            List<Integer> list = new ArrayList<>();
            list.add(n);
            List<List<Integer>> ret =  new ArrayList<>();
            ret.add(list);
            return ret;
        }
        int start = (n+k-1)/k;
        //int end = n - k*(k-1)/2;
        List<List<Integer>> sum =  new ArrayList<>();
        for(int i=start;i<=largest;i++){
            sum.addAll(combinationSum3(k-1,n-i,i));
        }
        return sum;
    }
}

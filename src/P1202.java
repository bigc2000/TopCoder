import java.util.*;

public class P1202 {
    static class UnionFind{
        int x;
        int weight;
        int parent;
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, Set<Integer>> permutations = new HashMap<>();
        for (List<Integer> pair : pairs) {
//            int a = pair.get(0);
//            int b = pair.get(1);
//
//            Set<Integer> aClique = permutations.getOrDefault(a,new TreeSet<>());
//            Set<Integer> bClique = permutations.getOrDefault(b,new TreeSet<>());
//            for(Integer x:aClique){
//
//            }
//
//            if (aClique != null) {
//                aClique.add(a);
//                aClique.add(b);
//                if (bClique != null) {
//                    if (aClique != bClique) {
//                        aClique.addAll(bClique);
//                    }
//                } else {
//                    permutations.put(b, aClique);
//                }
//            } else if (bClique != null) {
//                bClique.add(a);
//                bClique.add(b);
//                permutations.put(a, bClique);
//            } else {
//                Set<Integer> clique = new TreeSet<>();
//                clique.add(a);
//                clique.add(b);
//                permutations.put(a, clique);
//                permutations.put(b, clique);
//            }
        }
        char ans[] = new char[s.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = s.charAt(i);
        }

        for (Set<Integer> clique : permutations.values()) {
            char[] ch = new char[clique.size()];
            int i = 0;
            for (Integer idx : clique) {
                ch[i++] = s.charAt(idx);
            }
            Arrays.sort(ch);
            i = 0;
            for (Integer idx : clique) {
                ans[idx] = ch[i++];
            }
        }
        return new String(ans);
    }

    public static void main(String args[]) {

        P1202 p1202 = new P1202();
        List<List<Integer>> pairs = new ArrayList<>();
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(0);
        p1.add(3);
        pairs.add(p1);
        ArrayList<Integer> p2 = new ArrayList<>();
        p2.add(1);
        p2.add(2);
        pairs.add(p1);
        pairs.add(p2);
        ArrayList<Integer> p3 = new ArrayList<>();
        p3.add(0);
        p3.add(2);
        pairs.add(p3);
        System.out.println(p1202.smallestStringWithSwaps("dcab", pairs));
    }
}

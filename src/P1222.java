import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        //encode queens
        HashMap<Integer,ArrayList<Integer>> directions= new HashMap<>();

        for(int i = 0;i<queens.length;i++){
            int x = queens[i][0];
            int y= queens[i][1];
            int pos = 8*x+y;
            ArrayList<Integer> L1 = new ArrayList<>();
            L1.add(pos);
            directions.merge(8*x,L1,(a,b)->{a.addAll(b);return a;});
            ArrayList<Integer> L2 = new ArrayList<>();
            directions.merge(y,L2,(a,b)->{a.addAll(b);return a;});
            int x1=x;
            int y1=y;
            int x2=-x;
            while(y1!=0){
                x1++;
                x2--;
            }
            ArrayList<Integer> L3 = new ArrayList<>();
            directions.merge(x1+8,L3,(a,b)->{a.addAll(b);return a;});
            ArrayList<Integer> L4 = new ArrayList<>();
            directions.merge(x2,L4,(a,b)->{a.addAll(b);return a;});
        }
        int x = king[0];
        int y = king[1];

        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

        //4 direction
        ArrayList<Integer> hor = directions.getOrDefault(8*x,new ArrayList<>());
        int leftY;
        int rightY;
        for(int i=0;i<hor.size();i++){
            int pos = hor.get(i);
            int qx = pos/8;
            int qy = pos%8;

        }
    }
    public static void main(String args[]){

    }
}

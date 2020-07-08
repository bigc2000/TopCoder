/**
 * User: Free
 * Date: 14-6-21
 * Time: 上午9:33
 */
import java.util.*;
public class IncrementingSequence{
    class Vertex{
        int i;

    }
    class Edge{

    }


    public String canItBeDone(int k, int[] A)
    {
        String Y = "POSSIBLE";
        String N= "IMPOSSIBLE";
        int i=0;

        //int b[][]=new int[A.length][A.length];
          ArrayList<Integer>[] b = new ArrayList[A.length];
        for( i=0;i<A.length;i++){
            b[i]=new ArrayList<Integer>()   ;
            for(int j=0;j<A.length;j++){
                //A[i] can be done to j+1
                if((j+1 -A[i])%k==0 ){
                    b[i].add(j);
                }
                else {
                    //b[i].add(j)
                }
            }
        }
        //find b[i][j] the 1,each col and row only once,bipartialgraph match
        //graph max flow
         for(int c=0;c<A.length;c++){
             if(b[c].isEmpty()){
                 return N;
             }
         }
        return Y;
    }
    public static void main(String args[]){
        IncrementingSequence seq = new IncrementingSequence();
        System.out.println(seq.canItBeDone(2, new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

}
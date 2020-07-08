import java.util.*;

/**
 * SRM 622,DIV2,3
 * User: Free
 * Date: 14-5-29
 * Time: 下午11:43
 */
public class Subsets {
    static class State implements Comparable<State>{
        int vertex;
        long sum;
        long product;
        float sort;
        int len;
        State pre;
        int count[];

        @Override
        public int compareTo(State o) {
          if( sort ==o.sort)return 0;
          return sort <o.sort ?-1:1;
        }
    }

    public
    int findSubset(int[] numbers){

//        Arrays.sort(numbers);
//        if(numbers[0]!=0){
//            return 0;
//        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            Integer old = treeMap.get(numbers[i]);
            if(old !=null){
                  treeMap.put(numbers[i],old+1);
            }
            else
                treeMap.put(numbers[i],1);
        }
        if(treeMap.size()==0||!treeMap.containsKey(1)) {
            return 0;
        }

        //build a graph;use dijkstra,find all paths,that path match the rule

        int verts []  = new int[treeMap.keySet().size()];
        int i=0;


        int visited[]=new int[treeMap.keySet().size()];
        int invalid[]                                    =new int[treeMap.keySet().size()];
        i=0;
        for(Map.Entry<Integer,Integer> e:treeMap.entrySet()){
            verts[i]=e.getKey();
            visited[i]=e.getValue();
            invalid[i]=0;
            i++;
        }


        //bfs
        PriorityQueue<State> pq =new PriorityQueue<State>();
        State top = new State()

                       ;
        top.count = new int[1];
        top.count[0]=1;
        top.product=verts[0];
        top.len=0;
        top.pre=null;
        top.sum=verts[0];
        top.vertex=0;
        pq.add(top);
        int ans=0;

        while (pq.size()>0){
            top = pq.poll() ;
     //       visited[top.vertex]--;
            if(top.sum>=top.product){
                State pre= top;
                 do{
                    State s=pre;
                     System.out.print(verts[s.vertex]+",");
                     pre = s.pre;
                 }while (pre!=null);
                System.out.println();
                ans++;
            }
            else{
                //no sort answer;
                break;
            }

            for( i=0;i<verts.length;i++)
                {

                    if(verts[top.vertex] <=verts[i] && invalid[i]==0)
                    {
                    //check sort;
                    State s = new State();
                   if(verts[top.vertex]<verts[i]){

                   }else{
                       State pre= top;
                       int c=0;
                       do{
                          if(verts[pre.vertex] == verts[i]){
                              c++;
                           }
                           pre = pre.pre;
                       }while (pre!=null);
                       if(c>=visited[i]){
                           invalid[i]=1;
                           continue;
                       }
                   }
                        State pre= top;
                        s.pre =top;
                        s.vertex=i;
                        s.sum = top.sum+verts[i];
                        s.product = top.product*verts[i];
                        s.sort = (float)s.product/s.sum;
                        s.len=top.len+1;
                        pq.add(s);


                    }


            }
        }
        return ans;


    }

    public static void main(String args[]){
        Subsets s = new Subsets();
        System.out.println(s.findSubset(new int[]{1,1,1,1,2,2,2,2}));
}
}

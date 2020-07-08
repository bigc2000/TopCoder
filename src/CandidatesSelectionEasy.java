import java.util.Arrays;

/**
 * User: Free
 * Date: 14-5-11
 * Time: 上午12:03
 */
public class CandidatesSelectionEasy {

    public static class Elem implements  Comparable<Elem>{
        String score;
        int x;
        int index;
        public void  sort(){

        }
        @Override
        public int compareTo(Elem o){
            if( this.score.charAt(x)==o.score.charAt(x))
                return 0;
            return this.score.charAt(x)<o.score.charAt(x)?-1:1;
        }


    }



    public int[] sort(String[] score, int x){
        int ret[]=new int[score.length];
        int N = score.length;
        int M = score[0].length();
        Elem elems[] = new  Elem[N];


        for(int i=0;i<N;i++){
            elems[i] = new Elem();
            elems[i].score = score[i];
            elems[i].x = x;
            elems[i].index = i;
        }
        Arrays.sort(elems);
//        for(int i=0;i<N;i++){
//            int k= i;
//            for(int j=i+1;j<N;j++){
//
//                if(elems[j].compareTo(elems[i])<0)
//                {
//                     k=j;
//                }
//            }
//            if(k!=i){
//                Elem temp =elems[i];
//                elems[i]=elems[k];
//                elems[k]=temp;
//            }
//
//        }
       for(int i=0;i<N;i++){
           ret[i]=elems[i].index;
       }
        return ret;
    }
    public static void main(String args[]){
        String s[] = new String[]{"A", "C", "B", "C", "A"}   ;
        CandidatesSelectionEasy e = new CandidatesSelectionEasy();
        int ret[]=e.sort(s,0);
        for(int i=0;i<ret.length;i++)
            System.out.println(ret[i])           ;
    }

}

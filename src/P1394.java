import java.util.Map;
import java.util.TreeMap;

public class P1394 {

    class Solution {
        public int findLucky(int[] arr) {
            TreeMap<Integer,Integer> group = new TreeMap<>();
            for(int i=0;i<arr.length;i++){
                group.merge(arr[i],1,(x,y)->x+y);
            }

            for(Map.Entry<Integer,Integer> e:group.descendingMap().entrySet()){
                if(e.getKey() == e.getValue()){
                    return e.getKey();
                }
            }

            return -1;

        }
    }
}

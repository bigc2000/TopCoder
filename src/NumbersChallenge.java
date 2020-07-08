import java.util.Arrays;
import java.util.*;

/**
 * User: Free
 * Date: 14-5-20
 * Time: 下午11:23
 */
public class NumbersChallenge {


    public int MinNumber(int[] S) {
        int len = S.length;
        Arrays.sort(S);

        TreeSet<Integer> all = new TreeSet<Integer>();
        for (int i = 1; i < (1 << len); i++) {
            int sum = 0;
            int tempNum = i;
            int j = 0;
            while (tempNum != 0) {
                if ((tempNum & 1) != 0) {
                    sum += S[j];
                }
                tempNum >>= 1;
                j++;
            }
            all.add(sum);
        }

        int j = 1;
        Iterator<Integer> it = all.iterator();
//        while (it.hasNext()) {
//            Integer k = it.next();
//            if (k > 1) {
//                return 1;
//            } else if (k == 1) {
//                j++;
//                break;
//            }
//        }
        while (it.hasNext()) {
            Integer k = it.next();
            if(j<k)
            {
                return j;
            }
            else if(j==k){
                j++;
            }
        }
        return j;
    }
}

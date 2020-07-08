/**
 * User: Free
 * Date: 14-5-20
 * Time: 下午11:05
 */
public class TwoWaysSorting {

    public String sortingMethod(String[] stringList) {
        String A = "lexicographically";
        String BOTH = "both";
        String NONE = "none";
        String L = "lengths";
        boolean isLen = false;
        boolean isA = false;

        //length
        if (stringList.length == 1) {
            return BOTH;
        }

        int i = 0;
        for (; i < stringList.length - 1; i++) {

            if (stringList[i].length() >= stringList[i + 1].length()) {
                break;
            }
        }
        if (i >= stringList.length - 1) {
            isLen = true;
        }


        i=0;
        for (; i < stringList.length - 1; i++) {
            if (stringList[i].compareTo(stringList[i + 1]) >= 0) {
                break;
            }
        }
        if (i >= stringList.length - 1) {
            isA = true;
        }
        if (isA && isLen) {
            return BOTH;
        }
        if (isA) {
            return A;
        }
        if (isLen) {
            return L;
        }

        return NONE;

    }
    public static void main(String args[])
    {
       // {"c", "bb", "aaa"};
    }


}

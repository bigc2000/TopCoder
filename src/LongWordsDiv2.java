
import java.util.*;
public class LongWordsDiv2 {

    public String find(String word) {
        String Y = "Likes";
        String N = "Dislikes";
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                return N;
            }
        }
        int i;
        int m;
        for (i = 0; i < word.length(); i++) {
            m = i;

            while (m !=-1) {
                int j;
                for (j = m+1; j < word.length(); j++) {
                    int n = j;
                    n= word.indexOf(word.charAt(j), n+1);
                    while (n > j) {
                        if (n > m) {
                            return N;
                        }
                        n= word.indexOf(word.charAt(j), n+1);
                    }
                }
                m = word.indexOf(word.charAt(i), m + 1);
            }
            m = word.indexOf(word.charAt(i), m + 1);
        }

       return Y;
}

    public static void main(String args[]) {
        LongWordsDiv2 w = new LongWordsDiv2();
        System.out.println(w.find("ABCBAC"));

    }

}

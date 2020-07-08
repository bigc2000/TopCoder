import java.util.*;

public class P1209 {
    public String removeDuplicates(String s, int k) {
        int i = 0;
        while (true) {
            i=0;
            ArrayList<Integer> removed = new ArrayList();
            while (i < s.length()) {
                int c = 0;
                char ch = s.charAt(i);
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == ch) {
                    j++;
                }
                c = j - i;
                if (c >= k) {
                    removed.add(i);
                    removed.add(i + c / k * k);
                }
                i = j;
            }
            if (removed.isEmpty()) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            int left = 0;
            int right = removed.get(0);
            for (int x = 0; x < removed.size(); x += 2) {
                right = removed.get(x);
                if (left < right) {
                    sb.append(s.substring(left, right));
                }
                left = removed.get(x + 1) ;
            }
            if (left < s.length()) {
                sb.append(s.substring(left, s.length()));
            }
            s = sb.toString();
        }
        return s;

    }

    public static void main(String args[]) {
        System.out.println(new P1209().removeDuplicates(
                "deeedbbcccbdaa", 3));
        System.out.println(new P1209().removeDuplicates(
                "pbbcggttciiippooaais", 2));
    }
}

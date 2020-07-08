public class P1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int remain;
        int left = 0;
        int right = 0;
        int ans = 0;
        {
            remain = maxCost;
            int j = right;
            while (right < s.length()) {
                j = right;
                int cost = 0;

                for (; j < s.length(); ) {
                    cost = Math.abs(s.charAt(j) - t.charAt(j));
                    remain -= cost;
                    if (remain >= 0) {
                        j++;
                    }
                    else{
                        break;
                    }
                }

                right = j;
                if (right - left > ans) {
                    ans = right - left;
                }
                while (remain < 0 && left < right) {
                    remain += Math.abs(s.charAt(left) - t.charAt(left));
                    left++;
                }
                if(left ==right){
                    right ++;
                }
                if (cost > maxCost) {
                    left = right = j + 1;
                    remain = maxCost;
                }
            }
        }
        return ans;

    }

    public static void main(String args[]) {
        P1208 p1208 = new P1208();
       System.out.println(p1208.equalSubstring("ujteygggjwxnfl","nstsenrzttikoy",43));
    }
}

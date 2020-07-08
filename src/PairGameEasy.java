/**
 * User: Free
 * Date: 14-5-11
 * Time: 上午12:52
 */
public class PairGameEasy
{
  public  String able(int a, int b, int c, int d)
    {
        String Y = "Able to generate";
        String N = "Not able to generate";
        while(a!=c || b!=d){
            if(c<a || d<b){
                return  N;
            }
            if(c>d){
                c = c-d;
            }
            else if(d>c){
                d = d-c;
            }else{
                return N;
            }
        }
        if(a==c && b==d )        return Y;
        else return N;
    }

    public  String able1(int a, int b, int c, int d)
    {
        String Y = "Able to generate";
        String N = "Not able to generate";

        if(a>c || b>d)return N;
        if(able1(a+b,b,c,d).equals(N))
            return able1(a,a+b,c,d);
        else
            return Y;
    }

    public  String able2(int a, int b, int c, int d)
    {
        String Y = "Able to generate";
        String N = "Not able to generate";
        int dp[][] =new int[2000][2000];
        dp[a][b]=1;
        for(int i=a;i<=c;i++){


            for(int j=b;j<=d;j++) {
                   if(dp[i][j]==1){
                       dp[i+j][i]=1;
                       dp[i][i+j]=1;
                   }
            }
        }
        if(dp[c][d]==1){
            return Y;
        }

        return N;

    }

    public static void main(String args[]){
        PairGameEasy pairGameEasy = new PairGameEasy();
        System.out.println(pairGameEasy.able(1,2,3,8));
        System.out.println(pairGameEasy.able(1,2,2,1));
        System.out.println(pairGameEasy.able(2,2,2,999));

    }




}

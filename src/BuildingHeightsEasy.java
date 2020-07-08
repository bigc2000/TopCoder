import java.util.*;
public class BuildingHeightsEasy{
    public int minimum(int M, int[] heights)
    {
        if(M==0)
        {
            return 0;
        }
        int sum=0;
        Arrays.sort(heights);
        if(M==heights.length){
            for(int cost:heights){
                sum += heights[heights.length-1]-cost;
            }
            return sum;
        }
        else{
            int min=Integer.MAX_VALUE;

            for(int j=M-1;j<heights.length;j++){
                sum=0;
                for(int i=j-M;i<j+1;i++){
                    sum += heights[M-1+j]-heights[i];
                }
                if(sum<min){
                    min=sum;
                }
            }
            return sum;
        }
    }

    public static void main(String args[]){
        BuildingHeightsEasy b = new BuildingHeightsEasy()    ;
        b.minimum(3  ,new int[]
        {1, 3, 5, 2, 1});

    }

}
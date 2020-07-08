import java.util.*;

/**
 * User: Free
 * Date: 14-5-20
 * Time: 下午11:51
 */
public class MixingColors {
    public int minColors(int[] colors) {
        int len = colors.length;

        Arrays.sort(colors);
        int max = 1;
        int maxCount = 31;

        maxCount = Integer.toBinaryString(colors[colors.length - 1]).length();
        int i = 0;
        byte[][] A = new byte[colors.length][maxCount];
        for (; i < colors.length; i++) {

            String bits = Integer.toBinaryString(colors[i]);
            for (int j = 0; j < bits.length(); j++) {
                A[i][maxCount - bits.length() + j] = (byte) (bits.charAt(j) - '0');
            }
            for (int j = 0; j < maxCount - bits.length(); j++) {
                A[i][j] = 0;
            }
        }
        //gauss elimination

        // process  Row =r,Col=c,A[r][c]==0
        int r = 0;
        int c = 0;
        int pivot;
        for (r = 0; r < colors.length; r++) {

            do {
                if (c >= maxCount)
                    break;

                for (pivot = r; pivot < colors.length; pivot++) {
                    if (A[pivot][c] == 1) {
                        break;
                    }
                }
                if (pivot < colors.length) {
                    //swap ROW　pivot,r
                    if (pivot != r) {
                        for (int j = c; j < maxCount; j++) {
                            byte t = A[pivot][j];
                            A[pivot][j] = A[r][j];
                            A[r][j] = t;
                        }
                    }
                    //eliminate;
                    for (int curRow = r + 1; curRow < colors.length; curRow++) {
                        if (A[curRow][c] != 0) {
                            //XOR
                            for (int j = c; j < maxCount; j++) {
                                A[curRow][j] ^= A[r][j];
                            }
                        }
                    }
                    c++;
                    break;
                } else {
                    c++;
                }

            } while (true);


        }
        //calc rank(A)
        int rankRow = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if (A[row][col]
                        != 0) {
                    rankRow++;
                    break;
                }
            }

        }
        return rankRow;
    }

    public static void main(String args[]) {
        MixingColors mix = new MixingColors();
        System.out.println(mix.minColors(new int[]{4, 8, 16, 32, 64, 128, 256, 512, 1024}));
//        System.out.println(mix.minColors(new int[]{3, 5, 6}));
//        System.out.println(mix.minColors(new int[]{1, 3, 4, 5, 6, 8}));
//        System.out.println(mix.minColors(new int[]{534, 251, 76, 468, 909, 410, 264, 387, 102, 982, 199, 111, 659, 386, 151}));
//
//        System.out.println(mix.minColors(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912}));
    }


}

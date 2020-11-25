package intern20201120;

import java.util.Scanner;

public class BaekJoon03 {

    public static void main(String[] args) {
        // 1932번 정수 삼각형 //
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int[][] tng = new int[height][];
        int[][] dp = new int[height][height];
        for(int i=0; i<height; i++) {
            tng[i] = new int[i+1];
            for(int j=0; j<tng[i].length; j++) {
                tng[i][j] = sc.nextInt();
            }
        }
        
        dp[0][0] = tng[0][0];
        if(height>1) {
            dp[1][0] = tng[0][0] + tng[1][0];
            dp[1][1] = tng[0][0] + tng[1][1];
        }
        
        for(int i=2; i<tng.length; i++) {
            for(int j=0; j<tng[i].length; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + tng[i][j];
                }
                else if(j==tng[i].length-1) {
                    dp[i][j] = dp[i-1][tng[i-1].length-1]+tng[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1]+tng[i][j], dp[i-1][j]+tng[i][j]);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<dp[height-1].length; i++) {
            max = Math.max(max, dp[height-1][i]);
        }
        System.out.println(max);

    }

}

package intern20201120;

import java.util.Scanner;

public class BaekJoon01 {

    public static void main(String[] args) {
        // 1149번 RGB거리 //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] painting = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                painting[i][j] = sc.nextInt();
            }
        }
        
        dp[0][0] = painting[0][0];
        dp[0][1] = painting[0][1];
        dp[0][2] = painting[0][2];
        
        for(int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+painting[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+painting[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+painting[i][2];
        }
        
        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));

    }

}

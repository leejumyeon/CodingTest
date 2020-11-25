package intern20201120;

import java.util.Scanner;

public class BaekJoon04 {

    public static void main(String[] args) {
        // 2193번 이친수 //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n];
        dp[0] = 1;
        if(n>1) {
            dp[1] = 1;
        }
        for(int i=2; i<n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n-1]);

    }

}

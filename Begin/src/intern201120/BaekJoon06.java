package intern201120;

import java.util.Scanner;

public class BaekJoon06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] line = new long[n];
        long[] dp = new long[n];
        for(int i=0; i<n; i++) {
            line[i] = sc.nextLong();
        }
        dp[0] = line[0];
        long max = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]+line[i], line[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

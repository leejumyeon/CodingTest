package intern201120;

import java.util.Scanner;

public class BaekJoon05 {

    public static void main(String[] args) {
        // 2156번 포도주 시식 //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cup = new long[n];
        long[] dp = new long[n];
        
        for(int i=0; i<n; i++) {
            cup[i] = sc.nextLong();
        }
        
        dp[0] = cup[0];
       if(n>1) {
           dp[1] = cup[0] + cup[1];
       }
       if(n>2) {
           dp[2] = Math.max(dp[1],Math.max(cup[0]+cup[2], cup[1]+cup[2]));
       }
       
       for(int i=3; i<n; i++) {
           dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+cup[i], dp[i-3]+cup[i-1]+cup[i]));
       }
       System.out.println(dp[n-1]);
    }
}

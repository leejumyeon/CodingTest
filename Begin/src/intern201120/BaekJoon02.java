package intern201120;

import java.util.Scanner;

public class BaekJoon02 {
    public static void main(String[] args) {
        // 2579번 계단 오르기 //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n];
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++) {
            stairs[i] = sc.nextInt();
        }
        sc.close();
        // dp에는 해당 자리가 마지막이였을 경우의 최대값이 저장된다.
        dp[0] = stairs[0];
        if(n>1)dp[1] = stairs[0]+stairs[1];
        if(n>2) dp[2] = Math.max(stairs[0]+stairs[2], stairs[1]+stairs[2]);
        
        for(int i=3; i<n; i++) {// 마지막<-마지막-1<-마지막-3 순서인 경우 / 마지막<-마지막-2 순서인 경우
            dp[i] = Math.max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i]);
        }
        System.out.println(dp[n-1]);
        
    }
}

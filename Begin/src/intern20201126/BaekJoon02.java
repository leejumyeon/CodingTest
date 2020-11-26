package intern20201126;

import java.util.Scanner;

public class BaekJoon02 {

	public static void main(String[] args) {
		// 10844번 쉬운 계단 수 //
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10]; //[자리수][가장 뒷자리 수]
		
		// 초기 값 설정 = 1자리수 계단수 개수
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		// [i]자리수에서 [j]로 끝나는 계단수는 [i-1]번째에서 [j-1]로 끝난 수와 [j+1]로 끝난 수여야만 만들 수 있다.
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				else if(j == 9) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
				}
				dp[i][j] %= 1000000000;
			}
		}
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum%1000000000);
	}
}

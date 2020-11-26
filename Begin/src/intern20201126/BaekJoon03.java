package intern20201126;

import java.util.Scanner;

public class BaekJoon03 {

	public static void main(String[] args) {
		// 9461번 파도반 수열 //
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] caseArr = new int[n];
		long[] dp = new long[101];
		// dp 초기화
		for (int i = 1; i <= 3; i++) {
			dp[i] = 1;
		}
		for (int i = 4; i <= 5; i++) {
			dp[i] = 2;
		}
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for (int i = 0; i < caseArr.length; i++) {
			caseArr[i] = sc.nextInt();
		}
		for (int num : caseArr) {
			System.out.println(dp[num]);
		}
	}

}

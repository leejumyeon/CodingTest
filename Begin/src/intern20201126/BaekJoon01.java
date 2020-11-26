package intern20201126;

import java.util.Scanner;

public class BaekJoon01 {

	public static void main(String[] args) {
		// 11053번 가장 긴 증가하는 부분 수열 //
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] <= dp[j]) { //현재 값이 과거 값보다 크고 현재dp값이 과거dp값보다 작거나 같을 경우 실행
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for(int dpNum : dp) {
			result = Math.max(result, dpNum);
		}
		System.out.println(result);
	}

}

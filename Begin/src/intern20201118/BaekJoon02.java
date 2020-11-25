package intern20201118;

import java.util.Scanner;

public class BaekJoon02 {

	public static void main(String[] args) {
		// 1003번 피보나치 함수 //
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp값 설정 //
		int[] dp = new int[41]; //입력제한이 40까지 이므로 최대치 41
		/*
		 * 0 = 1 0
		 * 1 = 0 1
		 * 2 = 1 1
		 * 3 = 1 2
		 * 4 = 2 3
		 * 5 = 3 5
		 * => 2부터 0의 자리값은 n-1의 1의 자리값이고 1의 자리값은 n-1의 1의 자리값 + n-2의 1의 자리값이다.
		 */
		dp[1] = 1;
		
		for (int i = 2; i <= 40; i++) { // 1과 0일 때가 주어졌으니까 2부더 max까지의 개수를 구하도록 반복
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(num == 0) System.out.println("1 0");
			else System.out.println(dp[num-1]+" "+dp[num]);
		}
		sc.close();
	}
}

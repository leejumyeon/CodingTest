package intern20201118;

import java.util.Scanner;

public class BaekJoon01 {

	public static void main(String[] args) {
		// 9095번 문제 : 1, 2, 3 더하기 //
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 입력 과정 //
		int[] numArr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			numArr[i] = num;
			max = (i == 0) ? num : ((max < num) ? num : max); // 입력하는 값 중에서 가장 큰 값을 max에 저장
		}

		int[] dp = new int[max + 1]; // 각각의 수(index)가 만들어지는 경우의 수 배열을 max번째 방까지 생성
		dp[1] = 1; // 1이 만들어지는 경우의 수
		dp[2] = 2; // 2가 만들어지는 경우의 수
		dp[3] = 4; // 3이 만들어지는 경우의 수
		for (int j = 4; j <= max; j++) {
			// 이미 만들어져 있는 1,2,3의 경우의 수로 4부터 max가 만들어지는 경우의 수 생성
			dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
		}

		for (int i = 0; i < n; i++) {
			System.out.println(dp[numArr[i]]);
		}
	}
}

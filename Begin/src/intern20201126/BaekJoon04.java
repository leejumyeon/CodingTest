package intern20201126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon04 {

	public static void main(String[] args) throws IOException {
		// 14501번 퇴사 //
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n+2];
		int[] P = new int[n+2];
		int[] dp = new int[n+2];
		for(int i=1; i<=n; i++) {
			String line = br.readLine();
			T[i] = Integer.parseInt(line.split(" ")[0]);
			P[i] = Integer.parseInt(line.split(" ")[1]);
		}
		
		for(int i=n; i>=1; i--) {
			int date = T[i] + i; //상담날짜
			if(date <= n+1) { //퇴사기간 안에 상담이 끝날 경우
				dp[i] = Math.max(P[i]+dp[date], dp[i+1]); 
			}
			else { //상담일 초과
				dp[i] = dp[i+1]; //이전에 받았던 값 그대로 대입
			}
		}
		System.out.println(dp[1]);
	}
}

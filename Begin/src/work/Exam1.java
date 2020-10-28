package work;

public class Exam1 {

	public static void main(String[] args) {
		// 1부터 100까지의 합을 구하시오
		int start = 1;
		int end = 100;
		int sum = start+end;
		int result = 0;
		if(end%2==0) { //1부터 임의의 수까지의 개수가 짝수인 경우
			result = sum*(end/2); 
		}
		else { //1부터 임의의 수까지의 개수가 홀수인 경우
			result = sum*(end/2)+(end/2 +1);
		}
		System.out.println(result);
		
		// 1부터 100까지의 합을 for문을 사용하여 풀이
		result = 0;
		for(int i=0; i<end; i++) {
			result += (i+1);
		}
		System.out.println(result);

	}

}

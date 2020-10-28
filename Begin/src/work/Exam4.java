package work;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		//  factorial()을 구현해라
		Exam4 test = new Exam4();
		Scanner sc = new Scanner(System.in);
		System.out.print("팩토리얼을 구할 수를 입력하세요:");
		int num = sc.nextInt();
		int result = test.factorial(num);
		System.out.println("result:"+result);
	}
	
	public int factorial( int n ) {
		
		if(n<=1) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}

}

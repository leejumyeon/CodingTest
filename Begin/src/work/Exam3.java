package work;

public class Exam3 {

	public static void main(String[] args) {
		// 구구단을 출력
		for(int i=1; i<=9; i++) { //세로축 반복
			for(int j=2; j<=9; j++) { //가로축 반복
				System.out.print(i*j+"\t");
			}
			System.out.println();
		}

	}

}

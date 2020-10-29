package intern17;

import java.util.Scanner;

public class BaekJoon04 {

    public static void main(String[] args) {
        // 3052번 나머지 //
        Scanner sc = new Scanner(System.in);
        int x = 10; // 입력받는 수의 개수
        int[] remainderArr = new int[42]; // 42로 나눈 나머지니까 0~41을 갖는 배열을 선언
        int result = 0; // 결과값 변수

        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            // 입력받은 값을 42로 나누어 나온 수 = remainder의 index로 해당 자리의 count증가
            remainderArr[num % 42]++;
        }

        for (int remainder : remainderArr) {
            if (remainder != 0)
                result++;
        }
        System.out.println(result);
    }
}

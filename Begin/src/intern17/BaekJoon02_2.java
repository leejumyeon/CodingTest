package intern17;

import java.util.Scanner;

public class BaekJoon02_2 {

    private static int[] numbers = new int[1001]; // 1~1000까지의 자연수를 담은 배열

    public static void main(String[] args) {
        // 1978번 소수찾기 -에라토스테네스의 채- //
        Scanner sc = new Scanner(System.in);

        // 소수 판별 = 에라토스테네스의 채 //
        for (int i = 2; i < numbers.length; i++) {
            int cnt = 2;
            if(numbers[i]==1) continue;
            while ((i * cnt) < numbers.length) {
                numbers[i*cnt] = 1; //소수가 아닌 수의 index에 있는 값은 1
                cnt++;
            }
            // 0과 1은 소수가 아니므로 값을 1로 대입
            numbers[0] = 1;
            numbers[1] = 1;
        }

        // 입력한 수가 소수인지 아닌지 카운트
        int x = sc.nextInt();
        int count = 0;
        for (int i = 0; i < x; i++) {
            int num = sc.nextInt();
            if (numbers[num] != 1)
                count++;
        }

        System.out.println(count);
    }

}

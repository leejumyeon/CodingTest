package intern12;

import java.util.Scanner;

public class BaekJoon04 {
    public static void main(String[] args) {
        // 2839 설탕배달 //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        // 5로 나눠서 떨어졌을 경우
        if (num % 5 == 0) {
            System.out.println(num / 5);
            return;
        } else { // 5로 나눠서 떨어지지 않았을 경우 => 3이랑 같이 활용해본다.
            int quoter = num / 5;
            for (int i = quoter; i > 0; i--) {
                int temp = num - (i * 5); // 5의 배수씩 입력값에서 빼서 3으로 나눠본다.
                if (temp % 3 == 0) {
                    System.out.println(i + (temp / 3));
                    return;
                }
            }

        }

        if (num % 3 == 0) {
            System.out.println(num / 3);
            return;
        } else {
            System.out.println(-1);
        }
        
    }
}

package intern13;

import java.util.Scanner;

public class BackJoon04 {

    public static void main(String[] args) {
        // 11720번 숫자의 합 //
        Scanner sc = new Scanner(System.in);
        int inputCount = Integer.parseInt(sc.nextLine());
        String[] num = sc.nextLine().split("");
        int sum = 0;
        sc.close();
        if(inputCount<num.length) {
            System.out.println("숫자의 수가 입력가능한 수를 넘었습니다.");
            return ;
        }
            
        for(int i=0; i<num.length; i++) {
            sum += Integer.parseInt(num[i]);
        }
        System.out.println(sum);

    }

}

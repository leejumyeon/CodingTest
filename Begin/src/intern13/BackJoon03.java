package intern13;

import java.util.Scanner;

public class BackJoon03 {

    public static void main(String[] args) {
        // 2753번 윤년 //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int result = 0;
        if(num%400==0 || (num%4==0 && num%100!=0))
            result = 1;
        System.out.println(result);

    }

}

package intern12;

import java.util.Scanner;

public class BaekJoon05 {

    public static void main(String[] args) {
        // 1463번 1로 만들기 //
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        sc.close();
        long count = 0;
        long min = 0;
        long temp = num;
        while (temp > 1) {
            if (temp % 3 == 0) {
                count++;
                temp = temp / 3;
            } else {
                count++;
                temp -= 1;
            }
            if (temp % 2 == 0) {
                count++;
                temp = temp / 2;
            }

        }
        min = count;
        temp = num;
        count = 0;
        while (temp > 1) {
            if (temp % 2 == 0) {
                count++;
                temp = temp / 2;
            } else {
                count++;
                temp -= 1;
            }
            if (temp % 3 == 0) {
                count++;
                temp = temp / 3;
            }

        }

        if (min > count)
            min = count;

        System.out.println(min);

    }

}

package intern17;

import java.util.Scanner;

public class BaekJoon05 {

    public static void main(String[] args) {
        // 2292번 벌집 //
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int num = 1;
        int cercle = 1;
        while (num < x) {
            num += 6 * cercle; // 벌집이 1번방 기준으로 주위로 멀어질 때 규칙
            cercle++;
        }
        System.out.println(cercle);
    }
}

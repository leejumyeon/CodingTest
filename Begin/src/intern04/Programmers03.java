package intern04;

import java.util.Scanner;

public class Programmers03 {

    public static void main(String[] args) {
        // 입력되는 두 개의 정수n과 m이 주어진다.
        // 별(*)문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해라
        // 조건1. n과 m은 각각 1000 이하인 자연수다.
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}

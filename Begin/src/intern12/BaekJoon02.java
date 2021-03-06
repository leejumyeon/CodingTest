package intern12;

import java.util.Scanner;

public class BaekJoon02 {

    private static int d[] = new int[1001];
    public static void main(String[] args) {
        // 타일링 문제2 //
        // 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
        // 조건1. 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
        // 조건2. 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(tiling(num));

    }
    private static int tiling(int x) {
        if(x == 1) return 1;
        if(x == 2) return 3;
        if(d[x]!=0) return d[x];
        return d[x] = (tiling(x-1) + 2 * tiling(x-2))%10007;
    }

}

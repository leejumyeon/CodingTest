package intern17;

import java.util.Scanner;

public class BaekJoon02_1 {

    public static void main(String[] args) {
        // 1978번 소수찾기 -소수판정 사용- //
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0; //소수를 세는 변수
        for(int i=0; i<x; i++) {
            int num = sc.nextInt();
            if(primalCheck(num)) count++;
        }
        System.out.println(count);
    }

    
    private static boolean primalCheck(int num) {
        // 자기자신을 2부터 자기자신까지의 수로 나눴을 때 나누어 떨어지는 수가 있는지 판별
        if(num==1) return false;
        for(int start = 2; start<num; start++) {
            if(num%start==0)
                return false;
        }
        return true;
    }
}

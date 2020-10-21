package intern12;

import java.util.Scanner;

public class BaekJoon03 {

    private static int[] a = new int[41];
    private static int zeroCount = 0;
    private static int oneCount = 0;
    public static void main(String[] args) {
        // 피보나치를 구할 때 0과 1이 몇번 return하는지 공백으로 구분해서 출력
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fibonacci(num);
        System.out.println(zeroCount+" "+oneCount);
    }
    
    private static int fibonacci(int x) {
        if(x == 0) {
            zeroCount++;
            return 0;
        }
        if(x == 1) {
            oneCount++;
            return 1;
        }
        if(a[x]!=0) {
            oneCount++;
            zeroCount++;
            return a[x];
        }
        return a[x] = fibonacci(x-1)+fibonacci(x-2);
    }

}

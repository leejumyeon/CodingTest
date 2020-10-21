package intern12;

import java.util.Scanner;

public class DynamicMain {

    public static int[] d = new int[100];
    
    public static void main(String[] args) {
        // 다이나믹 프로그래밍으로 피보나치 구하기
        Scanner sc = new Scanner(System.in);
        
        System.out.print("구하고 싶은 피보나치 수열의 자리를 입력하세요:");
        int n = sc.nextInt();
        sc.close();
        System.out.println("결과값:"+fibonacci(n));

    }
    
    private static int fibonacci(int x) {
        if(x==1) return 1;
        if(x==2) return 1;
        if(d[x]!=0) return d[x]; //기존에 처리한 값이 있다면 해당 값을 바로 사용
        return d[x] = fibonacci(x-1) + fibonacci(x-2); //처리한 값을 해당 index위치에 대입하여 필요할 때 사용할 수 있도록 한다.
    }

}

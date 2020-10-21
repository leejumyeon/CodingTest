package intern12;

import java.util.Scanner;

public class PrimeNumberMain {
    
    public static void main(String[] args) {
        // 에라토스테네스의 채 구현 //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        primeNumberService(num);
        
    }
    
    private static void primeNumberService(int num) {
        int[] numbers = new int[num+1];
        
        // 범위까지의 값 초기화
        for(int i=2; i<=num; i++) {
            numbers[i] = i;
        }
        
        // 자기자신을 제외한 특정 수의 배수 위치에 있는 값은 모두 0으로 처리
        for(int i=2; i<=num; i++) {
            if(numbers[i] == 0) continue;
            for(int j=i+i; j<=num; j+=i) {
                numbers[j] = 0;
            }
        }
        
        for(int i=2; i<=num; i++) {
            if(numbers[i]!=0) System.out.print(numbers[i]+"\t");
        }
    }
}

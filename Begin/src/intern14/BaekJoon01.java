package intern14;

import java.util.Scanner;

public class BaekJoon01 {

    public static void main(String[] args) {
        // 2577번 숫자의 개수 //
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        
        int result = a * b* c;
        int[] count = new int[10];
        do {
            int num = result%10;
            count[num]++;
            result/=10;
        }while(result!=0);
        
        for(int n:count)
            System.out.println(n);

    }

}

package intern14;

import java.util.Scanner;

public class BaekJoon02 {

    public static void main(String[] args) {
        // 2588번 곱셈 //
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] position = new int[3];
        int result = 0;
        for(int i=0; i<position.length; i++) {
            int num = b%10;
            b/=10;
            position[i] = num*a;
            result += position[i]*(Math.pow(10, i));
            System.out.println(position[i]);
        }
        System.out.println(result);
    }

}

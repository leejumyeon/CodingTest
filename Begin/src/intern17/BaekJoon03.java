package intern17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon03 {

    public static void main(String[] args) throws IOException {
        // 10872번 팩토리얼 //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(factorial(num));
    }

    private static int factorial(int num) {
        if(num <= 1) return 1;
        return num * factorial(num-1);
    }

}

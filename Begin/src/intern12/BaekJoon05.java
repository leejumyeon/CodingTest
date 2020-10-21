package intern12;

import java.util.Scanner;

public class BaekJoon05 {

    static int[] d;
    public static void main(String[] args) {
        // 1463번 1로 만들기 //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        d = new int[num+1];
        System.out.println(dp(num));
        sc.close();
    }
    
    private static int dp(int x) {
        
        if(x==1)
            return 0;
        if(d[x] > 0)
            return d[x];
        d[x] = dp(x-1)+1; //d[x]는 x-1의 최소횟수 +1
        
        // x가 나눠지는지 확인 후 나눠지면 (나눈 몫의 최소 횟수 +1)과 (x-1의 최소횟수 +1) 비교 후 작은 값 대입
        if(x%2==0) {
            int tmp = dp(x/2)+1;
            if(d[x] > tmp)
                d[x] = tmp;
        }
            
        if(x%3==0) {
            int tmp = dp(x/3)+1;
            if(d[x] > tmp)
                d[x] = tmp;
        }
        return d[x];
    }

}

package intern04;

public class Programmers10 {

    public static void main(String[] args) {
        // 입력한 두 정수 n, m의 최대공약수와 최소공배수를 구해라
        int n=0;
        int m=0;
        int[] answer = new int[2];
        int big, small;
        
        if(n>m) {
            big = n;
            small = m;
        }
        else {
            big = m;
            small = n;
        }
        
        answer[0] = gcd(big, small);
        answer[1] = big*small/answer[0];
        
    }
    
    // 유클리드 호제법
    /*
         a와b의 최대공약수를 구하는 알고리즘으로 
         a%b(단 a>b 조건)가 0이면 b가 최대공약수이고 
         a%b가 0이 아니면 b값을 a%b의 결과값으로 다시 나누는 과정을 0이 될때까지 반복하는 
         내용이다.
    */
    public static int gcd(int a, int b) {
        if(a%b == 0) return b;
        return gcd(b,a%b);
    }

}

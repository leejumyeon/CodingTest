package intern06;

public class Programmers01 {
    
    public static void main(String[] args) {
        // 임의의 양의 정수 n이 주어졌을 때 n이 어떤 양의 정수 x의 제곱인지 판단하는 문제
        // n이 양의 정수 x의 제곱이라면 x+1의 제곱을 return
        // n이 양의 정수 x의 제곱이 아니라면 -1을 return
        // 조건1. n은 1이상 50000000000000 이하인 양의 정수
        long n = 3;
        long answer = 0;
        double doubleSqrt = Math.sqrt(n); //소수부까지 출력
        int intSqrt = (int)doubleSqrt;
        if(intSqrt == doubleSqrt) //제곱근값이 정말로 정수인 경우 
            answer = (long) Math.pow(intSqrt+1, 2);
        else 
            answer = -1;
        System.out.println("결과값:"+answer);
    }
}

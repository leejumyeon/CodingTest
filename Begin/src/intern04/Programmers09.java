package intern04;

public class Programmers09 {

    public static void main(String[] args) {
        // 콜라츠 추측 //
        // 주어진 수가 1이 될때까지 다음 작업을 반복하면 모든 수를 1로 만들 수 있다는 추측
        //  조건1. 입력된 수가 짝수라면 2로 나눈다.
        //  조건2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
        //  결과로 나온 수에 같은 작업을 1이 될 때까지 반복한다.
        // 입력된 수 num이 몇번을 반복해야 1이 되는지 구하라
        // 단 반복하는 수가 500이 넘어도 1이 되지 않는다면 -1을 반환하라
        // 조건1. 입력된 수 num은 1이상 8000000 미만인 정수이다.
        
        int num = 626331;
        int answer = 0;
        while(num!=1&&answer<500) {
            if(num%2==0) {
                num/=2;
            }
            else {
                num = num*3 + 1;
            }
            answer++;
            
            if(num<0) answer=500;
        }
        
        if(answer>=500&&num!=1) answer = -1;
        
        System.out.println("결과값:"+answer);
    }

}

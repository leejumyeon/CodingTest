package intern04;

public class Programmers12 {

    public static void main(String[] args) {
        // 정수 num이 짝수일 경우 "Even"을 출력하고 홀수인 경우 "Odd"를 출력해라
        // 조건1. num은 int범위의 정수이다.
        // 조건2. 0은 짝수이다.
        
        int num = 0;
        String answer="";
        
        if(num%2==0) answer="Even";
        else answer="Odd";
        
        System.out.println("결과값:"+answer);

    }

}

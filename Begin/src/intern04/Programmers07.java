package intern04;

public class Programmers07 {

    public static void main(String[] args) {
        // 하샤드 수 구하기
        // 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 한다.
        // x를 입력받아 x가 하샤드 수인지 아닌지 검사하여 결과를 출력해라
        // 조건1. x는 1이상 10000이하인 정수이다.
        
        int x = 11;
        int temp = x;
        boolean answer = true;
        int sum = 0;
        do {
            int digit = temp%10; //1의 자리부터 자릿수 추출
            sum += digit;
            temp = temp/10;
        }while(temp!=0);

        answer = (x%sum==0);
        
        System.out.println(answer);
    }

}

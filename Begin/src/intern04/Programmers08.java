package intern04;

public class Programmers08 {

    public static void main(String[] args) {
        // 정수를 담고 있는 배열 arr의 평균값을 구하라
        // 조건1. arr은 길이 1이상, 100이하인 배열이다.
        // 조건2. arr의 원소는 -10,000이상 10,000이하인 정수이다.
        
        int[] arr= {1,2,3,4};
        double answer = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
           sum += arr[i]; 
        }
        answer = (double)sum / arr.length;
        System.out.println("결과값:"+answer);

    }

}

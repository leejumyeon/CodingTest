package intern06;

public class Programmers02 {

    public static void main(String[] args) {
        // 정수 n을 매개변수로 입력받았을 때 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 구하라
        // 조건1. n은 1이상 8000000000 이하인 자연수
        
        long n = 7909989395L;
        long answer = 0;
        
        String strN = String.valueOf(n);
        String[] strArr = strN.split("");
        
        int index = 0;
        String temp = "";
        for(int i=0; i<strArr.length-1; i++) {
            long max = 0;
            
            for(int j=i; j<strArr.length; j++) {
                if(max<Long.parseLong(strArr[j])) {
                    max = Long.parseLong(strArr[j]);
                    index = j;
                }
            }
            temp = String.valueOf(strArr[index]);
            strArr[index] = strArr[i];
            strArr[i] = temp;
            
        }
        
        strN = String.join("", strArr);
        answer = Long.parseLong(strN);
        System.out.println("결과값:"+answer);

    }

}

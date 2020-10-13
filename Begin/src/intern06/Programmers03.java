package intern06;

public class Programmers03 {
    
    public static void main(String[] args) {
        // 자연수 n이 매개변수로 주어질 때 n을 3진법상에서 앞뒤로 ㄷ뒤집은 후, 이를 다시 10진법으로 표현해라
        int n = 45;
        int answer = 0;
        StringBuffer sbf = new StringBuffer();
        do {
            int temp = n;
            sbf.append(String.valueOf(temp%3));
            n = temp/3;
        }while(n>0);
        String[] strAnswer = sbf.toString().split("");
        for(int i=strAnswer.length-1; i>=0; i--) {
            int num = Integer.parseInt(strAnswer[i]);
            answer += num * Math.pow(3, (strAnswer.length-1)-i);
        }
        
        
        System.out.println("결과값:"+answer);
    }
}

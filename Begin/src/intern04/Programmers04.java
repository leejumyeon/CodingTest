package intern04;

public class Programmers04 {

    public static void main(String[] args) {
        // 정수 x와 자연수 n을 입력받아 x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴하라
        // 조건1. x는 -10000000 이상, 10000000 이하
        // 조건2. n은 1000이하 자연수
        
        int x=-10000000;
        int n=1000;
        
        long[] answer = new long[n];
        for(int i=0; i<answer.length; i++) {
            answer[i] = (long)x*(i+1); //위 조건의 최대값으로 설정했을 경우 int x의 x*(i+1)값은 int의 범위를 벗어난다. 따라서 x를 long타입으로 casting해야 한다.
        }
        
        for(long num: answer) {
            System.out.print(num+"\t");
        }

    }

}

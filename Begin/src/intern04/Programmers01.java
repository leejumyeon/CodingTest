package intern04;

public class Programmers01 {

    public static void main(String[] args) {
        // 전체 스테이지의 수 N과 플레이어들의 현재 진행한 스테이지번호가 담긴 배열 stages가 주어질때 실패율이 높은 스테이지부터 내림차순으로 정렬
        // 실패율 정의 = 스테이지에 도달했으나 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
        // 조건1. N은 1이상 500이하의 자연수.
        // 조건2. stages의 길이는 1이상 200,000이하
        // 조건3. stages안에는 1이상 N+1이하의 자연수가 담긴다.(N+1 = N의 스테이지를 클리어했다는 의미)
        // 조건4. 실패율이 같은 스테이지가 있다면 스테이지 번호가 작은 것이 먼저 오도록 한다.
        
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] answer = new int[N]; //실제 스테이지 배치
        double[] rates = new double[N]; // 스테이지의 실패율값 배치
        
        for(int i=N; i>0; i--) {
            double clear = 0; //클리어 카운트
            double fail = 0; //실패 카운트
            for(int j=0; j<stages.length; j++) {
                if(stages[j] >= i) clear++; //도달 + 통과한 플레이어의 수
                if(stages[j] == i) fail++; // 도달만한 플레이어의 수
            }
            double failRate = 0;
            if(clear == 0) failRate = 0;
            else failRate = fail / clear;
            rates[i-1] = failRate;
            answer[i-1] = i;
        }
        
        for(int i=0; i<rates.length-1; i++) {
            double temp = 0;
            for(int j=i+1; j<rates.length; j++) {
                if(rates[i]<rates[j]) {
                    temp = rates[i];
                    rates[i] = rates[j];
                    rates[j] = temp;
                    
                    temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = (int)temp;
                }
                
                else if(rates[i] == rates[j]) {
                    if(answer[i]>answer[j]) {
                        temp = answer[j];
                        answer[j] = answer[i];
                        answer[i] = (int)temp;
                    }
                }
            }
        }
        System.out.print("결과값:");
        for(int stage:answer) {
            System.out.print(stage+"\t");
        }
    }

}

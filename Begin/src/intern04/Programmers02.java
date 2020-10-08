package intern04;

public class Programmers02 {

    int[] sorted = null;
    
    public static void main(String[] args) {
        // 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 주어질 때 최대 몇 개의 부서에 물품을 지원할 수 있는지 구해라
        // 예산을 부서에 주어질 때에는 반드시 신청한 금액만큼 들어가야 한다.
        // 조건1. d는 부서별 신청한 금액의 배열로 길이는 1이상 100이하
        // 조건2. d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1이상 100,000이하의 자연수
        // 조건3. budget은 예산을 나타내며, 1이상 10,000,000이하의 자연수

        Programmers02 mainClass = new Programmers02();
        int[] d = {2,2,3,3};
        int budget = 9;
        mainClass.sorted = new int[d.length];
        mainClass.mergeSort(d, 0, d.length-1);
        
        int sum = 0;
        int answer = 0;
        
        do {
            sum += d[answer];
            answer++;
        }while(sum<budget&&answer<d.length);
        if(sum>budget) {
            answer-=1;
        }
        
        System.out.println("결과값:"+answer);
        
    }
    
    void mergeSort(int[]a, int start, int end) {
        if(start<end) {
            int middle = (start+end)/2;
            mergeSort(a, start, middle);
            mergeSort(a, middle+1, end);
            merge(a, start, middle, end);
        }
    }
    
    void merge(int[]a, int start, int middle, int end) {
        int i = start;
        int j = middle+1;
        int k = start;
        
        while(i<=middle&&j<=end) {
            if(a[i]<a[j]) {
                sorted[k] = a[i];
                i++;
            }
            else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        
        if(i>middle) {
            for(int t=j; t<=end; t++) {
                sorted[k] = a[t];
                k++;
            }
        }
        else {
            for(int t=i; t<=middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }
        
        for(int t=start; t<=end; t++) {
            a[t] = sorted[t];
        }
    }

}

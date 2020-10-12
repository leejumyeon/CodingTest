package intern05;

public class Programmers01 {

    public static void main(String[] args) {
        // 정수를 저장한 배열 arr에서 가장 작은 수를 제거한 배열을 리턴해라
        int[] arr = {10,10,10,10};
        int[] answer = null;
        int min = 9999;
        int count = 0;
        
        // 최소값 구하기
        for(int i=0; i<arr.length; i++) {
            if(min>arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
        for(int i=0; i<arr.length; i++) {
            if(min==arr[i]) {
                count++;
                System.arraycopy(arr, 0, arr, 0, i);
                if(i<arr.length-1)
                    System.arraycopy(arr, i+1, arr, i, arr.length-(i+1));
            }
        }
        
        if(count==arr.length) answer = new int[] {-1};
        else {
            answer = new int[arr.length-count];
            System.arraycopy(arr, 0, answer, 0, arr.length-count);
        }
        
        for(int num:answer) {
            System.out.print(num+"\t");
        }
    }
}

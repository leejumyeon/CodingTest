package intern04;

import java.util.Scanner;

public class MergeSortMain {

    int[] sorted = null;
    
    void merge(int[]a, int start, int middle, int end) {
        int i = start; //병합할 첫번째 배열의 시작 index
        int j = middle+1; //병합할 두번째 배열의 시작 index
        int k = start; //임의의 배열에 저장할 위치값
        while(i<=middle && j<=end) {
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
        
        // 두 정렬 중에서 먼저 sorted에 삽입이 끝난 정렬이 있으면 나머지 부분을 다른 정렬로 채우기
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
        
        //sorted(병합+정렬을 한 새로운 배열)에 있는 값을 기존 배열에 다시 삽입
        for(int t=start; t<=end; t++) {
            a[t] = sorted[t];
        }
        
    }
    
    // 
    void mergeSort(int[] a, int start, int end) {
       if(start<end) {
           int middle = (start+end)/2; //반으로 나눈 중간지점 index
           mergeSort(a, start, middle); //시작부분과 반으로 나눈index부분을 끝으로 재귀함수 호출 => 최종적으로 시작지점부터 middle지점까지 분할
           mergeSort(a, middle+1, end); //반으로 나눈 지점의 다음칸을 시작으로 끝부분까지를 파라미터로 재귀함수 호출 => 최종적으로 middle+1지점부터 끝지점까지 분할
           merge(a, start, middle, end);// 분할을 전부 끝내고 다시 순차적으로 병합을 시작(mergeSort의 호출이 끝나면 역순으로 실행된다.)
       }
       
    }
    
    public static void main(String[] args) {
        // 병합정렬
        MergeSortMain mainClass = new MergeSortMain();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 수의 개수를 정하세요:");
        
        int number = Integer.parseInt(sc.nextLine());
        mainClass.sorted = new int[number]; //임시공간
        int[] array = new int[number]; //실제 배열
        System.out.println("정렬할 수를 입력하세요");
        for(int i=0; i<number; i++) {
            int n = Integer.parseInt(sc.nextLine());
            array[i] = n;
        }
        
        System.out.println();
        mainClass.mergeSort(array, 0, number-1);
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        

    }

}

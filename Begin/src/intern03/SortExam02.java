package intern03;

import java.util.Scanner;

public class SortExam02 {

    public static void main(String[] args) {
        // 첫째 출에 사람의 수 N(1이상 1000이하)가 주어진다.
        // 두번째 줄에 각 사람이 돈을 인출하는데 걸리는 시간 P(1이상 1000이하)분이 주어진다.
        // 각사람이 돈을 인출하는데 필요한 시간의 합이 가장 최솟값인 경우를 구해라
        
        Scanner sc = new Scanner(System.in);
        int[] array = new int[1001];
        int result = 0;
        
        System.out.print("인원수:");
        int number = Integer.parseInt(sc.nextLine());
        for(int i=0; i<number; i++) {
            array[i] = Integer.parseInt(sc.next());
        }
        
        array = quickSort(array,0, number-1);
        
        
        for(int i=0; i<number; i++) {
            int sum = 0;
            for(int j=0; j<=i; j++) {
                sum+= array[j]; //1사람이 돈을 뽑는데 걸리는 시간
            }
            result += sum; //모든 사람이 돈을 뽑는데 걸리는 시간
        }
        
        System.out.println("결과:"+result);
    }

    private static int[] quickSort(int[] array, int start, int end) {
        if(start>=end) { //재귀 종료 시점
            return array;
        }
        
        int key = start; // 피벗값
        int i = start + 1; // 왼쪽에서 오른쪽으로 검사하는 시작지점
        int j = end; // 오른쪽에서 왼쪽으로 검사하는 시작지점
        int temp;
        
        while (i <= j) { // 왼쪽검사와 오른쪽검사가 엇갈릴 때까지 반복
            while (i <= end && array[i] <= array[key]) { // 배열의 범위에서 벗어나기 전까지 + key값보다 큰 수를 발견할 때까지
                i++; // 다음 칸으로 이동(좌->우)

            }

            while (j > start && array[j] >= array[key]) { // 오른쪽에서 왼쪽으로 검사하는 과정이 기준을 넘지 않을때까지 + key값보다 작은 수를 발견할 때까지
                j--;// 이전 칸으로 이동(우->좌)
            }

            if (i > j) { // 현재 엇갈린 상태면 키값과 교체
                temp = array[j];
                array[j] = array[key];
                array[key] = temp;
            } else {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        array = quickSort(array, start, j - 1); //피벗값 이동 후 앞부분 집합(피벗보다 작은 값)
        array = quickSort(array, j + 1, end); // 피벗값 이동 후 뒷부분 집합(피벗보다 큰 값)
        
        return array;
    }

}

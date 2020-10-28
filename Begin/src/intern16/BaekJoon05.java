package intern16;

import java.util.Scanner;

public class BaekJoon05 {

    public static void main(String[] args) {
        // 10818번 최소, 최대 //
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] numArr = new int[x];
        for (int i = 0; i < x; i++) {
            numArr[i] = sc.nextInt();
        }

        // 힙 정렬 알고리즘 //
        for (int i = 0; i < x; i++) { // 최초 힙 생성
            int c = i; // 현재 노드 index
            do {
                int root = (c - 1) / 2; // 현재 노드의 부모노드 index
                if (numArr[root] < numArr[c]) {
                    int temp = numArr[root];
                    numArr[root] = numArr[c];
                    numArr[c] = temp;
                }
                c = root;
            } while (c != 0);
        }

        // heap정렬 = 크기를 줄여가며 반복적으로 heap생성
        for (int i = x - 1; i >= 0; i--) {
            // 위 heap생성 과정을 걸쳤으므로 heap[0]은 가장큰값이 된다.
            // 가장 큰 값을 가장 뒤로 보내고 그 이외의 배열들을 다시 정렬시키는 과정
            int temp = numArr[0];
            numArr[0] = numArr[i];
            numArr[i] = temp;

            int root = 0;
            int c = 1;
            do {
                c = root * 2 + 1; // 자식노드 구하기
                if (c < (i - 1) && numArr[c] < numArr[c + 1]) { // 이미 정해진 뒷자리를 제외한 나머지 부분에서 자식노드 2개 중 큰 값의 자식노드 선택
                    c++;
                }
                if (c < i && numArr[root] < numArr[c]) {
                    temp = numArr[c];
                    numArr[c] = numArr[root];
                    numArr[root] = temp;
                }
                root = c;
            } while (c < i);
        }
        System.out.println(numArr[0] + " " + numArr[x - 1]);
    }
}

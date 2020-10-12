package intern05;

public class HeapSortMain {

    public static void main(String[] args) {
        // 힙 정렬 = 먼저 최대힙 or 최소힙 구조로 data를 만들어야 heap정렬을 사용할 수 있다.
        int[] heap = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
        int number = heap.length;

        // heap생성 과정
        for (int i = 0; i < number; i++) {
            int c = i; // 현재 노드
            do {
                int root = (c - 1) / 2; // 현재노드의 부모노드 index
                if (heap[root] < heap[c]) {
                    int temp = heap[c];
                    heap[c] = heap[root];
                    heap[root] = temp;
                }
                c = root;
            } while (c != 0);
        }

        // heap정렬 = 크기를 줄여가며 반복적으로 heap생성
        for (int i = number - 1; i >= 0; i--) {
            // 위 heap생성 과정을 걸쳤으므로 heap[0]은 가장큰값이 된다.
            // 가장 큰 값을 가장 뒤로 보내고 그 이외의 배열들을 다시 정렬시키는 과정
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int c = 1;
            int root = 0; // 부모노드
            do { // 힙 생성과정??
                c = 2 * root + 1; // 자식노드 index
                if (c < (i - 1) && heap[c] < heap[c + 1]) { // 이미 정해진 뒷자리를 제외한 나머지 부분에서 자식노드 2개 중 큰 값의 자식노드 선택
                    c++;
                }
                if (c < i && heap[root] < heap[c]) {
                    temp = heap[c];
                    heap[c] = heap[root];
                    heap[root] = temp;
                }
                root = c;
            } while (c < i);
        }

        for (int num : heap) {
            System.out.print(num + "\t");
        }
    }
}

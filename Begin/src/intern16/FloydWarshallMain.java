package intern16;

public class FloydWarshallMain {
    int number = 4; //정점의 수
    int INF = 10000000; //최소비용의 최대값
    
    // 그래프 비용 배열 //
    int[][] graph = {
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };
    
    private void floydWarshall() {
        int[][] result = new int[number][number]; //플로이드 와샬 구현 결과 그래프
        
        // 결과 그래프 초기화
        for(int i=0; i<number; i++) {
            for(int j=0; j<number; j++) {
                result[i][j] = graph[i][j];
            }
        }
        
        // 비용 갱신
        for(int k=0; k<number; k++) { //k = 거쳐가는 노드
            for(int i=0; i<number; i++) { //i = 출발 노드
                for(int j=0; j<number; j++) { //j = 도착 노드
                    if(result[i][j]> result[i][k] + result[k][j]) {
                        // i에서 j로 가는 비용이 i에서 k를 거쳐 j로 가는 비용보다 클 경우 갱신
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }
        
        // 결과 출력
        for(int[] row : result) {
            for(int column : row) {
                System.out.print(column+"\t");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        FloydWarshallMain action = new FloydWarshallMain();
        action.floydWarshall();
    }
}

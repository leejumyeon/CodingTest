package intern12;

import java.util.LinkedList;

import intern08.Graph;

public class DijkstraMain {

    private static int number = 6;
    private static int INF = 10000000;
    
    // 전체 그래프 초기화
    private static int a[][] = {{0,2,5,1,INF,INF},
                                {2,0,3,2,INF,INF},
                                {5,3,0,3,1,5},
                                {1,2,3,0,1,INF},
                                {INF,INF,1,1,0,2},
                                {INF, INF, 5, INF, 2, 0}};
    
    private static boolean v[] = new boolean[6]; //방문한 노드
    private static int distance[] = new int[6];
    
    public static void main(String[] args) {
        // 다익스트라(dijkstra) 알고리즘
        dijkstra(2);
        for(int i=0; i<number; i++) {
            System.out.print(distance[i]+"\t");
        }

    }
    
    private static void dijkstra(int start) {
        // 결과값 distance를 전체 그래프에서 구하고자 하는 노드부터 출발하는 비용으로 초기화
        for(int i=0; i<number; i++) {
            distance[i] = a[start][i];
        }
        v[start] = true; //자기자신 방문으로 처리
        for(int i=0; i<number-2; i++) { // 첫 노드(시작노드)와 마지막 노드를 확인하지 않아도되니까 -2만큼 반복횟수를 빼준다.
            int current = getSmallIndex();
            v[current] = true;
            for(int j=0; j<number; j++) {
                if(!v[j]) {
                    if(distance[current] + a[current][j] < distance[j]) {
                        distance[j] = distance[current] + a[current][j];
                    }
                }
            }
        }
    }
    
    // 가장 최소거리를 가지는 정점을 반환
    private static int getSmallIndex() {
        int min = INF; //최소비용의 최대값으로 초기화
        int index = 0; //노드번호
        for(int i=0; i<number; i++) {
            if(distance[i] < min && !v[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

}

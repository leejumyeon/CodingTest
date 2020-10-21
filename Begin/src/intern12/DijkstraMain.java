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
        dijkstra(0);
        for(int i=0; i<number; i++) {
            System.out.print(distance[i]+"\t");
        }

    }
    
    private static void dijkstra(int start) {
        for(int i=0; i<number; i++) {
            distance[i] = a[start][i];
        }
        v[start] = true;
        for(int i=0; i<number-2; i++) {
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
    
    private static int getSmallIndex() {
        int min = INF;
        int index = 0;
        for(int i=0; i<number; i++) {
            if(distance[i] < min && !v[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

}

package intern201119;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class EdmondsKarpAlgorithmMain {

    private final static int MAX = 100;
    private final static int INF = 1000000000;
    
    private static int n = 6;
    private static int result = 0;
    private static int[][] c = new int[MAX][MAX]; // 용량 c[출발 정점][도착 정점] = 용량
    private static int[][] f = new int[MAX][MAX]; // 유량 f[출발 정점][도착 정점] = 유량
    private static int[]d = new int[MAX]; // 정점들의 배열
    private static Vector<Integer>[] a = new Vector[MAX];
    
    private static void maxFlow(int start, int end) {
        while(true) {
            Arrays.fill(d, -1); //배열 d의 모든 값을 -1로 초기화
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(start); 
            while(!q.isEmpty()) {
                int x = q.poll();
                for(int i=0; i<a[x].size(); i++) {
                    int y = a[x].get(i);
                    // 방문하지 않은 노드 중에 용량이 남은 경우
                    if(c[x][y] - f[x][y] > 0 && d[y] == -1) {
                        q.add(y);
                        d[y] = x; //경로 기억
                        if(y == end) break; //도착지에 도달했을 경우
                    }
                }
            }
            if(d[end] == -1) break; //모든 경로를 찾은 뒤 탈출 d[end] != -1 : end로 가는 정점이 있다는 의미 즉, 경로가 있다.
            int flow = INF;
            for(int i=end; i!=start; i=d[i]) { // end부터 거꾸로 유량을 탐색해서 최소유량 추출
                System.out.println(d[i]+"-"+i+"용량:"+c[d[i]][i]+"/유량"+f[d[i]][i]);
                flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
            }
            System.out.println("최소유량:"+flow);
            // 최소 유량만큼 추가한다.
            for(int i=end; i!=start; i=d[i]) {
                f[d[i]][i] += flow;
                f[i][d[i]] -= flow; //음의 경로
            }
            result += flow;
        }
    }
    public static void main(String[] args) {
        // 네트워크 플로우(Network Flow) 알고리즘 중 에드몬드 카프 알고리즘 구현 //
        for(int i=0; i<=n; i++) {
            a[i] = new Vector<>();
        }
        
        a[1].add(2);
        a[2].add(1);
        c[1][2] = 12;
        
        a[1].add(4);
        a[4].add(1);
        c[1][4] = 11;

        a[2].add(3);
        a[3].add(2);
        c[2][3] = 6;
        
        a[2].add(4);
        a[4].add(2);
        c[2][4] = 3;
        
        a[2].add(5);
        a[5].add(2);
        c[2][5] = 5;
        
        a[2].add(6);
        a[6].add(2);
        c[2][6] = 9;
        
        a[3].add(6);
        a[6].add(3);
        c[3][6] = 8;
        
        a[4].add(5);
        a[5].add(4);
        c[4][5] = 9;
        
        a[5].add(3);
        a[3].add(5);
        c[5][3] = 3;
        
        a[5].add(6);
        a[6].add(5);
        c[5][6] = 4;
        
        maxFlow(1, 6);
        System.out.println(result);

    }

}

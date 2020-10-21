package intern08;
//인접 리스트를 이용한 방향성 있는 크래프 클래스

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V; //노드의 개수
    private LinkedList<Integer> adj[]; //인접 리스트
    
    // 생성자
    @SuppressWarnings("unchecked")
    
    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) { //인접 리스트 초기화
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    // 노드를 연결 v->w //
    void addEdge(int v, int w) {adj[v].add(w);}
    
    // BFS구현 //
    void BFS(int s) { //s를 시작노드로 한 BFS로 탐색하면서 탐색한 노드들을 출력
        
        boolean visited[] = new boolean[V]; //노드의 방문 여부 판단(초기값: false)
        Queue<Integer> queue = new LinkedList<Integer>(); //BFS를 구현하기 위햔 큐 생성
        
        //현재 노드를 방문한 것으로 표시하고 큐에 삽입
        visited[s] = true;
        queue.offer(s);
        
        //큐가 빌 때까지 반봅
        while(queue.size()!=0) {
            //방문한 노드를 큐에서 추출하고 값을 출력
            s = queue.poll();
            System.out.print(s+" ");
            
            //방문한 노드와 인접한 모든 노드를 가져온다.
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                //방문하지 않은 노드면 방문한 것으로 표시하고 있는 큐에 삽입
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
    // DFS에 의해 사용되는 함수 //
    void DFSUtil(int v, boolean visited[]) {
        //현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v+" ");
        
        //방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].iterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) //방문하지 않은 노드일 경우 해당 노드를 시작으로 DFSUtil을 다시 호출
                DFSUtil(n, visited); //순환 호출
        }
    }
    
    void DFS(int v) {
        boolean visited[] = new boolean[V]; //노드 방문 여부 판단
        DFSUtil(v, visited); //v를 시작 노드로 DFSUtil호출
    }
    
    // 비연결형 그래프인 경우, 모든 정점을 하나씩 방문해야 한다.
    void DFS() {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++) {
            DFSUtil(i,visited);
        }
    }
}

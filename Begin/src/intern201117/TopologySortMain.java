package intern201117;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TopologySortMain {
	final static int MAX=10;
	private static int n;
	private static int[] inDegree = new int[MAX]; //각 정점(index가 정점의 번호)의 간선의 수가 담긴 배열
	private static Vector<Integer>[] a = new Vector[MAX];
	
	private static void togoplogySort() {
	    int[] result = new int[MAX];
	    Queue<Integer> q = new LinkedList<Integer>(); //선입선출
	    
	    // 진입차수가 0인 노드를 큐에 삽입
	    for(int i=1; i<=n; i++) {
	        if(inDegree[i] == 0) q.offer(i);
	    }
	    
	    // 정렬이 완전히 수행되려면 정확히 n개의 노드를 방문해야 한다.
	    for(int i=1; i<=n; i++) {
	        // n개를 방문하기 전에 큐가 비워진다면 사이클이 발생하는 것.
	        if(q.isEmpty()) {
	            System.out.println("사이클이 발생했습니다.");
	            return;
	        }
	        
	        int x = q.poll(); //큐의 제일 위에있는 원소값 반환
	        result[i] = x;
	        for(int j=0; j<a[x].size(); j++) { //x번째 노드에 연결되어 있는 노드(진입할 노드) 수 만큼 반복
	            int y = a[x].get(j);  //연결되어 있는 노드의 값을 추출
	            if(--inDegree[y] == 0) { // 추출한 노드(y)와 지금 노드의 간선을 지웠을 때 0이 나온다면 큐에 삽입
	                q.offer(y);
	            }
	        }
	    }
	    
	    for(int i=1; i<=n; i++) {
	        System.out.print(result[i]+"\t");
	    }
	}
	
	public static void main(String[] args) {
		n = 7;
		for(int i=0; i<a.length; i++) {
		    a[i] = new Vector<>();
		}
		a[1].add(2);
		inDegree[2]++;
		a[1].add(5);
        inDegree[5]++;
        a[2].add(3);
        inDegree[3]++;
        a[3].add(4);
        inDegree[4]++;
        a[4].add(6);
        inDegree[6]++;
        a[5].add(6);
        inDegree[6]++;
        a[6].add(7);
        inDegree[7]++;
        togoplogySort();

	}

}

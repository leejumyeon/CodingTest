package intern20201118;

import java.util.Stack;
import java.util.Vector;

public class TarjanAlgorithmMain {
    // scc추출 알고리즘 중 하나 타잔 알고리즘 구현 //
    private static final int MAX = 10001;
    private static int id;
    private static int[] d = new int[MAX]; // 노드의  배열
    private static boolean[] finished = new boolean[MAX];
    private static Vector<Integer>[] a = new Vector[MAX];
    private static Vector<Vector<Integer>> sccList = new Vector<>();
    private static Stack<Integer> s = new Stack<Integer>();
    
    public static int dfs(int x) {
        d[x] = ++id; // 각 노드마다 고유 번호를 할당
        s.push(x); //스택에 자기자신 삽입
        int parent = d[x]; //부모
        for(int i=0; i<a[x].size(); i++) { //x에서 출발하는 노드 갯수만큼 반복
            int y = a[x].get(i); // x에서 출발하는 노드 대입
            if(d[y] == 0) parent = Math.min(parent, dfs(y)); //방문하지 않은 이웃인 경우(재귀 시작)
            else if(!finished[y]) parent = Math.min(parent, d[y]); //방문했고 처리중인 이웃인 경우(재귀 종료)
        }
        
        if(parent == d[x]) {
            Vector<Integer> scc = new Vector<Integer>();
            while(true) {
                int t = s.pop();
                scc.add(t);
                finished[t] = true;
                if(t == x) break;
            }
            sccList.add(scc);
        }
        // 자신의 부모값을 반환한다.
        return parent;
    }
    
	public static void main(String[] args) {
		int v = 11;
		for(int i=0; i<a.length; i++) {
		    a[i] = new Vector<Integer>();
		}
		a[1].add(2);
		a[2].add(3);
		a[3].add(1);
		a[4].add(2);
		a[4].add(5);
		a[5].add(7);
		a[6].add(5);
		a[7].add(6);
		a[8].add(5);
		a[8].add(9);
		a[9].add(10);
		a[10].add(11);
		a[11].add(3);
		a[11].add(8);
		
		for(int i=1; i<=v; i++) {
		    if(d[i] == 0) dfs(i);
		}
		
		System.out.println("SCC의 개수:"+sccList.size());
		for(int i=0; i<sccList.size(); i++) {
		    System.out.print((i+1)+"번째 SCC:");
		    for(int j=0; j<sccList.get(i).size(); j++) {
		        System.out.print("\t"+sccList.get(i).get(j));
		    }
		    System.out.println();
		}

	}

}

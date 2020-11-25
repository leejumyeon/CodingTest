package intern20201123;

import java.util.Arrays;
import java.util.Vector;

public class BipartiteMatchingMain {
	
	public static final int MAX = 101;
	private static Vector<Integer>[] a = new Vector[MAX]; //그래프 변수 1개 Vector = 해당 노드의 인접노드
	private static int[] d = new int[MAX]; //진입경로 
	private static boolean[] c = new boolean[MAX]; // 진입여부
	private static int n = 3; //1개 그룹 그래프의 정점 갯수
	private static int m, s;
	
	public static void main(String[] args) {
		// 이분매칭 알고리즘 구현 //
		
		// 그래프 초기화
		for(int i=1; i<=n; i++) {
			a[i] = new Vector<Integer>();
		}
		
		// 조건에 맞도록 그린 그래프
		a[1].add(1);
		a[1].add(2);
		a[1].add(3);
		a[2].add(1);
		a[3].add(2);
		
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(c, false); //boolean[]인 c의 모든 index의 값을 false로 초기화
			if(dfs(i)) count++;
		}
		
		System.out.println(count+"개의 매칭이 이루어졌습니다.");
		for(int i=1; i<=100; i++) {
			if(d[i] != 0) {
				System.out.println(d[i]+"->"+i);
			}
		}

	}
	
	// 이분매칭 method
	private static boolean dfs(int x) { //int x = 연결을 시도하는 정점의 번호
		// 연결된 모든 노드에 대해서 들어갈 수 있는지 시도
		for(int i=0; i<a[x].size(); i++) {
			int t = a[x].get(i); //t = x의 인접 노드들 중 하나를 담는 변수
			if(c[t]) continue; // 배열 c에서 t자리의 값이 true = 이미 연결되어 있다면 증감식으로 이동
			// 위 if문이 거짓 = 아직 연결되어 있이 않다면
			c[t] = true;
			if(d[t] == 0 || dfs(d[t])) { //dfs(d[t]) = t에 접근했던 정점 다른 x의 점유노드에 다른 들어갈 공간이 있는 경우 확인
				d[t] = x;
				return true; //1개 매칭이 되었다면 바로 method 중지시키는 것이 포인트
			}
		}
		return false;
	}

}

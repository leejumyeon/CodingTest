package intern11;

import java.util.ArrayList;
import java.util.Collections;


public class KruskalMain {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // 크루스칼 알고리즘 = 최소비용 신장트리 구현 알고리즘
        int n = 7; //노드 개수
        int m = 11; //간선의 개수
        
        // 노드와 노드를 연결하는 간선의 정보를 담는 Vector
        ArrayList<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(1,7,12));
        list.add(new Edge(1,4,28));
        list.add(new Edge(1,2,67));
        list.add(new Edge(1,5,17));
        list.add(new Edge(2,4,24));
        list.add(new Edge(2,5,62));
        list.add(new Edge(3,5,20));
        list.add(new Edge(3,6,37));
        list.add(new Edge(4,7,13));
        list.add(new Edge(5,6,45));
        list.add(new Edge(5,7,73));
        
        //간선 오름차순 정렬
        Collections.sort(list);
        
        // 각 정점이 포함된 그래프가 어디인지 저장하는 함수
        int set[] = new int[n]; // 각 index는 노드번호-1
        for(int i=0; i<n; i++) {
            set[i] = i;
        }
        
        // 거리의 합을 0으로 초기화
        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            if(!find(set, list.get(i).node[0]-1, list.get(i).node[1]-1)) {
                sum += list.get(i).distance;
                unionParent(set, list.get(i).node[0]-1, list.get(i).node[1]-1);
                System.out.println(list.get(i).distance+":"+list.get(i).node[0]+"-"+list.get(i).node[1]);
            }
        }
        
        System.out.println("결과값:"+sum);

    }
    
    private static int getParent(int[] set, int x) {
        if(set[x] == x) return x;
        return getParent(set, set[x]);
    }
    
    private static void unionParent(int[] set, int a, int b) {
        a = getParent(set, a);
        b = getParent(set, b);
        if(a > b) set[a] = b;
        else set[b] = a;
    }
    
    private static boolean find(int[] set, int a, int b) {
        a = getParent(set, a);
        b = getParent(set, b);
        if(a == b) return true;
        else return false;
    }

}

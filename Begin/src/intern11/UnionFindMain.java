package intern11;

public class UnionFindMain {
    
    public static void main(String[] args) {
        // Union-Find(대표적인 그래프 알고리즘) 구현
        int[] parent = new int[11]; // 1~10까지의 노드가 갖고있는 부모노드의 값들의 배열 0번 index사용 안함
        
        // 제일 처음으로 각각의 노드들은 자기자신을 부모노드로 갖는다.
        for(int i=1; i<parent.length; i++) {
            parent[i] = i;
        }
        
        unionParent(parent, 1,2);
        unionParent(parent, 2,4);
        unionParent(parent, 1,6);
        unionParent(parent, 5,3);
        unionParent(parent, 5,8);
        unionParent(parent, 3,9);
        
        System.out.println("1과 4는 서로 같은 집합에 있나요? =>"+findParent(parent, 1, 4));
        System.out.println("1과 3은 서로 같은 집합에 있나요? =>"+findParent(parent, 1, 3));
        
    }

    // 노드 부모 찾기 method : 재귀함수 사용
    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x; //인자값이랑 parent안의 x번째 값이랑 같은 경우 인자값 x를 그대로 반환
        return getParent(parent, parent[x]);// 위 if문의 조건절이 거짓인 경우 = 인자값이랑 그 위치에 들어가 있는 부모값이랑 다른 경우 해당 값의 부모노드를 얻기 위해 재귀함수 사용
    }
    
    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return true;
        else return false;
    }

}

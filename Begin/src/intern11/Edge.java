package intern11;

@SuppressWarnings("rawtypes")
public class Edge implements Comparable{
    public int node[] = new int[2]; //연결하는 두 노드??
    public int distance = 0; //거리
    
    public Edge(int a, int b, int distance) {
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
    
    public boolean operator(Edge e) {
        return this.distance < e.distance;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge)o;
        Integer i = this.distance;
        int result = i.compareTo(e.distance);
        return result;
    }
}

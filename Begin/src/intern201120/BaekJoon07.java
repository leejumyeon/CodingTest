package intern201120;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon07 {

    public static void main(String[] args) {
        // 2252번 줄세우기(위상정렬 문제) //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        final int MAX = 32001;
        int[] inDegree = new int[MAX];
        int[] result = new int[MAX];
        Vector<Integer>[] a = new Vector[MAX];
        
        for(int i=1; i<=n; i++) {
            a[i] = new Vector<Integer>();
        }
        
        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            inDegree[y]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1; i<=n; i++) {
            if(inDegree[i] == 0) {
                
                q.add(i);
            }
        }
        
        for(int i=1; i<=n; i++) {
            int x = q.poll();
            System.out.println(x);
            for(int j=0; j<a[x].size(); j++) {
                int y = a[x].get(j);
                if(--inDegree[y] == 0) {
                    q.add(y);
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            System.out.print(result[i]+" ");
        }
    }

}

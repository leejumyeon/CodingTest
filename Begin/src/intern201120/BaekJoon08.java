package intern201120;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon08 {

    public static void main(String[] args) {
        // 1516번 게임개발 //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];
        int[] inDegree = new int[n];
        int[] result = new int[n];
        Vector<Integer>[] a = new Vector[n];
        for(int i=0; i<n; i++) {
            a[i] = new Vector<Integer>();
        }
        
        for(int i=0; i<n; i++) {
            time[i] = sc.nextInt();
            while(true) {
                int x = sc.nextInt();
                if(x == -1) break;
                a[x-1].add(i);
                inDegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<n; i++) {
            if(inDegree[i] == 0) {
                result[i] = time[i];
                q.add(i);
            }
        }
        
        for(int i=0; i<n; i++) {
            int x = q.poll();
            for(int j=0; j<a[x].size(); j++) {
                int y = a[x].get(j);
                result[y] = Math.max(result[y], result[x]+time[y]);
                if(--inDegree[y] == 0) {
                    q.add(y);
                }
                
            }
        }
        
        for(int i=0; i<n; i++) {
            System.out.println(result[i]);
        }
        
    }

}

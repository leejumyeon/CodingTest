package intern20201124;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithmMain {
    
    public static void main(String[] args) {
        // KMP 알고리즘 구현 //
        // 1.접두사와 접미사 최대 일치 길이를 갖는 Collection 생성
        String pattern = "abacaaba";
        String parent = "ababacabacaabacaaba";
        KMP(parent, pattern);
        

    }
    
    private static void KMP(String parent, String pattern) {
        List<Integer> table = makeTable(pattern);
        int patternSize = pattern.length(); 
        int parentSize = parent.length();
        int j = 0;
        for(int i=0; i<parentSize; i++) {
           while(j > 0 && parent.charAt(i) != pattern.charAt(j)) {
               System.out.println(pattern.charAt(j) + "/" + parent.charAt(i));
               j = table.get(j-1);
           }
           if(parent.charAt(i) == pattern.charAt(j)) {
               if(j == patternSize - 1) {
                   System.out.println(i-patternSize+2+"번째에서 찾았습니다.");
                   j = table.get(j);
               }
               else {
                   j++;
               }
           }
        }
        
    }

    private static List<Integer> makeTable(String pattern){
        int patternSize = pattern.length();
        List<Integer> table = new ArrayList<Integer>();
        int j = 0;
        table.add(0); //제일 처음 최대 일치길이는 0이므로
        for(int i=1; i<patternSize; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table.get(j-1); // table에는 순차적으로 증가한 값이 들어가 있으니 현재 위치(j)에서 이전 위치(j-1)값이 들어간다는 것은 -1을 한다는 것과 동일
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                table.add(++j);
            }
            else {
                table.add(0);
            }
        }
        return table;
    }

}

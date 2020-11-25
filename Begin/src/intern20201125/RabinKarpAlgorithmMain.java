package intern20201125;

public class RabinKarpAlgorithmMain {

    private static void findString(String parent, String pattern) {
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int parentHash = 0, patternHash = 0, power = 1;
        for (int i = 0; i <= parentSize - patternSize; i++) {
            if (i == 0) { //처음 시작시 긴 글의 시작부분 Hash값과 패턴의 Hash값 추출
                for (int j = 0; j < patternSize; j++) {
                    patternHash = patternHash + pattern.charAt(patternSize - 1 - j) * power;
                    parentHash = parentHash + parent.charAt(patternSize - 1 - j) * power;
                    if (j < patternSize - 1) {
                        power *= 2;
                    }
                }
            }
            else { //긴 글 Hash값이 이미 구해져 있는 경우
                parentHash = 2*(parentHash - parent.charAt(i-1)*power) + parent.charAt(patternSize-1+i);
            }
            
            if(parentHash == patternHash) { //patternHash값과 같은 Hash값을 찾은 경우
                boolean finded = true;
                for(int j = 0; j<patternSize; j++) { //문자 하나하나 비교
                    if(parent.charAt(i+j) != pattern.charAt(j)) { //서로 같은 문자가 아닐 경우
                        finded = false;
                        break;
                    }
                }
                if(finded) {
                    System.out.println((i+1)+"번째에서 발견했습니다.");
                }
                
            }
        }
    }

    public static void main(String[] args) {
        // 라빈카프 알고리즘 구현 //
        String parent = "ababacabacaabacaaba";
        String pattern = "abacaaba";
        findString(parent, pattern);
    }

}

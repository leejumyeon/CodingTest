package intern06;

public class ProgrammersSkillCheck2 {

    public static void main(String[] args) {
        // ()로만 되어있는 문자열에서 (와 )이 제대로 세트가 되어있는지 판단하는 문제
        String s = "(()()()()()()())()()()()()(((()))))))(())(((()"; //입력 문자열
        boolean answer = true; 
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')') {
            answer = false;
        }
        else {
            int left = 0;
            int right = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='(') left++;
                else if(s.charAt(i)==')') right++;
            }
            if(left != right) answer = false;
            System.out.println(left +"/"+ right);
        }
        
        System.out.println("결과값:"+answer);

    }

}

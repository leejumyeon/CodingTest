package intern04;

public class Programmers06 {
    
    public static void main(String[] args) {
        //전화번호 문자열 phone_number가 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *로 가린 문자열를 출력해라
        // 조건1. phone_number의 길이는 4이상, 20이하
        
        String phone_number = "8698";
        String answer = "";
        if(phone_number.length()<=4) {
            answer = phone_number;
        }
        else {
            StringBuilder strBuild = new StringBuilder(phone_number);
            for(int i=0; i<phone_number.length()-4; i++) {
                strBuild.setCharAt(i, '*');
            }
            answer = strBuild.toString();
        }
        
        System.out.println("결과값:"+answer);
        
    }
}

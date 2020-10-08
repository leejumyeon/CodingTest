package intern04;

public class Programmers11 {

    static int tempL = 10;
    static int tempR = 12;//#위치값
    static String myhand;
    
    public static void main(String[] args) {
        // 키패드 누르기 //
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand="right";
        myhand = ((hand.equals("right"))?"R":"L");
        String answer = "";
        
        
        
        for(int i=0; i<numbers.length; i++) {
            switch(numbers[i]) {
            case 1: case 4: case 7:
                answer+="L";
                tempL = numbers[i];
                break;
            case 3: case 6: case 9:
                answer+="R";
                tempR = numbers[i];
                break;
            default:
                String tempHand = checkHand(numbers[i]);
                if(tempHand.equals("R"))
                    tempR = numbers[i] + ((numbers[i] == 0)?11:0);
                else
                    tempL = numbers[i] + ((numbers[i] == 0 )? 11:0);
                answer+=tempHand;
            }
        }
        System.out.print("결과값: "+answer+"\t");
    }
    
    static String checkHand(int tempNum) {
        int leftDistance = 0;
        int rightDistance = 0;
        if(tempNum == 0) tempNum = 11;
        
        leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3)+Math.abs((tempNum-1)%3 - (tempL-1)%3);
        rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3) + Math.abs((tempNum-1)%3 - (tempR)&3);
        System.out.println(tempNum+":"+leftDistance+","+rightDistance);
        
        return ((leftDistance == rightDistance)? myhand:(leftDistance > rightDistance)?"R":"L");
    }

}

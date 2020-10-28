package intern16;

import java.util.Scanner;

public class BaekJoon01 {

    public static void main(String[] args) {
        // 2884번 알람시계 //
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        
        if(min < 45) { //시간까지 변동되는 경우
            hour -=1;
            if(hour<0) //시간이 00->23이 되는 경우
                hour = 23;
            min = (min + 60) - 45;
        }
        else //시간이 변동안되고 분만 변됭되는 경우
            min -= 45;
        System.out.println(hour+" "+min);

    }

}

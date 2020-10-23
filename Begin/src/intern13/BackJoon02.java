package intern13;

import java.util.Scanner;

public class BackJoon02 {

    public static void main(String[] args) {
        // 1110번 더하기 사이클 //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int temp = num;
        int beforTemp = temp;
        do {
            beforTemp = temp;
            if(temp>=10)
                temp = (temp/10)+(temp%10);
            temp = (beforTemp%10)*10 + (temp%10);
            count++;
        }while(temp != num);
        System.out.println(count);
    }

}

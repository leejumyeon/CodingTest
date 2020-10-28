package intern16;

import java.util.Scanner;

public class BaekJoon02 {

    public static void main(String[] args) {
        // 1546번 평균 //
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 과목의 개수
        double[] score = new double[x]; // 점수의 배열
        double max = 0; // 점수중의 최대값
        for (int i = 0; i < score.length; i++) { // 점수입력 & 최대값 구하기
            score[i] = sc.nextInt();
            if (max < score[i])
                max = score[i];
        }

        // 조작된 평균구하기
        double sum = 0; // 합계
        for (int i = 0; i < score.length; i++) 
            sum += score[i];
        System.out.println((sum /max*100)/ x); 
    }
}

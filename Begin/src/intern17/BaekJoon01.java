package intern17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon01 {

    public static void main(String[] args) throws IOException {
        // 10039번 평균점수 //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 5; // 시험을 본 인원의 수
        int sum = 0; // 시험의 총점
        for (int i = 0; i < x; i++) {
            int score = Integer.parseInt(br.readLine());
            if (score < 40)
                score = 40;
            sum += score;
        }

        System.out.println(sum / x);
    }

}

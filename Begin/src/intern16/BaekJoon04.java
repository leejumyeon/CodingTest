package intern16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon04 {

    public static void main(String[] args) throws IOException {
        // 4344번 평균은 넘겠지 //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        double[] avgList = new double[x];
        String[][] testCase = new String[x][];

        // 각 테스트 케이스마다 평균구하기
        for (int i = 0; i < x; i++) {
            String line = br.readLine();
            testCase[i] = line.split(" ");
            int sum = 0;
            for (int j = 1; j < testCase[i].length; j++) {
                sum += Integer.parseInt(testCase[i][j]);
            }
            avgList[i] = sum / Double.parseDouble(testCase[i][0]);
        }

        // 각 테스트 케이스마다 평균넘늠 사람 비율구하기
        for (int i = 0; i < x; i++) {
            int count = 0;
            for (int j = 1; j < testCase[i].length; j++) {
                if (avgList[i] < Double.parseDouble(testCase[i][j]))
                    count++;
            }
            double persentagi = count / Double.parseDouble(testCase[i][0]) * 100;
            System.out.println(String.format("%.3f", persentagi) + "%");
        }

    }

}

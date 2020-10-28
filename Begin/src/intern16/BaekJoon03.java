package intern16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon03 {

    public static void main(String[] args) throws IOException {
        // 15552번 빠른 A+B //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < x; i++) {
            String text = br.readLine();
            String[] number = text.split(" ");
            int a = Integer.parseInt(number[0]);
            int b = Integer.parseInt(number[1]);
            bw.write((a + b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

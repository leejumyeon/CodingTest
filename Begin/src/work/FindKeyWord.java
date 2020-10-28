package work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindKeyWord {

    public static void main(String[] args) {
        // 현재 디렉토리에서 *.java파일 안에 'String'이란 단어가 몇개 들어가 있는지 카운트 해라.
        int sum = 0;
        sum = findString("C:/Users/CREWMATE/git/ojt2020", sum);
        System.out.println("결과값:" + sum);
    }

    public static int findString(String path, int sum) {
        // 파일 생성(디렉토리)
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            // 루트 디렉토리에서 얻어온 파일들 중에서 폴더인지 파일인지 분류
            if (file.isDirectory()) {
                sum = findString(file.getPath(), sum);
            } else {
                // 파일일 경우 확장자가 .java인지 확인
                int pot = file.getPath().lastIndexOf(".");
                if (".java".equals(file.getPath().substring(pot))) {
                    sum += countWord(file.getPath());
                }
            }
        }

        return sum;
    }

    public static int countWord(String path) {
        int count = 0;
        File file = new File(path);
        try (BufferedReader inFile = new BufferedReader(new FileReader(file))) {
            String sLine = inFile.readLine();
            while (sLine != null) {
                String[] str = sLine.split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (str[i].contains("String")) // 문자열 안에 String이 포함되어 있다면 count증가
                        count++;
                }
                sLine = inFile.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}

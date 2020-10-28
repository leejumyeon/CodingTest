package work;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCsvParser2 implements CsvParser {

    @Override
    public List<CsvData> parse(Reader reader) throws IOException {
        List<CsvData> data = new ArrayList<>();
        int nextCh = reader.read();
        int quotaCnt = 0;
        StringBuilder word = new StringBuilder();
        CsvData csv = new CsvData();
        while (nextCh != -1) {
            char singleCh = (char) nextCh;
            nextCh = reader.read();
            if ((char) singleCh == '"') {
                quotaCnt++;
                if (quotaCnt > 1 && quotaCnt % 2 != 0)
                    word.append(singleCh);
                continue;
            }
            // "가 홀수이면 무조건 data인 것이고 짝수이면 , \n \r등을 검사해야 한다. //
            if (quotaCnt % 2 != 0) { // data인식
                word.append(singleCh);
            } else { // " "가 끝난 경우 = 특수문자 구별
                quotaCnt = 0;
                if (singleCh == ',') {
                    csv.add(word.toString());
                    word = new StringBuilder();
                } else if (singleCh == '\n') {
                    csv.add(word.toString());
                    word = new StringBuilder();
                    data.add(csv);
                    csv = new CsvData();
                } else if (singleCh != '\r') {
                    word.append(singleCh);
                }
            }
        }
        return data;
    }
}

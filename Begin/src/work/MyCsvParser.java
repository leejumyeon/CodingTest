package work;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCsvParser implements CsvParser {
    @Override
    public List<CsvData> parse(Reader reader) throws IOException {
        List<CsvData> data = new ArrayList<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();

        int nextCh = reader.read();
        char singleCh;
        boolean makeWordFlag = false;
        StringBuilder word = new StringBuilder();
        CsvData csv = new CsvData();
        while (nextCh != -1) {
            singleCh = (char) nextCh;
            if (!makeWordFlag)
                nextCh = reader.read();
            makeWordFlag = false;
            if ((char) nextCh == ',') { // word를 csv에 add
                csv = csvAdd(csv, word, singleCh);
                word = new StringBuilder();
                nextCh = reader.read();
            } else if ((char) nextCh == '\n') { // csv를 data에 add
                data = dataAdd(data, csv, word, singleCh);
                word = new StringBuilder();
                csv = new CsvData();
                nextCh = reader.read();
            } else if ((char) singleCh == '"') { // data인식
                dataMap = makeWord(word, reader, nextCh, singleCh);
                word = (StringBuilder) dataMap.get("word");
                nextCh = (int) dataMap.get("nextCh");
                makeWordFlag = true;
            } else if ((char) nextCh == '\r') {
                nextCh = reader.read();
                makeWordFlag = true;
            } else
                word.append(singleCh);
        }

        return data;
    }

    // 단어 data 획득 메소드
    private CsvData csvAdd(CsvData csv, StringBuilder word, char singleCh) {
        if (singleCh != ',' && singleCh != '\n' && singleCh != '\r')
            word.append(singleCh);
        csv.add(word.toString());
        return csv;
    }

    // 1개 줄 data 획득 메소드
    private List<CsvData> dataAdd(List<CsvData> data, CsvData csv, StringBuilder word, char singleCh) {
        csv = csvAdd(csv, word, singleCh);
        data.add(csv);
        return data;
    }

    // 단어 data 생성 메소드
    private Map<String, Object> makeWord(StringBuilder word, Reader reader, int nextCh, char singleCh)
            throws IOException {
        boolean finishFlag = false;
        Map<String, Object> resultMap = new HashMap<String, Object>();
        do {
            singleCh = (char) nextCh;
            nextCh = reader.read();
            if (singleCh == '"') {
                if (nextCh == ',' || nextCh == '\n' || nextCh == '\r')
                    finishFlag = true;
                else {
                    word.append(singleCh);
                    nextCh = reader.read();
                }
            } else
                word.append(singleCh);

        } while (!finishFlag);
        resultMap.put("word", word);
        resultMap.put("nextCh", nextCh);
        return resultMap;
    }
}

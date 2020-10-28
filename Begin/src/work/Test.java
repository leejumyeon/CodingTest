package work;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class Test {
    public static void main(String[] args) throws IOException {
        CsvParser csvParser = new MyCsvParser();
        String path = "C:/Users/CREWMATE/Desktop/test.csv";
        File file = new File(path);
        FileReader reader = new FileReader(file, Charset.forName("EUC-KR"));
        
        List<CsvData> data = csvParser.parse(reader);
        
        for(CsvData csv : data) {
            for(String str : csv.getItems()) {
                System.out.print(str+"\t");
            }
            System.out.println();
        }
        
        reader.close();
    }
}

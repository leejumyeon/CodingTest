package work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {
    
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9191)) {
            System.out.println("Listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new HttpThread(socket));
                thread.start();
            }
        }
    }
}

class HttpThread implements Runnable {
    private Socket socket;
    private static final String BASE_DIR = "C:/Users/CREWMATE/git/CodingTest/Begin";
    HttpThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader reader = null;
        PrintWriter pw = null;
        try (InputStream io = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            int count = 0;
            reader = new BufferedReader(new InputStreamReader(io, "UTF-8"));
            pw = new PrintWriter(os, true);
            Map<String, String> requestMap = new HashMap<String, String>();

            // 요청읽어오기 //
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                count++;
                System.out.println(line);
                if (line.equals(""))
                    break;
                if (count == 1) {
                    String[] firstLine = line.split(" "); // 제일 첫째 줄 읽기(요청타입 / file명 / HTTP1.1
                    requestMap.put("type", firstLine[0]); // 요청타입(get, post)
                    requestMap.put("fileName", firstLine[1]); // 파일명(html, img...)
                } else {
                    String[] otherLine = line.split(":");
                    String value = ""; // ":"가 두 개 이상인 경우 key영역을 제외한 나머지 부분을 value값으로 이어붙이기
                    for (int i = 1; i < otherLine.length; i++) {
                        value += (i == 1) ? otherLine[i].trim() : ":" + otherLine[i].trim();
                    }
                    requestMap.put(otherLine[0], value.substring(1));
                }
            }

            // 응답하기 //
            
            File file = new File(BASE_DIR,requestMap.get("fileName"));
            Path path = Paths.get(BASE_DIR,requestMap.get("fileName"));
            
            
            try (FileInputStream fs = new FileInputStream(file);) {
                String contentType = Files.probeContentType(path); // path경로에 있는 파일의 contentType을 변수에 저장\
                System.out.println("contentType:" + contentType);
                pw.println("HTTP/1.1 200 OK");
                pw.println("Connection: close");
                pw.println("Transfer-Encoding: chunked"); //data의 크기\r\n 전송 후 해당 크기만큼의 data\r\n전송 종료조건 : 0\r\n(data크기) ""\r\n(data) = 빈값일 때 종료
                pw.println("Content-Type: " + contentType + ";charset=UTF-8");
                pw.println("Last-Modified: Tue, 27 Oct 2020 08:20:50 GMT"); //리소스(본문)최종 수정한 날짜
                pw.println("Content-Security-Policy: default-src 'self'"); //외부파일 불러올 때 정책(현재 https를 통해서만 파일을 갖고 올 수 있도록 했다.)
                // => https: 'none' 실행 결과 이미지 파일 (block)처리
                pw.println("Content-Disposition: inline"); //응답헤더에서 본문을 브라우저에 어떻게 표시할지 정하는 구문
                // : inline = web화면에 표시
                // : attachment = 다운로드 받기
                pw.println("Content-Location: "+path.toString()); //해당 개체의 실제 위치를 알려준다.
                //pw.println("Content-Encoding: gzip");
                pw.println("Accept-Ranges: bytes");
                pw.println("Cache-Control: public");
                pw.println("Set-Cookie: A=B");
                //pw.println("Expires: Wen, 28 Oct 2020 08:50:00 GMT");
                pw.println("");
                
                int len = 0;
                byte[] data = new byte[8192];
                while((len = fs.read(data)) != -1) {
                    os.write((Integer.toHexString(len)+"\r\n").getBytes("UTF-8"));
                    os.write(data, 0, len); //청크data(html, 이미지... 등이 들어가므로 byte단위로 처리하는 OutputStream으로 data전송)
                    os.write("\r\n".getBytes("UTF-8"));
                    os.flush();
                    
                }                
                // Encoding: chunked 완전히 종료 //
                os.write("0\r\n".getBytes("UTF-8"));
                os.write("\r\n".getBytes("UTF-8"));
                os.flush();            
                
            } catch (FileNotFoundException e) {
                pw.println("HTTP/1.1 404 NOT FOUND"); 
                pw.println("Connection: close");
                pw.println("");
            }

        } catch (Exception e) { // 파일을 못찾는 경우를 제외한 오류 발생일 경우
            errorMessage302(pw);
        } finally {
            try {
                socket.close();
                reader.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void errorMessage302(PrintWriter pw) {
        pw.println("HTTP/1.1 302 Found"); 
        pw.println("Location: http://localhost:9191/redirect.html");
        pw.println("");
    }
    

}

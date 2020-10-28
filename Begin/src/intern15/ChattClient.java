package intern15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattClient {
    Socket s;
    BufferedReader br;
    PrintWriter pw;
    
    public void go() {
        try {
            s = new Socket("localhost",9090);
            System.out.println("Clent Socket Creating....");
            
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(s.getOutputStream(), true);
            
            ClientThread ct = new ClientThread(s);
            ct.start();
            
            while(true) {
                String line = br.readLine();
                pw.println(line);
            }
        }catch(Exception e) {
            System.out.println("서버와의 연결에 실패했습니다...");
        }
    }
    
    public static void main(String[] args) {
        ChattClient cc = new ChattClient();
        cc.go();
    }
}

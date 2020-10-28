package intern15;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChattServer {
    ServerSocket server; //서버 socket
    Socket s; //client와 연결할 socket
    ArrayList<ChattThread> list;
    
    public ChattServer() {
        list = new ArrayList<ChattThread>();
    }
    
    // 서버가 받은 내용을 전 clientSocket에게 전달하는 메소드
    public void broadCast(String message) {
        for(ChattThread t:list) {
            t.sendMessage(message);
        }
    }
    
    public void go() {
        try {
            server = new ServerSocket(9090);
            System.out.println("Server Ready.....");
            // client 여러명을 받아서 Thread ArrayList로 관리
            while(true) {
                s = server.accept();
                ChattThread ct = new ChattThread(s, this);
                list.add(ct);
                ct.start();
            }
        }catch(Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        ChattServer cs = new ChattServer();
        cs.go();
    }
}

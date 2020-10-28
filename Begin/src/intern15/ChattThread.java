package intern15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattThread extends Thread{

    BufferedReader br;
    PrintWriter pw;
    ChattServer chattServer;
    Socket s;
    
    public ChattThread(Socket s, ChattServer chattServer) {
        this.s = s;
        this.chattServer = chattServer;
        chattServer.broadCast(s.getInetAddress()+"님이 채팅방에 들어오셨습니다."); //모든 연결된 socket
        System.out.println(s.getInetAddress()+"님이 접속하셨습니다."); //서버에만
    }

    public void sendMessage(String str) {
        pw.println(str);
    }
    
    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            pw = new PrintWriter(s.getOutputStream(), true);
            while(true) {
                String line = br.readLine();
                if("exit".equals(line)) {
                    System.out.println(s.getInetAddress()+"님이 접속을 끊으셨습니다.");
                    System.out.println(s.getInetAddress()+"님이 채팅방을 나가셨습니다.");
                    break;
                }
                chattServer.broadCast(line);
            }
        }catch(IOException e) {
            System.out.println(s.getInetAddress()+"님이 접속을 끊으셨습니다.");
            System.out.println(s.getInetAddress()+"님이 채팅방을 나가셨습니다.");
            chattServer.list.remove(this);
        }
    }

}

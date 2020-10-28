package intern15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{

    Socket s;
    BufferedReader br2;
    String str;
    
    public ClientThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            br2 = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            while(true) {
                str = br2.readLine();
                System.out.println("서버메세지:"+str);
            }
        }catch(Exception e) {
            
        }
    }

}

package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public EchoClient() {
        init();
    }

    public void init() {
        try {
            Socket clientSocket = new Socket("localhost", 9090);
            System.out.println("Server Connect");
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());// 서버로 데이터를 보낼 준비
            Scanner sc = new Scanner(System.in);// 입력한 데이터를 읽을 준비
            String inputData = "";// 입력한 데이터를 저장할 공간
            while (true) {
                System.out.print("to Server: ");
                String text = sc.next();
                pw.println(text);// 보낼 내용을 읽어와서 서버로 보낸다
                pw.flush();// 프린터 라이터 메모리를 초기화 시켜서 내부에 있던 데이터를 서버로 전송한다
                if(text.equals("exit")) {
                    break;
                }
                System.out.println("from Server: " + br.readLine()); // 서버에서 받은 데이터를 표기한다.
            }
            clientSocket.close();// 연결 종료하면 소켓을 닫는다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EchoClient();
    }
}

package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new EchoThread(socket));
                thread.start();
            }
        }
    }
}

class EchoThread implements Runnable {
    private Socket socket;

    EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream io = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(io, "UTF-8"));
            PrintWriter pw = new PrintWriter(os, true);
            String line = "";
            for ( line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
                if(line.equals("exit")) {
                    System.out.println("server close");
                    break;
                }
                pw.println(line); //서버에서 읽은 data를 다시 client로 전송
                pw.flush(); //
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
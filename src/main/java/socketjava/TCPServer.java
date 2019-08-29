package socketjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangnan01 on 2017/11/21.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        Socket client;
        client = serverSocket.accept();

        PrintWriter out;
        out = new PrintWriter(client.getOutputStream());
        out.println("Hello world");
        client.close();
        serverSocket.close();
    }
}

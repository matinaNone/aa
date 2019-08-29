package socketjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by wangnan01 on 2017/11/21.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client;
        BufferedReader buf;
        client = new Socket("localhost", 8000);
        buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(buf.readLine());
        buf.close();
        client.close();
    }
}

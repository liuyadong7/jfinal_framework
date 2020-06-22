package core2.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用java连接服务器
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {

        try(
                Socket socket = new Socket("time-a.nist.gov",13);
                Scanner scanner = new Scanner(socket.getInputStream(),"UTF-8")
        ){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }

    }

}

package Chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;



public class ChatClientApp {
    private static final String SERVER_IP = "192.168.0.103";
    private static final int SERVER_PORT = 5000;
    
    public ChatClientApp() {
    	String name = MainFrame.userId;

        Socket socket = new Socket();
        try {
            socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
            consoleLog("채팅방에 입장하였습니다.");
            new ChatWindow(name, socket).show();

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
            String request = "join:" + name + "\r\n";
            pw.println(request);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static void main(String[] args) {
        new ChatClientApp();
    }

    private static void consoleLog(String log) {
        System.out.println(log);
    }
}
package JavaChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class TcpServer {
    public static void main(String[] args) {
        final int SERVER_PORT=5000;

        ServerSocket serverSocket=null;

        try {
            //1.서버소켓 객체생성
            serverSocket=new ServerSocket();

            //로컬호스트의 ip주소받아와서 서버소켓이 bind를 해줌 ip주소와 포트번호로
            //그다음 연결됐다고 출력문써줌
            String localHostAddress= InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress(localHostAddress,SERVER_PORT));
            System.out.println("[server] binding !\naddress : " + localHostAddress+", port :"+SERVER_PORT);


        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(serverSocket!=null && !serverSocket.isClosed()){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package JavaChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        final int SERVER_PORT=5000;

        ServerSocket serverSocket=null;

        try {
            //1.서버소켓 객체생성
            serverSocket=new ServerSocket();

            //2.로컬호스트의 ip주소받아와서 서버소켓이 bind를 해줌 ip주소와 포트번호로
            //그다음 연결됐다고 출력문써줌
            String localHostAddress= InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress(localHostAddress,SERVER_PORT));
            System.out.println("[server] binding !\naddress : " + localHostAddress+", port :"+SERVER_PORT);


            //3.클라이언트로부터 연결 요청이 올때까지 대기(block상태)
            //Tcp 연결과정은 3-hand-shake Socket 객체반환
            //Tcp 연결은 java에서 처리해주며, 더 내부적으론 Os가 처리한다.

            Socket socket=serverSocket.accept();

            //4.연결 요청이 오면 연결이 되었다는 메세지 출력
            InetSocketAddress remoteSocketAddress=(InetSocketAddress)socket.getRemoteSocketAddress();
            String remoteHostName=remoteSocketAddress.getAddress().getHostAddress();
            int remoteHostPort=remoteSocketAddress.getPort();
            System.out.println("[server] connected! \nconnected socket address:"+remoteHostName+", port :"+remoteHostPort);
            //여기서 클라이언트가 요청을 보내오지않았을경우에는 connected 메세지가 출력되지않는다.3번주석에 block 상태라보면됨
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

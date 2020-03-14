package JavaChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClient {
    private static final String SERVER_IP="192.168.0.13"; //이건 터미널로 찍어봤을때 서버바인딩시 저렇게 뜬것 가져와서 사용한것임
    private static final int SERVER_PORT=5000;
    //static 즉 객체마다 값이 바뀌는 것이 아닌 클래스에 존재하는 상수이므로 선언과 동시에 초기화를 해 주어야하는 클래스 상수이다.
    public static void main(String[] args)  {
        Socket socket=null;

        try{
            //서버연결을 위한 소켓생성
            socket=new Socket();

            //생성한소켓을 서버의소켓과 연결
            socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT)); //InetSocketAddress로 아이피와 포트 받아서연결
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

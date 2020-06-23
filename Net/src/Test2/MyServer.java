package Test2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MyServer
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Chess> arrayChess = new ArrayList<>();
        // TODO Auto-generated method stub
        //建立服务器，服务于2019端口
        ServerSocket serverSock = new ServerSocket(2019);
        System.out.println("服务器启动，等待连接...");
        Large:
        do {
            //监听请求，阻塞等待，直到有客户端发起连接...
            Socket conn = serverSock.accept();
            //从连接里得到输入输出流
            //InputStream:可以读取客户端发来的数据
            //OutputStream:可以发送数据给客户端
            InputStream inputStream = conn.getInputStream();
            OutputStream outputStream = conn.getOutputStream();
            //接收数据
            byte[] inputData = new byte[1000];
            int n = inputStream.read(inputData);
            if (n <= 0) {
                conn.close();
                continue;
            }
            //发送数据
            String inputMsg = new String(inputData, 0, n, StandardCharsets.UTF_8);
            System.out.println("GOT:" + inputMsg);
            //将接受到的数据转换为学生对象
            JSONObject obj = null;
            try {
                obj = new JSONObject(inputMsg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Chess chess = new Chess();
            chess.setX(obj.optInt("X",0));
            chess.setY(obj.optInt("Y",0));
//            for(int i = 0;i < arrayChess.size();i++){
//                if(arrayChess.get(i).getX() == chess.getX()&&arrayChess.get(i).getY() == chess.getY()) {
//                    String tmp = "";
//                    outputStream.write(tmp.getBytes());
//                    conn.close();
//                    continue Large;
//                }
//            }
//            arrayChess.add(chess);
            System.out.println("棋子:" + chess.toString());
            String outputMsg = "Welcome!";
            byte[] ouputData = outputMsg.getBytes();
            outputStream.write(ouputData);
            System.out.println("ECHO:" + outputMsg + "\n");
            //关闭连接
            conn.close();
        } while (true);

    }


}

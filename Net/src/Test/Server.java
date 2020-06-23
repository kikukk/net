package Test;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        //建立服务器，服务于2019端口
        ServerSocket serverSock = new ServerSocket(2019);
        System.out.println("服务器启动，等待连接...");
        do {
            //监听请求，阻塞等待，直到有客户端发起连接...
            Socket conn = serverSock.accept();

            //从连接里得到输入输出流
            //InputStream:可以读取客户端发来的数据
            //OutputStream:可以发送数据给客户端
            InputStream inputStream = conn.getInputStream();
            OutputStream outputStream = conn.getOutputStream();

            //接收数据
            byte[] inputData = new byte[4000];
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
//            Student stu = new Student();
//            stu.setId(obj.optInt("id", 0));
//            stu.setName(obj.optString("name", ""));
//            stu.setSex(obj.optBoolean("sex", true));
//            stu.setCellPhone(obj.optString("cellPhone", ""));
//            System.out.println("学生:" + stu.toString());
//            String outputMsg = "Welcome!";
//            byte[] ouputData = outputMsg.getBytes();
//            outputStream.write(ouputData);
//            System.out.println("ECHO:" + outputMsg + "\n");

            //关闭连接
            conn.close();
        } while (true);

    }


}

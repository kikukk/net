package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client1
{
    public static void main(String[] args) throws IOException
    {
        //一个Scoket代表一路连接
        Socket sock = new Socket();
        //连接至服务器
        sock.connect(new InetSocketAddress("127.0.0.1" , 2019));
        //InputStream用于接收数据，OutputStreet用于发送数据
        InputStream inputStream = sock.getInputStream();
        OutputStream outputStream = sock.getOutputStream();

        //发送数据
        //创建一个学生对象


        String outputMsg = null;// "Hello";
//        try {
//            outputMsg = json.toString(2);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        byte[] outputData = outputMsg.getBytes(StandardCharsets.UTF_8);
        outputStream.write(outputData);
        System.out.println(">>" + outputMsg);

        //接收数据
        byte[] inputData = new byte[4000];
        int n = inputStream.read(inputData);
        String inputMsg = new String(inputData , 0 , n , StandardCharsets.UTF_8);
        System.out.println("<<" + inputMsg);

        //关闭连接
        sock.close();
    }
}

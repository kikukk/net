package Test2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyClient
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        //一个Scoket代表一路连接
        Socket sock = new Socket();
        //连接至服务器
        sock.connect(new InetSocketAddress("127.0.0.1" , 2019));
        //InputStream用于接收数据，OutputStreet用于发送数据
        InputStream inputStream = sock.getInputStream();
        OutputStream outputStream = sock.getOutputStream();
        //发送数据
        //创建一个棋子对象
        //Student stu = new Student(2018001 , "小明" , true , "18825030000");
        System.out.println("输入棋子横坐标:");
        int x = scanner.nextInt();
        System.out.println("输入棋子纵坐标：");
        int y = scanner.nextInt();
        Chess chess = new Chess(x,y);
        JSONObject json = new JSONObject(chess);
        String outputMsg = null;// "Hello";
        try {
            outputMsg = json.toString(2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        byte[] outputData = outputMsg.getBytes(StandardCharsets.UTF_8);
        outputStream.write(outputData);
        System.out.println(">>" + outputMsg);
        //接收数据
        byte[] inputData = new byte[4000];
        int n = inputStream.read(inputData);
//        if(n == 0){
//            System.out.println("棋子重复！");
//            sock.close();
//            return;
//        }
        String inputMsg = new String(inputData , 0 , n , StandardCharsets.UTF_8);
        System.out.println("<<" + inputMsg);
        //关闭连接
        sock.close();
    }
}

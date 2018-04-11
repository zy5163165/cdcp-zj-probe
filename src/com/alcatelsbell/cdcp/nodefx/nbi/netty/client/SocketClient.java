package com.alcatelsbell.cdcp.nodefx.nbi.netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/26
 * Time: 9:21
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class SocketClient {
    private Logger logger = LoggerFactory.getLogger(SocketClient.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("\n\r".getBytes().length);
        String port = "8017";
        if (args != null && args.length > 0) {
            port = args[0];
        }
        String json = "[{\n" +
                "   \"message_header\": {\n" +
                "   \"message_id\": \"request123456\",\n" +
                "   \"client_id\":\"client123\",\n" +
                "   \"message_type\":\"command\"" +
                "   },\n" +
                " \"message_body\": {\n" +
                "              \"request\":{\n" +
                "                     \"username\":\"asbuser\",\n" +
                "                     \"password\":\"abcd1234\",\n" +
                "                      \"requestType\":\"alarm\",\n" +
                "                      \"ems\":[]\n" +
                "               }\n" +
                "   }\n" +
                "}]";
        System.out.println("json = " + json);
        System.out.println("port = " + port);
        Socket socket = new Socket("127.0.0.1",Integer.parseInt(port));
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        new InThread(inputStream).start();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] delimiter = {-1,-1,-1,-1};
        for (int i = 0; i < 3; i++) {

           // Integer.toHexString()

            dataOutputStream.write(delimiter);
            byte[] content = (json).getBytes();
            dataOutputStream.writeInt((content.length+8));
            dataOutputStream.write(content);
            dataOutputStream.write(new byte[]{10,10,13,13});


        }
  //      dataOutputStream.write(delimiter);
        outputStream.flush();

        synchronized (SocketClient.class) {
            SocketClient.class.wait();
        }
        socket.close();

    }

    private static class InThread  extends Thread{
        private InputStream inputStream = null;
        private DataInputStream reader = null;
        public InThread(InputStream inputStream) {
            this.inputStream = inputStream;
            reader = new DataInputStream(inputStream);
        }
        public void run() {
            while (true) {
                try {
                    int i = reader.readInt();
                    int length = reader.readInt();
                    System.out.println("read message : length = " + length);
                    byte[] content = new byte[length-8];
                    reader.read(content);
                    reader.readInt();
                    System.out.println("content = " + new String(content,"utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;

                }
            }
        }
    }
}

package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/26
 * Time: 11:48
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NbiMessage implements Serializable{
    private static  ObjectMapper objectMapper = new ObjectMapper();
    private HashMap  dataMap = new HashMap<String, Object>();

    public static final String HEADER  = "message_header";
    public static final String HEADER_MESSAGE_TYPE = "message_type";
    public static final String HEADER_MESSAGE_ID = "message_id";
    public static final String HEADER_CLIENT_ID = "client_id";

    public static final String BODY = "message_body";

    private String message_id;
    private String message_type;
    private String client_id;

    public String getMessage_id() {
        return message_id;
    }

    public String getMessage_type() {
        return message_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public NbiMessage(String message_id, String message_type, String client_id) {
        this.message_id = message_id;
        this.message_type = message_type;
        this.client_id = client_id;

        HashMap<String,String> headerMap = new HashMap<String, String>();
        HashMap bodyMap = new HashMap();
        dataMap.put(HEADER,headerMap);
        dataMap.put(BODY,bodyMap);

        headerMap.put(HEADER_MESSAGE_ID,message_id);
        headerMap.put(HEADER_MESSAGE_TYPE,message_type);
        headerMap.put(HEADER_CLIENT_ID,client_id);





    }

    public HashMap getBody() {
        return (HashMap)dataMap.get(BODY);
    }





    public byte[] toJsonBytes() throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        List l = new ArrayList();
        l.add(dataMap);
        objectMapper.writeValue(bao,l);
        byte[] bs =  bao.toByteArray();
        bao.close();
        return bs;
    }

    public static NbiMessage parse(byte[] json) throws IOException {
        List<HashMap> list = objectMapper.readValue(json,List.class);
        HashMap map = list.get(0);
        HashMap<String,String> header = (HashMap)map.get(HEADER);
        NbiMessage message = new NbiMessage(header == null ? null : header.get(HEADER_MESSAGE_ID),
                header == null ? null : header.get(HEADER_MESSAGE_TYPE),
                header == null ? null : header.get(HEADER_CLIENT_ID)
                );
        message.dataMap = map;
        return message;
    }

    public HashMap getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public String toString() {
        return "NbiMessage{" +
                "dataMap=" + dataMap +
                ", message_id='" + message_id + '\'' +
                ", message_type='" + message_type + '\'' +
                ", client_id='" + client_id + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        String json = "[{\n" +
                "   \"message_header\": {\n" +
                "   \"message_id\": \"request123456\",\n" +
                "   \"client_id\":\"client123\",\n" +
                "   \"message_type\":\"alarm\"      \n" +
                "   },\n" +
                "   \"message_body\": {\n" +
                "              \"key\":\"StartAlarm\"\n" +
                "   }\n" +
                "}]";
        System.out.println("json = " + json);
        List list = objectMapper.readValue(json, List.class);
        System.out.println("list = " + list);
    }
}

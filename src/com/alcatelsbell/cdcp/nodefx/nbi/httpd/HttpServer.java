package com.alcatelsbell.cdcp.nodefx.nbi.httpd;

import com.alcatelsbell.cdcp.nodefx.CorbaEms;
import com.alcatelsbell.cdcp.nodefx.CorbaEmsAdapterTemplate;
import com.alcatelsbell.cdcp.nodefx.KeepAliveConnection;
import com.alcatelsbell.cdcp.nodefx.KeepAliveConnectionsManager;
import com.alcatelsbell.cdcp.nodefx.httpd.HttpRequestHandler;
import com.alcatelsbell.cdcp.nodefx.httpd.NanoHTTPd;
import static com.alcatelsbell.cdcp.nodefx.httpd.NanoHTTPd.HTTP_OK;

import com.alcatelsbell.nms.util.protocol.IcmpPing;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.tools.ant.util.regexp.RegexpUtil;
import org.asb.mule.probe.framework.service.CorbaSbiService;
import org.asb.mule.probe.framework.service.NbiService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Ronnie.Chen
 * Date: 2016/9/29
 * Time: 8:41
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class HttpServer implements HttpRequestHandler{
    private Logger logger = LoggerFactory.getLogger(HttpServer.class);

    private List<CorbaEmsAdapterTemplate> adapters = null;
    private int port = 9090;

    public HttpServer(List<CorbaEmsAdapterTemplate> adapters, int port) {
        this.adapters = adapters;
        this.port = port;
    }

    private NanoHTTPd httpD = null;
    public void start() throws IOException {
        httpD = new NanoHTTPd(port);
        httpD.setHttpRequestHandler(this);

    }

    private ObjectMapper objectMapper = new ObjectMapper();
    private String toJson(Object value) throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        objectMapper.writeValue(bao,value);
        return new String(bao.toByteArray(),"utf-8");
    }

    @Override
    public NanoHTTPd.Response handle(String method, String uri, Properties header, Properties parms, Properties files) {
        System.out.println("uri = " + uri);
        System.out.println("method = " + method);
        NanoHTTPd.Response response = null;


        if (uri.equals("/cdcp/nbi/restful/list")) {
            response = listEms();
            return response;
        }

        Method[] methods = HttpServer.class.getMethods();
        for (Method method1 : methods) {
            RequestMapper mapper = method1.getAnnotation(RequestMapper.class);
            if (mapper != null) {
                Pattern pattern = Pattern.compile(mapper.urlRegex());
                Matcher matcher = pattern.matcher(uri);
                if (matcher.find()) {
                    String emsname = matcher.group(0);
                    logger.info("mapper method : "+method1.getName());
                    try {
                        response = (NanoHTTPd.Response)method1.invoke(this,emsname,method,uri,header,parms,files);
                    } catch ( Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                    return response;

                }

            }
        }



        return response;
    }


    private NanoHTTPd.Response listEms() {
        String json = "[\n" +
                "  \"response\" : \n" +
                "        [\n";
        for (CorbaEmsAdapterTemplate adapter : adapters) {
            Hashtable<String, Ems> emsTable = adapter.getEmsTable();
            KeepAliveConnectionsManager keepAliveConnectionsManager = adapter.getConnectionManager();
            for (String emsName : emsTable.keySet()) {
                Ems ems = emsTable.get(emsName);
                String name = ems.getName();
                CorbaEms corbaEms = new CorbaEms(ems);
                KeepAliveConnection connection = keepAliveConnectionsManager.getConnection(name);
                if (connection != null && connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {
                    NbiService nbiService = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService();
                    boolean connectState = nbiService.getConnectState();
                    String emsdn = nbiService.getEmsName();

                    try {
                        Method getCorbaService = nbiService.getClass().getMethod("getCorbaService");
                        if (getCorbaService != null) {
                            CorbaSbiService sbiService = (CorbaSbiService)getCorbaService.invoke(nbiService);
                            emsdn = sbiService.getEmsDn();
                        }
                    } catch ( Exception e) {
                        logger.error(e.getMessage(), e);
                    }

                    String ems_json = "{\n" +
                            "         \"ems\" : \""+emsName+"\",\n" +
                            "         \"emsVendorName\" : \""+emsdn+"\",\n" +
                            "         \"address\":\""+corbaEms.getCorbaUrl()+"\",\n" +
                            "         \"username\":\""+corbaEms.getCorbaUserName()+"\",\n" +
                            "         \"password\":\""+corbaEms.getCorbaPassword()+"\",\n" +
                            "         \"status\":\""+ (connectState ? "connected" : "disconnected") + "\",\n" +
                            "         \"info\":\"\"\n" +
                            "\n" +
                            "        },\n";

                    json+=ems_json+",";
                }




            }

        }
        if (json.endsWith(","))
            json = json.substring(0,json.length()-1);
        json += "]\n" +
                "}\n";
        return  httpD.new Response(HTTP_OK,"application/json",json);
    }

    private Ems getEms(String emsname) {
        for (CorbaEmsAdapterTemplate adapter : adapters) {
            Ems ems = adapter.getEmsTable().get(emsname);
            if (ems != null) return ems;
        }
        return null;
    }

    private KeepAliveConnection getConnection(String emsname) {
        for (CorbaEmsAdapterTemplate adapter : adapters) {
            KeepAliveConnectionsManager keepAliveConnectionsManager = adapter.getConnectionManager();
            KeepAliveConnection connection = keepAliveConnectionsManager.getConnection(emsname);
            if (connection != null) return connection;
        }
        return null;
    }


    @RequestMapper(urlRegex="(?<=/cdcp/nbi/restful/ems/).*?(?=/status)")
    public NanoHTTPd.Response handleEmsStatus(String emsname,String method, String uri, Properties header, Properties parms, Properties files) {

        boolean connectState = false;
        Ems ems = getEms(emsname);
        String txt = null;
        if (ems != null) {
            CorbaEms corbaEms = new CorbaEms(ems);
            KeepAliveConnection connection = getConnection(emsname);
            if (connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {
                connectState = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService().getConnectState();
            }
             txt = "[{\n" +
                    "  \"response\": \n" +
                    "        {\n" +
                    "         \"ems\": \"" + emsname + "\",\n" +
                    "         \"address\":\"" + corbaEms.getCorbaUrl() + "\",\n" +
                    "         \"username\":\"" + corbaEms.getCorbaUserName() + "\",\n" +
                    "         \"password\":\"" + corbaEms.getCorbaPassword() + "\",\n" +
                    "         \"status\":\"" + (connectState ? "connected" : "disconnected") + "\",\n" +
                    "         \"info\":\"\"\n" +
                    "        }\n" +
                    "}]\n";
        } else {
            txt = getEmsNotExistedJson();
        }

        return   httpD.new Response(HTTP_OK,"application/json",txt);
    }

    @RequestMapper(urlRegex="(?<=/cdcp/nbi/restful/ems/).*?(?=/connect)")
    public NanoHTTPd.Response handleEmsConnect(String emsname,String method, String uri, Properties header, Properties parms, Properties files) {

        boolean connectState = false;
        Ems ems = getEms(emsname);
        String txt = null;
        if (ems != null) {
            CorbaEms corbaEms = new CorbaEms(ems);
            KeepAliveConnection connection = getConnection(emsname);
            if (connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {

                connectState = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService().getConnectState();
                if (!connectState)
                    connectState = connection.connect();
            }
            txt = "[{\n" +
                    "  \"response\": \n" +
                    "        {\n" +
                    "         \"ems\": \"" + emsname + "\",\n" +
                    "         \"address\":\"" + corbaEms.getCorbaUrl() + "\",\n" +
                    "         \"username\":\"" + corbaEms.getCorbaUserName() + "\",\n" +
                    "         \"password\":\"" + corbaEms.getCorbaPassword() + "\",\n" +
                    "         \"status\":\"" + (connectState ? "connected" : "disconnected") + "\",\n" +
                    "         \"info\":\"\"\n" +
                    "        }\n" +
                    "}]\n";
        } else {
            txt = getEmsNotExistedJson();
        }

        return   httpD.new Response(HTTP_OK,"application/json",txt);
    }


    @RequestMapper(urlRegex="(?<=/cdcp/nbi/restful/ems/).*?(?=/disconnect)")
    public NanoHTTPd.Response handleEmsDisconnect(String emsname,String method, String uri, Properties header, Properties parms, Properties files) {
        boolean connectState = false;
        Ems ems =  getEms(emsname);
        String txt = null;
        if (ems != null) {
            CorbaEms corbaEms = new CorbaEms(ems);
            KeepAliveConnection connection = getConnection(emsname);
            if (connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {

                connectState = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService().getConnectState();
                if (connectState)
                    connection.disconnect();
            }
            txt = "[{\n" +
                    "  \"response\": \n" +
                    "        {\n" +
                    "         \"ems\": \"" + emsname + "\",\n" +
                    "         \"address\":\"" + corbaEms.getCorbaUrl() + "\",\n" +
                    "         \"username\":\"" + corbaEms.getCorbaUserName() + "\",\n" +
                    "         \"password\":\"" + corbaEms.getCorbaPassword() + "\",\n" +
                    "         \"status\":\"" + (((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService().getConnectState() ? "connected" : "disconnected") + "\",\n" +
                    "         \"info\":\"\"\n" +
                    "        }\n" +
                    "}]\n";
        } else {
            txt = getEmsNotExistedJson();
        }

        return   httpD.new Response(HTTP_OK,"application/json",txt);
    }

    @RequestMapper(urlRegex="(?<=/cdcp/nbi/restful/ems/).*?(?=/icmp)")
    public NanoHTTPd.Response handleEmsIcmp(String emsname,String method, String uri, Properties header, Properties parms, Properties files) {
        Ems ems = getEms(emsname);
        String txt = null;
        if (ems != null) {
            CorbaEms corbaEms = new CorbaEms(ems);
            String corbaUrl = corbaEms.getCorbaUrl();
            String ipAddress = extractIpAddress(corbaUrl);
            boolean result = false;
            if (ipAddress != null) {
                IcmpPing ping = new IcmpPing(ipAddress);
                result = ping.ping();
                txt = "[{\n" +
                        "  \"response\": \n" +
                        "        {\n" +
                        "         \"ems\": \"" + emsname + "\",\n" +
                        "         \"address\":\"" + corbaEms.getCorbaUrl() + "\",\n" +
                        "         \"reachable\":\"" + (result ? "yes":"no") + "\",\n" +

                        "         \"info\":\""+ping.getOutput()+"\"\n" +
                        "        }\n" +
                        "}]\n";
            } else {
                txt = "[{\n" +
                        "  \"response\": \n" +
                        "        {\n" +
                        "         \"ems\": \"" + emsname + "\",\n" +
                        "         \"address\":\"" + corbaEms.getCorbaUrl() + "\",\n" +
                        "         \"reachable\":\"" + ("no") + "\",\n" +

                        "         \"info\":\" ipaddress unknown! \"\n" +
                        "        }\n" +
                        "}]\n";
            }



        } else {
            txt = getEmsNotExistedJson();
        }

        return   httpD.new Response(HTTP_OK,"application/json",txt);
    }



    private String getEmsNotExistedJson() {
          return "[{\n" +
                  "  \"response\": \n" +
                  "        {\n" +
                  "         \"ems\": \"" + "" + "\",\n" +
                  "         \"address\":\"" + "" + "\",\n" +
                  "         \"username\":\"" + "" + "\",\n" +
                  "         \"password\":\"" + "" + "\",\n" +
                  "         \"status\":\"" + ("exception") + "\",\n" +
                  "         \"info\":\"EMS not existed !\"\n" +
                  "        }\n" +
                  "}]\n";
    }

    private String extractIpAddress(String txt) {
        String regex = "\\b(?:(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        if (matcher.find()) {
            String group = matcher.group(0);
            return group;
        }
        return null;
    }

    public static void main(String[] args) throws IOException, InterruptedException {




        new HttpServer(null,9090).start();
        synchronized (HttpServer.class) {
            HttpServer.class.wait();
        }
    }
}

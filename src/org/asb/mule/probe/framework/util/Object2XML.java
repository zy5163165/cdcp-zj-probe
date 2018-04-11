package org.asb.mule.probe.framework.util;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-1
 * Time: 下午1:10
 * rongrong.chen@alcatel-sbell.com.cn
 */

import com.alcatelsbell.nms.common.CommonUtil;
import org.asb.mule.probe.framework.entity.ManagedElement;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.Element;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Date;
import java.util.List;

public class Object2XML {

    public Object2XML() {
    }

    private static String getId(Object obj) {
        try {
            Object getId = obj.getClass().getMethod("getId").invoke(obj);

            return getId == null ? "": getId.toString();
        } catch (SecurityException ex) {
            return "";
        } catch (NoSuchMethodException ex) {
            return "";
        } catch (InvocationTargetException ex) {
            return "";
        } catch (IllegalArgumentException ex) {
            return "";
        } catch (IllegalAccessException ex) {
            return "";
        }

    }

    private static String getName(Object obj) {
        try {
            Object name = obj.getClass().getMethod("getName").invoke(obj);
            return name == null ? "" : name.toString();
        } catch (SecurityException ex) {
            return "";
        } catch (NoSuchMethodException ex) {
            return "";
        } catch (InvocationTargetException ex) {
            return "";
        } catch (IllegalArgumentException ex) {
            return "";
        } catch (IllegalAccessException ex) {
            return "";
        }

    }

    public static void toXmlFile(Object obj, String fileName) {

        XMLOutputter opt = new XMLOutputter();
        try {
            FileOutputStream out = new FileOutputStream(fileName);
            opt.output(toDocument(obj), out);
            out.close();
        } catch (IOException ex) {
        }

    }

    public static Document toDocument(Object obj) {
        String clsSimpleName = obj.getClass().getName();
        Document doc = new Document();
        Element root = new Element(clsSimpleName);
        doc.setRootElement(root);

        String id = getId(obj);
        String name = getName(obj);
        root.setAttribute("id", id);
        root.setAttribute("name", name);

        if (obj instanceof Collection) {
            for (Object o : (Collection) obj) {
                Element oele = new Element(o.getClass().getName());
                String oid = getId(o);
                String oname = getName(o);
                oele.setAttribute("id", oid);
                oele.setAttribute("name", oname);
                root.addContent(oele);
                processObject(oele, o);
            }
        } else {
            processObject(root, obj);
        }

        return doc;

    }

    public static String toXml(Object obj) {
        XMLOutputter opt = new XMLOutputter();
        return opt.outputString(toDocument(obj));
    }



    private static void processObject(Element parent, Object obj) {
        Method[] methods = obj.getClass().getMethods();
        if (methods != null) {
            for (Method method : methods) {
                String mName = method.getName();
                Object value = null;
                if (mName.startsWith("get")) {
                    try {
                        value = method.invoke(obj);
                    } catch (Exception ex) {
                    }
                }
                if (value != null) {
                    String attribute = mName.substring(3);
                    attribute = attribute.substring(0, 1).toLowerCase()
                            + attribute.substring(1);
                    appendObjectAttribute(parent, attribute, value);
                }

            }
        }

    }

    private static void appendObjectAttribute(Element parent,
                                              String attributeName,
                                              Object value) {
        if (!(value instanceof Collection)) {
            if (value instanceof Date)
                value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
            appendElement(parent, attributeName, value.toString());
        } else {
            Collection col = (Collection) value;
            Element ele = new Element(attributeName);
            parent.addContent(ele);
            for (Object obj : col) {
                String id = getId(obj);
                String name = getName(obj);
                Element objElement = new Element(obj.getClass().getName());
                objElement.setAttribute("id", id);
                objElement.setAttribute("name", name);
                ele.addContent(objElement);
                processObject(objElement, obj);

            }
        }

    }

    private static Element appendElement(Element parent, String name,
                                         String text) {
        Element c1 = new Element(name);
        if (text != null) {
            c1.setText(text);
        }
        parent.addContent(c1);
        return c1;
    }

    public static Object toObject(File xmlFile) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document xmlDoc = builder.build(xmlFile);
        Element element = xmlDoc.getRootElement();

        return parseElement(element);
    }

    private static Object parseElement(Element element) throws Exception {
        String name = element.getName();
        Class cls = Class.forName(name);
        Object object = cls.newInstance();
        if (object instanceof Collection) {
            List<Element> children = element.getChildren();
            for (int i = 0; i < children.size(); i++) {
                Element element1 = children.get(i);
                ((Collection) object).add(parseElement(element1));
            }
        } else {
            List<Element> children = element.getChildren();
            for (int i = 0; i < children.size(); i++) {
                Element element1 = children.get(i);
                String name1 = element1.getName();
                String text = element1.getText();
                Field field = cls.getField(name1);
                Class type = field.getType();
                if (type.equals(String.class) ) {
                    CommonUtil.getInstance().setFiledValue(object,field,text);
                } else if (type.equals(Long.class) || type.equals(Long.TYPE)) {
                    CommonUtil.getInstance().setFiledValue(object,field,Long.parseLong(text));
                }  else if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
                    CommonUtil.getInstance().setFiledValue(object,field,Integer.parseInt(text));
                }else if (type.equals(Float.class) || type.equals(Float.TYPE)) {
                    CommonUtil.getInstance().setFiledValue(object,field,Float.parseFloat(text));
                }else if (type.equals(Byte.class) || type.equals(Byte.TYPE)) {
                    CommonUtil.getInstance().setFiledValue(object,field,Byte.parseByte(text));
                } else if (type.equals(Date.class)) {
                    CommonUtil.getInstance().setFiledValue(object,field,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(text));
                }  else {
                    System.err.println("!!!! unknown type = " + type);
                }
            }
        }
        return object;
    }


    public static void main(String[] args) throws Exception {
        ManagedElement me = new ManagedElement();
        List list = new ArrayList();
        list.add(me);
        Object2XML.toXmlFile(list,"bbb.xml");

        Object o = Object2XML.toObject(new File("bbb.xml"));
        System.out.println(o);

    }
}

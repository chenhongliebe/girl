package com.liebe.WeiXin;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/3.
 */
public class XmlUtil {

    /**
     * xml转为map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException,DocumentException{
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream inputStream = request.getInputStream();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> list = root.elements();
        for(Element e : list){
            map.put(e.getName(),e.getText());
        }
        inputStream.close();
        return map;
    }

    public static  String textMessageToXml(TextMessage textMessage){
        XStream xStream = new XStream();
        return xStream.toXML(textMessage);
    }

}

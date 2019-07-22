package com.baiwang.cloud.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 11:19
 */
public class JaxbUtil {

    /**
     * xml转java对象
     * @param xml
     * @param clazz
     * @param <T>
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, Class<T> clazz) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xml));
    }

    /**
     * java对象转换为xml
     * @param object
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public static String beanToXml(Object object) throws JAXBException, IOException {
        return beanToXml(object, "UTF-8");
    }

    /**
     * java对象转换为xml
     * @param object
     * @param charset
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public static String beanToXml(Object object, String charset) throws JAXBException, IOException {
        return beanToXml(object, object.getClass(), charset);
    }

    /**
     * java对象转换为xml
     * @param object
     * @param clazz
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public static String beanToXml(Object object, Class<?> clazz) throws JAXBException, IOException {
        return beanToXml(object, clazz, "UTF-8");
    }

    /**
     * java对象转换为xml
     * @param object
     * @param clazz
     * @return
     * @throws JAXBException
     */
    public static String beanToXml(Object object, Class<?> clazz, String charset) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, charset);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        String xml = writer.toString();
        writer.close();
        return "<?xml version=\"1.0\" encoding=\"" + charset + "\"?>\n" + xml;
    }

}

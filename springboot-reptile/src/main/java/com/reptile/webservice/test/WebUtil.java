package com.reptile.webservice.test;

/**
 * @className: WebUtil
 * @description: TODO 类描述
 *
 * @date: 2022/10/20
 **/
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class WebUtil {
    public static final String url = "http://ecardthird-k12.newcapec.cn/WebService81/Newcapec.eCard.ProxyWebService.asmx";
//    public static final String url = "http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx";
    public static void main(String[] args){
        Object[] params = new Object[]{"3rutTaGEsyZ0KVFz08",18};
//        String result = sendWebservice(params,url);
//        String result = test(url,"qqCheckOnline","1826869334");
        String result = test(url,"HelloWorld","33");
        System.out.println(result);
    }



    public static String test(String Url, String methodName, String str) {
        String ref = null;
        // webService链接地址
        String url = Url;
        //获取域名地址，server定义的
//        String soapaction = "http://WebXml.com.cn/";
        String soapaction = "http://NewCap.com/NewCapecWebService/";

        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            // 设置要调用哪个方法
            call.setOperationName(new QName(soapaction, methodName));
            // 设置要传递的参数名
//            call.addParameter(new QName(soapaction,"qqCode"),org.apache.axis.encoding.XMLType.XSD_STRING,
//                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction,"appId"), XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            // 提供标准类型 有addParameter就必须有setReturnType
//            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            call.setReturnType(XMLType.XSD_STRING);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + methodName);
            // 调用方法并传递参数
            ref = (String) call.invoke(new Object[]{str});
            return ref;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ref;
    }
}


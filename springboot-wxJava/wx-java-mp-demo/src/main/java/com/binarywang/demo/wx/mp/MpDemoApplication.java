package com.binarywang.demo.wx.mp;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.digester.Digester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author binary wang
 */
@RestController
@RequestMapping("/")
@SpringBootApplication
public class MpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpDemoApplication.class, args);
    }

    @Autowired
    private WxMpService mpService;

    @GetMapping("/test")
    public String test() throws WxErrorException {
        // this.mpService.getWxMpConfigStorage().getAppId();
        return  this.mpService.getAccessToken();
    }
    @ResponseBody
    @RequestMapping(value = "/wxServerValdation")
    public String wxServerValdation(String signature, String timestamp, String nonce, String echostr){
//        if (DataUtil.isEmpty(signature)|| DataUtil.isEmpty(timestamp) || DataUtil.isEmpty(nonce) || DataUtil.isEmpty(echostr)){
//            return "";
//        }
        ArrayList<String> list=new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add("test");//这是第5步中你设置的Token
        Collections.sort(list);
        String sha1Singnature = DigestUtils.sha1Hex(list.get(0)+list.get(1)+list.get(2));
        if (sha1Singnature.equals(signature)){
            return echostr;
        }else {
            return "";
        }

    }

    /**
     * 恒定配置接口：get类型用以响应微信发送的Token验证，启用微信相关功能
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   验签成功后的返回值
     * @return 返回值
     */
    @GetMapping("/auth")
    public String sayHi(String signature, String timestamp, String nonce, String echostr) {
        String token = "gbx";
        System.out.println();
        return null;
    }
}

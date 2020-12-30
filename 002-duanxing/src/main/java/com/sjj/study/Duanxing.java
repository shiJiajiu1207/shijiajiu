package com.sjj.study;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/08/13 15:30
 */
@Slf4j
@Controller
public class Duanxing {

    @RequestMapping("/duanxing")
    @ResponseBody
    public String duanxing(@RequestParam(value = "mobile") String mobile
    ){
        log.info("短信入参,{}",mobile);
        String appkey = "00961f7a6ca95f769d27a6a87a3b19f8";
        String duanxing = "【凯信通】您的验证码是：131400";
        String uri = "https://way.jd.com/kaixintong/kaixintong?mobile="+mobile+"&content="+duanxing+"&appkey="+appkey;
        log.info(uri);
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse httpResponse = null ;
        String result = "结果：";
        try {
            httpResponse = client.execute(httpGet);
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                if (httpResponse.getEntity() != null) {
                    result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                    log.info(result);
                    return result;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("结束,{}",result);
        return result;
    }
}

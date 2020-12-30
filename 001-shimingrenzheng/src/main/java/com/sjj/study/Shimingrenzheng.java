package com.sjj.study;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
 * @Date: 2020/08/13 14:59
 */
@Slf4j
@Controller
public class Shimingrenzheng {

    @RequestMapping("/shiming")
    @ResponseBody
    public String shiming(@RequestParam(value = "id") String id,
                        @RequestParam(value = "name") String name
    ){
        log.info("实名认证入参,{},{}",id,name);
        String appkey = "dae28bc07419cd6e4cbcbfeaf407661d";
        String uri = "https://way.jd.com/yingyan/idcard?cardno="+id+"&name="+name+"&appkey="+appkey;

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

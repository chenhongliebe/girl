package com.liebe;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/3.
 */
@Slf4j
public class HttpClientUtil {

    public static String doGet(String url) throws IOException{
        CloseableHttpClient client =HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response =null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(response.getStatusLine().getStatusCode() ==200){
                return EntityUtils.toString(entity,"utf-8");
            }
        }finally {
            response.close();
        }
        return null;
    }

    public static String doPost(String url,String str) throws IOException{
        CloseableHttpClient client =HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(str);
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response =null;
        try {
            response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(response.getStatusLine().getStatusCode() ==200){
                return EntityUtils.toString(entity,"utf-8");
            }
        }catch (Exception e){
            log.error("请求异常，请求地址：{}",url,e);
        }finally {
            response.close();
        }
        return null;
    }



}

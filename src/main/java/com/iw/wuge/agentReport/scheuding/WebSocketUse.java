package com.iw.wuge.agentReport.scheuding;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;

@RestController
public class WebSocketUse {

    @Autowired
    private SimpMessagingTemplate template;

    public static void main(String[] args) {
        //template.convertAndSend("/topic/collectionMessage",message);
        WebSocketUse webSocketUse = new WebSocketUse();
       // webSocketUse.get();
        String result = webSocketUse.get("http://www.baidu.com/", null , "{'wd':'测试'}", 20000, 20000);
        System.out.println(result);
    }

    /**
     * 发送 get请求
     */
    public String get(String url, Map<String, String> headers, String jsonParam, int connectTimeout, int readTimeout) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://www.baidu.com/");
            System.out.println("executing request " + httpget.getURI());

            StringEntity postentity = new StringEntity(JSONObject.parse(jsonParam).toString(), "utf-8");
            postentity.setContentType("application/json");
//            httpget.setEntity(postentity);
//            httpget.s
            if (null != headers) {
                httpget.setHeader("Content-Type", headers.get("Content-Type"));
            }
            httpget.setHeader("Accept", "application/json");
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(readTimeout)
                    .setConnectTimeout(connectTimeout)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            httpget.setConfig(requestConfig);

            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    return EntityUtils.toString(entity);
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String post(String url, Map<String, String> headers, String jsonParam, int connectTimeout, int readTimeout) {
        CloseableHttpClient httpclient = null;
        HttpPost httppost = new HttpPost(url);
        try {
//            httpclient = HttpClients.createDefault();
            httpclient = new DefaultHttpClient();
            HttpClientParams.setCookiePolicy(httpclient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);

            StringEntity postentity = new StringEntity(JSONObject.parse(jsonParam).toString(), "utf-8");
            postentity.setContentType("application/json");
            httppost.setEntity(postentity);
            if (null != headers)
                httppost.setHeader("Content-Type", headers.get("Content-Type"));
            httppost.setHeader("Accept", "application/json");
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(readTimeout)
                    .setConnectTimeout(connectTimeout)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            httppost.setConfig(requestConfig);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            } catch (Exception e) {
                for (int i = 0; i < 2; i++) {
                    try {
                        response = httpclient.execute(httppost);
                        break;
                    } catch (Exception e2) {
                        if (i == 1) {
                            throw e2;
                        } else {
                            continue;
                        }
                    }
                }
            }

            try {
                if (response == null) {
                    return "";
                } else {
                    if (response.getStatusLine().getStatusCode() >= 400) {
                    }
                }
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } finally {

            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httppost != null) {
                httppost.releaseConnection();
            }
        }
        return "";
    }
}

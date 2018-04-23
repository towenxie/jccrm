/**
 * @ProjectName b2b-data-common
 * @FileName SMSAPI.java
 * @PackageName com.xe.b2b.data.common
 * @Date 2017年1月10日下午10:25:35
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.xe.b2b.data.common.contants.SystemConstant;

/**
 * @ClassName SMSAPI 
 * @Description TODO
 * @Date     2017年1月10日 下午10:25:35
 * @author   towen
 * @version  v1.0	 
 */
public class HttpUtils {

/**
* 基于HttpClient 4.3的通用POST方法
*
* @param url       提交的URL
* @param paramsMap 提交<参数，值>Map
* @return 提交响应
*/

public static String post(String url, Map<String, String> paramsMap) {
    CloseableHttpClient client = HttpClients.createDefault();
    String responseText = "";
    CloseableHttpResponse response = null;
    try {
        HttpPost method = new HttpPost(url);
        if (paramsMap != null) {
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                paramList.add(pair);
            }
            method.setEntity(new UrlEncodedFormEntity(paramList, SystemConstant.ENCODING));
        }
        response = client.execute(method);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            responseText = EntityUtils.toString(entity);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        return responseText;
    }

}


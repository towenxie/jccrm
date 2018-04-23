/**
 * @ProjectName b2b-data-common
 * @FileName HttpCode.java
 * @PackageName com.xe.b2b.data.common.contants
 * @Date 2016年12月15日下午8:02:20
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.common.contants;

/**
 * @ClassName HttpCode
 * @Description TODO
 * @Date 2016年12月15日 下午8:02:20
 * @author towen
 * @version v1.0
 */
public class HttpCode {
    public static final String HTTP_CODE_KEY = "code";
    public static final String HTTP_MSG_KEY = "msg";
    public static final String HTTP_DATA_KEY = "data";

    public static final int HTTP_CODE_200 = 200;
    public static final String HTTP_MSG_200 = "操作成功";
    public static final int HTTP_CODE_300 = 300;
    public static final String HTTP_MSG_300 = "上传成功";

    public static final int HTTP_CODE_400 = 400;
    public static final String HTTP_MSG_400 = "请求参数出错";

    public static final int HTTP_CODE_401 = 401;
    public static final String HTTP_MSG_401 = "NO LOGIN";

    public static final int HTTP_CODE_403 = 403;
    public static final String HTTP_MSG_403 = "服务器出错";

    public static final int HTTP_CODE_404 = 404;
    public static final String HTTP_MSG_404 = "找不到页面";

    public static final int HTTP_CODE_500 = 500;
    public static final String HTTP_MSG_500 = "NO PERMISSION";
    
    public static final int HTTP_CODE_406 = 406;
    public static final String HTTP_MSG_406 = "请求参数为空";
    
    public static final int HTTP_CODE_444 = 444;
    public static final String HTTP_MSG_444 = "CUSTOMER ERROR";
}


/**
 * @ProjectName b2b-data-common
 * @FileName APIKEYConstant.java
 * @PackageName com.xe.b2b.data.common.contants
 * @Date 2017年1月10日下午10:27:00
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.common.contants;

/**
 * @ClassName APIKEYConstant
 * @Description TODO
 * @Date 2017年1月10日 下午10:27:00
 * @author towen
 * @version v1.0
 */
public class APIKEYConstant {

    // 查账户信息的http地址
    public static final String YUNPIAN_GET_USER_INFO = "http://yunpian.com/v1/user/get.json";

    // 智能匹配模版发送接口的http地址
    public static final String YUNPIAN_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    // 模板发送接口的http地址
    public static final String YUNPIAN_TPL_SEND_SMS = "http://yunpian.com/v1/sms/tpl_send.json";

    public static final String YUNPIAN_KEY = "95c4b81552d074d50baadc2f37b3cb4e";
    public static final String YUNPIAN_PATTERN = "【合佳云】亲爱的#name#，您的验证码是#code#。有效期为#hour#，请尽快验证";
    public static final long YUNPIAN_PATTERN_ID = 1689530;
    public static final String NAME = "用户";
    public static final long EXPIRE_DATE_VALUE = 5;
    public static final String EXPIRE_DATE = EXPIRE_DATE_VALUE+"分钟";

}


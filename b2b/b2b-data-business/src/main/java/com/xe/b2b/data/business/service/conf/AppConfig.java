/**
 * @ProjectName b2b-data-common
 * @FileName AppConfig.java
 * @PackageName com.xe.b2b.data.common.conf
 * @Date 2017年1月17日下午3:54:25
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName AppConfig 
 * @Description TODO
 * @Date     2017年1月17日 下午3:54:25
 * @author   Tom.Xie
 * @version  v1.0	 
 */
@Configuration
@PropertySource(value = "classpath:app.properties")
public class AppConfig {

    @Value("${security_code}")
    private String securityCode;;

    @Value("${upload_url}")
    private String uploadUrl;

    @Value("${upload_path}")
    private String uploadPath;

    /**
     * uploadUrl.
     *
     * @return  the uploadUrl
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * uploadUrl.
     *
     * @param   uploadUrl    the uploadUrl to set
     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    /**
     * uploadPath.
     *
     * @return  the uploadPath
     */
    public String getUploadPath() {
        return uploadPath;
    }

    /**
     * uploadPath.
     *
     * @param   uploadPath    the uploadPath to set
     */
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
    

}


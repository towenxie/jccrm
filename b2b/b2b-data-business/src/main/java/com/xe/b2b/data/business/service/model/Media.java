/**
 * @ProjectName b2b-data-app
 * @FileName Media.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年11月21日下午2:08:07
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

/**
 * @ClassName Media 
 * @Description TODO
 * @Date     2016年11月21日 下午2:08:07
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class Media implements Serializable {
    /**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -4709043740569333644L;
	/** Full url of the media */
    private String url;
    /** CDN key for the media */
    private String cdnPath;
    /** Media id */
    private int mediaId;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCdnPath() {
		return cdnPath;
	}
	public void setCdnPath(String cdnPath) {
		this.cdnPath = cdnPath;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
}


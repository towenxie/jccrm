/**
 * @ProjectName b2b-data-access
 * @FileName GoodsImageEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2017年1月13日下午10:51:10
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.model;


/**
 * @ClassName GoodsMediaEntity 
 * @Description TODO
 * @Date     2017年1月13日 下午10:51:10
 * @author   towen
 * @version  v1.0	 
 */
public class GoodsMediaEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -3551874775261025613L;
    
    private String goodsNumber;
    
    private String mediaPath;

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

}


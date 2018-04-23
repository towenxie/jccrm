/**
 * @ProjectName b2b-data-business
 * @FileName SignInResponse.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2017年1月17日上午10:25:04
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

/**
 * @ClassName SignInResponse 
 * @Description TODO
 * @Date     2017年1月17日 上午10:25:04
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class SignInResponse implements Serializable {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private Long userId;
    
    private Integer subPoints;
    
    private Integer totalPoints;

    private Integer continutyDay;
    
    /**
     * userId.
     *
     * @return  the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * userId.
     *
     * @param   userId    the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * subPoints.
     *
     * @return  the subPoints
     */
    public Integer getSubPoints() {
        return subPoints;
    }

    /**
     * subPoints.
     *
     * @param   subPoints    the subPoints to set
     */
    public void setSubPoints(Integer subPoints) {
        this.subPoints = subPoints;
    }

    /**
     * totalPoints.
     *
     * @return  the totalPoints
     */
    public Integer getTotalPoints() {
        return totalPoints;
    }

    /**
     * totalPoints.
     *
     * @param   totalPoints    the totalPoints to set
     */
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getContinutyDay() {
        return continutyDay;
    }

    public void setContinutyDay(Integer continutyDay) {
        this.continutyDay = continutyDay;
    }
}


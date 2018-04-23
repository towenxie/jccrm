/**
 * @ProjectName b2b-data-access
 * @FileName ExceptionEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年12月19日下午3:52:50
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName ExceptionEntity
 * @Description TODO
 * @Date 2016年12月19日 下午3:52:50
 * @author Tom.Xie
 * @version v1.0
 */
public class ExceptionEntity extends BaseEntity {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;
    private String level;
    private String thrower;
    private String message;
    private String memo;

    public ExceptionEntity(String level, String thrower, String message, String memo) {
        this.level = level;
        this.thrower = thrower;
        this.message = message;
        this.memo = memo;
    }

    public ExceptionEntity(String level, String thrower, String message) {
        this.level = level;
        this.thrower = thrower;
        this.message = message;
    }
    
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getThrower() {
        return thrower;
    }

    public void setThrower(String thrower) {
        this.thrower = thrower;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

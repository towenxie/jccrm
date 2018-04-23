/**
 * @ProjectName b2b-data-app
 * @FileName ResponseModel.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月14日下午2:53:54
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model.base;

import java.io.Serializable;

import com.xe.b2b.data.common.contants.HttpCode;

/**
 * @ClassName ResponseModel 
 * @Description TODO
 * @Date     2016年12月14日 下午2:53:54
 * @author   Tom.Xie
 * @version  v1.0
 */
public class ResponseModel<T> implements Serializable {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 4200660073639318375L;
    private Integer code = HttpCode.HTTP_CODE_200;
    private String message = HttpCode.HTTP_MSG_200;
    private T item;

    public ResponseModel(){
    }
    
    public ResponseModel(T item){
        this.item = item;
    }

    public ResponseModel(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseModel(T item, Integer code, String message){
        this.item = item;
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}

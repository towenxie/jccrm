/**
 * @ProjectName b2b-data-app
 * @FileName ResponseListModel.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月14日下午2:48:24
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xe.b2b.data.common.contants.HttpCode;

/**
 * @ClassName ResponseListModel
 * @Description TODO
 * @Date 2016年12月14日 下午2:48:24
 * @author Tom.Xie
 * @version v1.0
 */
public class ResponseListModel<T> implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -717573720252135567L;
    private Integer code = HttpCode.HTTP_CODE_200;
    private String message = HttpCode.HTTP_MSG_200;
    private List<T> items = new ArrayList<T>();
    private PagesModel pages;

    public ResponseListModel(List<T> items) {
        this.items = items;
    }

    public ResponseListModel(List<T> items, PagesModel pages) {
        this.pages = pages;
        this.items = items;
    }

    public ResponseListModel(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseListModel(List<T> items, Integer code, String message) {
        this.items = items;
        this.code = code;
        this.message = message;
    }

    public ResponseListModel(List<T> items, PagesModel pages, Integer code, String message) {
        this.pages = pages;
        this.items = items;
        this.code = code;
        this.message = message;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PagesModel getPages() {
        return pages;
    }

    public void setPages(PagesModel pages) {
        this.pages = pages;
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
}

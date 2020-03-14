package com.someecho.base.seriable;

import java.io.Serializable;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.seriable
 * @Description:
 * @date Date : 2019年09月16日 6:45 PM
 **/
public class B implements Serializable {

    private static final long serialVersionUID = 2L;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
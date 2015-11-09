package com.cdel.rest.web.commen.exception;

/**
 * 获取数据源异常
 * function 
 * @author houxuelong
 * 2015-06-25下午01:54:10
 */
public class DataSourceException extends RuntimeException{
	private static final long serialVersionUID = 7662715726329519089L;

    public DataSourceException(String msg){
        super(msg);
    }

}

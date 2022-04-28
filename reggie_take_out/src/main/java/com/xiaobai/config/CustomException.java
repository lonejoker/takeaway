package com.xiaobai.config;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 13:48
 * @Version 1.0
 * @ClassName CustomException
 * @Description 类方法说明：
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}

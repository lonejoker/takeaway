package com.xiaobai.config;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 12:22
 * @Version 1.0
 * @ClassName BaseContext
 * @Description 类方法说明：基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取值
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}

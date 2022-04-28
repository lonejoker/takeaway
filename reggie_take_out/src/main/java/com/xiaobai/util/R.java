package com.xiaobai.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 10:04
 * @Version 1.0
 * @ClassName R
 * @Description 类方法说明：统一封装返回
 */
@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
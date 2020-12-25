/**
 * @projectName logindemo
 * @package com.example.logindemo.util
 * @className com.example.logindemo.util.JSONReturn
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * JSONReturn
 * @description
 * @author lichengyong
 * @date 2020/12/25 14:44
 * @version 1.0
 */
@Slf4j
public final class JSONReturn {
    private static final String SUCCESS = "success";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";
    private static final String CODE = "code";

    private JSONReturn() {
    }
    /**
     * 构造一个默认的成功响应
     * @param data 数据
     * @return 成功响应
     */
    public static JSONObject defaultSuccessJSONObject(Object data){
        JSONObject result = new JSONObject();
        result.put(SUCCESS, true);
        result.put(MESSAGE, "ok");
        JSON dataJson;
        try {
            dataJson = (JSON) JSON.toJSON(data);
        }catch (Exception e){
            String errMsg = String.format("转换JSON失败，转换对象：{}, 失败原因：{}", Objects.toString(data, "null"), e);
            log.error(errMsg);
            return defaultFailureJSONObject(errMsg);
        }
        result.put(DATA, dataJson);
        result.put(CODE, 200);
        return result;
    }

    /**
     * 构造一个默认的成功响应,data是一个字符串
     * @param data 数据
     * @return 成功响应
     */
    public static JSONObject defaultSuccessJSONObject(String data) {
        JSONObject result = new JSONObject();
        result.put(SUCCESS, true);
        result.put(MESSAGE, "ok");
        result.put(DATA, data);
        result.put(CODE, 200);
        return result;
    }

    /**
     * 构造一个默认的失败响应
     * @param message 提示消息，可以为NULL或者''
     * @return 失败响应
     */
    public static JSONObject defaultFailureJSONObject(String message) {
        JSONObject result = new JSONObject();
        result.put(SUCCESS, false);
        result.put(MESSAGE, StringUtils.defaultIfEmpty(message, "fail"));
        return result;
    }

    /**
     * 构造一个默认的失败响应
     * @return 失败响应
     */
    public static JSONObject defaultFailureJSONObject() {
        JSONObject result = new JSONObject();
        result.put(SUCCESS, false);
        result.put(MESSAGE, "fail");
        return result;
    }
    /**
     * 构造一个默认的成功响应
     * @return 成功响应
     */
    public static JSONObject defaultSuccessJSONObject() {
        JSONObject result = new JSONObject();
        result.put(SUCCESS, true);
        result.put(MESSAGE, "ok");
        return result;
    }

    /**
     * 根据传参，构造返回JSON
     * @param httpStatusCode HTTP状态码
     * @param extraMessage 额外的信息
     * @param data 数据，可以为null
     * @return 封装的JSONObject
     */
//    public static JSONObject result(HttpStatusCode httpStatusCode, String extraMessage, JSON data, Boolean success){
//        JSONObject result = new JSONObject();
//        result.put(MESSAGE, httpStatusCode.getMessage() + (StringUtils.isNotEmpty(extraMessage) ? "->" + extraMessage : StringUtils.EMPTY));
//        if(null != data){
//            result.put(DATA, data);
//        }
//        result.put(CODE, httpStatusCode.getCode());
//        result.put(SUCCESS, success);
//        return result;
//    }
}
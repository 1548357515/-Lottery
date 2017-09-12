package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.EntityUtil.UtilPlanName;

/**
 * 淘淘商城自定义响应结构
 */
public class StatceCode {
    
    public static String MapCode(int code, String msg , List<Object> resp){
    	Map<String, Object> restMap = new HashMap<String, Object>();
    	restMap.put("code", code);
    	restMap.put("msg", msg);
    	restMap.put("resp", resp);
    	return JsonUtils.objectToJson(restMap);
    }
    public static String MapCodeEntity(int code, String msg , Object resp){
    	Map<String, Object> restMap = new HashMap<String, Object>();
    	restMap.put("code", code);
    	restMap.put("msg", msg);
    	restMap.put("resp", resp);
    	return JsonUtils.objectToJson(restMap);
    }
    public static String CodeMap(int code, String msg , String id , Map<String, Object> resp){
    	Map<String, Object> restMap = new HashMap<String, Object>();
    	restMap.put("code", code);
    	restMap.put("msg", msg);
    	restMap.put("Id", id);
    	restMap.put("resp", resp);
    	return JsonUtils.objectToJson(restMap);
    }
    public static String Fname(int code, String msg , long l , Result eResult){
    	Map<String, Object> restMap = new HashMap<String, Object>();
    	restMap.put("code", code);
    	restMap.put("msg", msg);
    	restMap.put("count", l);
    	restMap.put("resp", eResult);
    	return JsonUtils.objectToJson(restMap);
    }

}

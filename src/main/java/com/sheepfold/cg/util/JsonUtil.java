package com.sheepfold.cg.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonUtil {

	/**
	 * 将object转成json string
	 * @param object
	 * @return
	 */
	public static String getJsonString(Object object) {
		String jsonStr = JSON.toJSONString(object);
		return jsonStr;
	}

	/**
	 * 将json string转成bean
	 * @param jsonStr
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(String jsonStr, Class<T> clazz) {

		T t = JSON.parseObject(jsonStr, clazz);
		return t;
	}

	/**
	 * 将json string转成JSONObject
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject getJSONObject(String jsonStr) {
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		return jsonObject;
	}

	/**
	 * 将json string转成JSONArray
	 * @param jsonStr
	 * @return
	 */
	public static JSONArray getJSONArray(String jsonStr) {
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		return jsonArray;
	}

	/**
	 * 将json string转成Map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String,Object> getMap(String jsonStr) {
		Map<String,Object>  map = JSON.parseObject(jsonStr);
		return map;
	}
}

package com.reyco.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONResult {
	
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	private static Gson gson1 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public final static String REQUEST_SUCCESS = "请求成功";

	public final static String REQUEST_ERROR = "请求失败";

	public final static String INSERT_SUCCESS = "新增成功";

	public final static String INSERT_FAIL = "新增失败";

	public final static String UPDATE_SUCCESS = "更新成功";

	public final static String UPDATE_FAIL = "更新失败";

	public final static String DELETE_SUCCESS = "删除成功";

	public final static String DELETE_FAIL = "删除失败";

	public final static String ERROR_PARAMS = "参数错误";

	public final static String ERROR_SELECT = "查询错误";

	private Map<String, Object> data;

	private boolean success;

	private String msg;


	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}



	public JSONResult() {
		data = new HashMap<>();
	}

	public String toJSONP(String callback) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("success", this.success);
		jsonObject.add("data", new JsonParser().parse(gson.toJson(this.data)));
		return callback + "(" + jsonObject.toString() + ");";
	}

	public String toJSON() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("success", this.success);
		jsonObject.add("data", new JsonParser().parse(gson.toJson(this.data)));
		jsonObject.add("msg", new JsonParser().parse(gson.toJson(this.msg)));
		return jsonObject.toString();
	}
	public String toJSON1() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("success", this.success);
		jsonObject.add("data", new JsonParser().parse(gson1.toJson(this.data)));
		jsonObject.add("msg", new JsonParser().parse(gson1.toJson(this.msg)));
		return jsonObject.toString();
	}
	public static JSONResult create(Object data) {
		JSONResult result = new JSONResult();
		result.setSuccess(true);
		result.getData().put("info", data);
		result.getData().put("msg", REQUEST_SUCCESS);
		result.setMsg(REQUEST_SUCCESS);
		return result;
	}


	public static JSONResult noDataCreate() {
		JSONResult result = new JSONResult();
		result.setSuccess(true);
		result.getData().put("info", new Object());
		result.getData().put("msg", "暂无数据");
		result.setMsg(REQUEST_SUCCESS);
		return result;
	}

	public static JSONResult operateCreate(String dataMsg) {
		JSONResult result = new JSONResult();
		result.setSuccess(true);
		result.getData().put("info", new Object());
		result.getData().put("msg", dataMsg);
		result.setMsg(REQUEST_SUCCESS);
		return result;
	}

	/**
	 * @param: dataMsg 用户提示消息
	 * @Param: msg 错误消息
	 */
	public static JSONResult failCreate(String dataMsg, String msg) {
		JSONResult result = new JSONResult();
		result.setSuccess(false);
		result.getData().put("info", new Object());
		result.getData().put("msg", dataMsg);
		result.setMsg(msg);
		return result;
	}
	/**
	 * 将map转为指定样式的字符串
	 * 		[
	 * 			{
	 * 				"name":"key1",
	 * 				"value":value1
	 * 			},
	 * 			{
	 * 				"name":"key2",
	 * 				"value":value2
	 * 			}
	 * 		]
	 * @param map
	 * @return
	 */
	public static String getMapToString(Map<String,Integer> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(map.size() >= 1) {
			for (Object key : map.keySet()) {
				Object value = map.get(key);
				String src = "{"+"\""+"name"+"\""+":"+"\""+key+"\""+","+"\""+"value"+"\""+":"+value+"}"+",";
				sb.append(src);
			}
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Map<String,Integer> map =  new HashMap<String,Integer>();
		map.put("A类客",153);
		map.put("B类客", 526);
		map.put("C类客", 1560);
		String sb = getMapToString(map);
		System.out.println(sb);
		
		
	}
}

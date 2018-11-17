package edu.marshall.cs651.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ProjectUtils {
public static String getMessage(boolean success,String successMsg,String failMsg) {
	
	JSONObject o=new JSONObject(2);
	o.put("success", success);
	if(success) {
		o.put("msg", successMsg);
		
	}else {
		o.put("msg", "failMsg");
	}
	return JSON.toJSONString(o);
	
}
}

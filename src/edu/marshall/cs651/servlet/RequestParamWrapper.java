package edu.marshall.cs651.servlet;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;


public class RequestParamWrapper {
private Map<String, String> standardParam;
private BasicDBObject dbObject;
public RequestParamWrapper(Map<String, String[]> map) {
	standardParam=new HashMap<String, String>();
	map.entrySet().forEach(e->{
		standardParam.put(e.getKey(), e.getValue()[0]);
		
	});
	
	
	
}
public String get(String key) {
	if(standardParam.get(key)==null) {
		return "";
	}
	return standardParam.get(key);
}
public Map<String, String> getStandardParam() {
	return standardParam;
}
	
	
}

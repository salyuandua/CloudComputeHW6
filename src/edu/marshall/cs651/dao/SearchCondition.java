package edu.marshall.cs651.dao;

import java.util.regex.Pattern;

import com.mongodb.BasicDBObject;

public class SearchCondition {
private BasicDBObject param;
public SearchCondition() {
	param=new BasicDBObject();
}

public void addLikeCondition(String attrName,String value) {
	if(value!=null&&!value.equals("")) {
		param.put(attrName, Pattern.compile("^.*"+value+".*$"));
	}
	
}
	
public void addEqCondition(String attrName,Object value) {
	if(value!=null&&!value.equals("")) {
		param.put(attrName, value);
		
	}
	

}
public BasicDBObject getCondition() {
	System.out.println(param.toJson());
	return param;
}

	
}

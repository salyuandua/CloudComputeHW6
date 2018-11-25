package edu.marshall.cs651.dao;

import com.mongodb.BasicDBObject;

public class ProjectionCondition {
	private BasicDBObject param;
	public ProjectionCondition() {
		param=new BasicDBObject();
	}
	
	public void addProjection(String attrName,Object value) {
		if(value!=null&&!value.equals("")) {
			param.put(attrName, value);
			
		}
	}
	public BasicDBObject getProjection() {
		return param;
	}
}

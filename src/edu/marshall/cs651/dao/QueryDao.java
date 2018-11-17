package edu.marshall.cs651.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;



import org.bson.Document;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import edu.marshall.cs651.db.DBUtils;

public class QueryDao {
private MongoCollection<Document> collection;
public QueryDao() {
	collection=DBUtils.getCollection("restaurants", "restaurants");
}
	
private SimpleDateFormat sDateFormat=new SimpleDateFormat("MMM dd yyyy",Locale.US);

/**
 * data is existing with id
 * @param id
 * @return
 */
public boolean isExisting(String id) {
	Document doc=collection.find(eq("restaurant_id", id)).first();
	if(doc==null) {
		return false;
	}
	return true;
	
}


private void computAverageScore(Document doc) {
	List<Document> grades=(List<Document>) doc.get("grades");
	//System.out.println(JSON.toJSONString(grades));
	int gradeSum=0;
	
	for(int i=0;i<grades.size();i++) {
		Document grade=grades.get(i);
		gradeSum+=grade.getInteger("score", 0);
		Date date=grade.getDate("date");
		grade.put("showDate", sDateFormat.format(date));
		
	}
	
	for(Document grade:grades) {
		gradeSum+=grade.getInteger("score", 0);
		System.out.println(grade.get("date"));
		
	}
	int average=gradeSum/grades.size();
	doc.put("averageGrade", average);
	
}
	
	
	
	public List<Document> queryRestaurants4List(Map<String, String> param) {
		
		
		SearchCondition sc=new SearchCondition();
		sc.addEqCondition("restaurant_id", param.get("id"));
		sc.addLikeCondition("name", param.get("name"));
		FindIterable<Document> findIterable= collection.find(sc.getCondition());
		
		if(param.get("from")!=null&&!param.get("from").equals("")) {
			int from=Integer.parseInt(param.get("from"));
			findIterable= findIterable.skip(from).limit(20);
		}
		
		
		MongoCursor<Document> cursor= findIterable.iterator();
		List<Document> docs=new ArrayList<Document>();
		while(cursor.hasNext()) {
			Document doc=cursor.next();
			computAverageScore(doc);
			docs.add(doc);
			
		}
		
		return docs;
	}
	
	public String queryRestaurants4Json(Map<String, String> param) {
		List<Document> docs=queryRestaurants4List(param);
		return JSON.toJSONString(docs);
	}
	
	
	
	public static void main(String[] args) {
		QueryDao d=new QueryDao();
		d.isExisting("3007545");
	}
	
	
}

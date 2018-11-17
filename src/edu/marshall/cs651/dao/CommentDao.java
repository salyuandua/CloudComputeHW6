package edu.marshall.cs651.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import edu.marshall.cs651.db.DBUtils;

public class CommentDao {
private MongoCollection<Document> collection;
private SimpleDateFormat simpleDateFormat;
public CommentDao() {
	collection=DBUtils.getCollection("restaurants", "restaurants");
	simpleDateFormat=new SimpleDateFormat("MMM dd yyyy");
}
	
	public void reply(Map<String, String> param) {
		BasicDBObject filter=new BasicDBObject("restaurant_id", param.get("id"));
		BasicDBObject update=new BasicDBObject();
		BasicDBObject grade=new BasicDBObject();
		grade.append("grade", param.get("grade"));
		grade.append("score", Integer.parseInt(param.get("score")));
		grade.append("date", new Date());
		
		
		
		update.append("$push", new BasicDBObject("grades", grade));
		UpdateResult rs= collection.updateOne(filter,update);
		System.out.println(rs.getModifiedCount());
		
	}
	
}

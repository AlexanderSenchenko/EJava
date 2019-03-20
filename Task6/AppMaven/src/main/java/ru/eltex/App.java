package ru.eltex;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;

import java.util.Set;

public class App {
	public static void main(String[] args) {
		Mongo m = new Mongo("127.0.0.1", 27017);
		DB db = m.getDB("test");
		Set<String> colls = db.getCollectionNames();
		DBCollection coll = db.getCollection("users");

		BasicDBObject doc = new BasicDBObject();

		doc.put("id", 1);
		doc.put("name", "Sandra");
		coll.insert(doc);

		System.out.println(colls);
	}
}

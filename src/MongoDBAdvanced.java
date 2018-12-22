import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBAdvanced {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		System.out.println("Connected to MongoDB !!");

		@SuppressWarnings("deprecation") // The method getDB(String) from the type Mongo is deprecated. Therefore
		// @SuppressWarnings
		DB db = mongoClient.getDB("userdetails");

		System.out.println("Opened the Database !!");

		DBCollection myDBCollection = db.getCollection("EmployeeRecord"); // Case - sensitive

		System.out.println("Switched to Collection !!");
		
		setUpTestData(myDBCollection);
		System.out.println("Documents created successfully !!\n");
		
		selectFirstRecordInCollection(myDBCollection);
		System.out.println("First document retrived successfully !!\n");
		
		selectSingleRecordAndFieldByRecordNumber(myDBCollection);
		System.out.println("Single Record & Field By Record Number retrieved successfully !!\n");	
		
		selectAllRecordByRecordNumber(myDBCollection);
		System.out.println("All Record By Record Number retrieved successfully !!\n");
		
		in_Example(myDBCollection);
		System.out.println("Printed the listed documents successfully !!\n");
		
		lessThan_GreaterThan_Example(myDBCollection);
		System.out.println("Greater than - Less than of the record value documents retrieved successfully !!\n");
		
		negation_Example(myDBCollection);
		System.out.println("Documents with the values not equal to the one mentioned retrieved successfully !!\n");
		
		andLogicalComparison_Example(myDBCollection);
		System.out.println("Documents with the mentioned 'AND' retrieved successfully !!\n");	
		
		regex_Example(myDBCollection);
		System.out.println("Documents with the regex retrieved successfully !!\n");
		
	}

	private static void setUpTestData(DBCollection yourDBCollection) {
		for (int i = 1; i <= 10; i++) {
			yourDBCollection
					.insert(new BasicDBObject().append("employeeId", i).append("employeeName", "TestEmployee_" + i));
		}
	}
	
	private static void selectFirstRecordInCollection(DBCollection yourDBCollection)
	{
	    DBObject dbObject = yourDBCollection.findOne();
	    System.out.println(dbObject);
	}
	
	private static void selectSingleRecordAndFieldByRecordNumber(DBCollection yourDBCollection)
	{
	    BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("employeeId", 3);
	    BasicDBObject fields = new BasicDBObject();
	    fields.put("employeeId", 1);
	  
	    DBCursor cursor = yourDBCollection.find(whereQuery, fields);  // Select document with employeeID 3 and print only that field. Keep 1 always in fields.
	    while (cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void selectAllRecordByRecordNumber(DBCollection yourDBCollection)
	{
	    BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("employeeId", 3);
	    DBCursor cursor = yourDBCollection.find(whereQuery);
	    while(cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void in_Example(DBCollection yourDBCollection)
	{
	    BasicDBObject inQuery = new BasicDBObject();
	 
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(2);
	    list.add(4);
	    list.add(5);
	 
	    inQuery.put("employeeId", new BasicDBObject("$in", list));
	 
	    DBCursor cursor = yourDBCollection.find(inQuery);
	    while(cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void lessThan_GreaterThan_Example(DBCollection yourDBCollection)
	{
	    BasicDBObject getQuery = new BasicDBObject();
	    getQuery.put("employeeId", new BasicDBObject("$gt", 2).append("$lt", 5));
	    DBCursor cursor = yourDBCollection.find(getQuery);
	    while(cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void negation_Example(DBCollection yourDBCollection)
	{
	    BasicDBObject neQuery = new BasicDBObject();
	    neQuery.put("employeeId", new BasicDBObject("$ne", 4));
	    DBCursor cursor = yourDBCollection.find(neQuery);
	    while(cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void andLogicalComparison_Example(DBCollection yourDBCollection)
	{
	    BasicDBObject andQuery = new BasicDBObject();
	    List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	    obj.add(new BasicDBObject("employeeId", 2));
	    obj.add(new BasicDBObject("employeeName", "TestEmployee_2"));
	    andQuery.put("$and", obj);
	  
	    System.out.println(andQuery.toString());
	  
	    DBCursor cursor = yourDBCollection.find(andQuery);
	    while (cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}
	
	private static void regex_Example(DBCollection yourDBCollection) {
	    BasicDBObject regexQuery = new BasicDBObject();
	    regexQuery.put("employeeName",
	        new BasicDBObject("$regex", "TestEmployee_[3]")
	        .append("$options", "i"));
	  
	    System.out.println(regexQuery.toString());
	  
	    DBCursor cursor = yourDBCollection.find(regexQuery);
	    while (cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}

}

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoTest {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017); // Run 'mongo' in CMD and see --> connecting to:
																		// mongodb://127.0.0.1:27017 --> localhsot =
																		// 127.0.0.1

		System.out.println("Connected to MongoDB !!");

		@SuppressWarnings("deprecation") // The method getDB(String) from the type Mongo is deprecated. Therefore
											// @SuppressWarnings
		DB db = mongoClient.getDB("userdetails");

		System.out.println("Opened the Database !!");

		DBCollection myDBCollection = db.getCollection("userdetails"); // Case - sensitive

		System.out.println("Switched to Collection !!");

		DBCursor myCursor = myDBCollection.find();

		// DBObject myDBObject = myDBCollection.findOne(); Select first document from
		// a collection

		while (myCursor.hasNext()) {

			int i = 1;
			System.out.println(myCursor.next());
			i++;
		}

		BasicDBObject myBasicDBObject = new BasicDBObject();

		myBasicDBObject.put("first_name", "Abdul");

		myBasicDBObject.put("last_name", "Azeez");

		myBasicDBObject.put("age", 24);

		myDBCollection.insert(myBasicDBObject);

	}

}

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.ClusterSettings;
import org.bson.Document;

import java.util.Arrays;

public class Pw {

    public static void main(String[] args) {
        connectionMongoDB();

    }

    public static void connectionMongoDB() {
        //您可以在没有任何参数的情况下实例化MongoClient对象，以连接到localhost，27017端口上运行的的MongoDB实例
//        MongoClient mongoClient1 = MongoClients.create();
//        MongoClient mongoClient2 = MongoClients.create(
//                MongoClientSettings.builder()
//                        .applyToClusterSettings(new Block<ClusterSettings.Builder>() {
//                            @Override
//                            public void apply(ClusterSettings.Builder builder) {
//                                builder.hosts(Arrays.asList(new ServerAddress("hostOne",27108)));
//                            }
//                        })
//                        .build());

        MongoClient mongoClient = MongoClients.create("mongodb://root:root@139.159.135.115:27017");

        MongoDatabase database = mongoClient.getDatabase("mydb");

        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);


    }

//    public static void oldAPI() {
//        MongoClient mongoClient1 = new MongoClient();
//        MongoClient mongoClient2 = new MongoClient( "hostOne" );
//        MongoClient mongoClient3 = new MongoClient( "hostOne" , 27018 );
//
//        // 您可以指定 MongoClientURI连接字符串：
//        MongoClientURI connectionString = new MongoClientURI("mongodb://hostOne:27017,hostTwo:27017");
//        MongoClient mongoClient4 = new MongoClient(connectionString);
//    }
}

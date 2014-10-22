package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Request;
import views.html.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import scala.Enumeration.Value;
import scala.Function1;
import scala.Option;
import scala.Tuple2;
import scala.concurrent.Future;
import play.api.Application;
import play.api.Configuration;
import play.api.GlobalSettings;
import play.api.libs.json.* ;
import play.api.mvc.EssentialAction;
import play.api.mvc.Handler;
import play.api.mvc.RequestHeader;
import play.api.mvc.SimpleResult;
import play.data.DynamicForm;
import play.data.Form;
import play.data.Form.*;

import java.sql.*;

import org.apache.commons.dbcp.*;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

//http://www.tutorialspoint.com/postgresql/postgresql_java.htm

public class HomeFoodGateKeeperService extends Controller {

	public static BasicDataSource connectionPool=null;
	
	
	
	public static Result index() {
		return ok(index.render());
	}

	public static Result listRecipe() {
		return ok(listing.render());
	}

	public static Result addRecipe() {
		String name = request().body().asMultipartFormData().asFormUrlEncoded().get("name")[0];
		return ok(addrecipe.render());
	}

	public static Result createChef() {
		boolean success=true;
		Map<String, String[]> requestData = request().body().asFormUrlEncoded();
		if(requestData!=null){
			MasterChef mc = new MasterChef();
			for(Entry<String, String[]> e : requestData.entrySet()){
				System.out.println(" " + e.getKey() +" " + e.getValue()[0]);
				String name = requestData.get("name")[0];
				//http://www.tutorialspoint.com/postgresql/postgresql_java.htm

				mc.setName(name);
			}
			try{
				init();
				Connection connection = connectionPool.getConnection();
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
				stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
				ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
				Client client = new TransportClient()
		        .addTransportAddress(new InetSocketTransportAddress("ihscrydx:lujdwgoxxdpc03p7@spruce-7122461.us-east-1.bonsai.io", 443))
		        ;
		       
				String json = "{" +
				        "\"user\":\"kimchy\"," +
				        "\"postDate\":\"2013-01-30\"," +
				        "\"message\":\"trying out Elasticsearch\"" +
				    "}";
				
				IndexResponse response = client.prepareIndex("twitter", "tweet")
				        .setSource(json)
				        .execute()
				        .actionGet();
				
				client.close();
				while (rs.next()) {
					System.out.println("Read from DB: " + rs.getTimestamp("tick") + "\n");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(" mc " +   mc.getName());

		}
		//boolean success = createChefAttempt(request());
		if(success){
			return ok(loggedin.render());

		}else{
			return ok(failure.render());

		}
	}

	private static void init() {
		if(connectionPool!=null)
			return;
		try {

			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
			connectionPool = new BasicDataSource();

			if (dbUri.getUserInfo() != null) {
				connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
				connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
			}
			connectionPool.setDriverClassName("org.postgresql.Driver");
			connectionPool.setUrl(dbUrl);
			connectionPool.setInitialSize(10);
			Logger.info("Connection pool successfully initialized.");
			System.out.println("Connection pool successfully initialized.");
		} catch (Exception e) {
			Logger.error("Connection pool could  not be initialized.", e);
			System.out.println("Connection pool could  not be initialized.");
		}
	}

	private static boolean  createChefAttempt(Request request) {

		return false;
	}

	public static Result signup(){
		return ok(signup.render());
	}

	public static Result signin(){
		return ok(signin.render());
	}

}

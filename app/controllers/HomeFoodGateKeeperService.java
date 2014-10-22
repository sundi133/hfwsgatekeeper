package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Request;
import views.html.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import play.api.libs.json.* ;
import play.data.DynamicForm;
import play.data.Form;
import play.data.Form.*;
import java.sql.*;
import org.apache.commons.dbcp.*;
import org.apache.commons.dbcp.BasicDataSource;

public class HomeFoodGateKeeperService extends Controller {

	public static BasicDataSource pool;
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
				Connection connection = pool.getConnection();
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
				stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
				ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
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

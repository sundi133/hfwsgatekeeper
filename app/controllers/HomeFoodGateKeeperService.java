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
import org.eclipse.jetty.util.log.Log;

public class HomeFoodGateKeeperService extends Controller implements GlobalSettings {

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

	@Override
	public void beforeStart(Application arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Configuration configuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function1<RequestHeader, Handler> doFilter(
			Function1<RequestHeader, Handler> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EssentialAction doFilter(EssentialAction arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> A getControllerInstance(Class<A> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<SimpleResult> onBadRequest(RequestHeader arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<SimpleResult> onError(RequestHeader arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<SimpleResult> onHandlerNotFound(RequestHeader arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration onLoadConfig(Configuration arg0, File arg1,
			ClassLoader arg2, Value arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onRequestCompletion(RequestHeader arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tuple2<RequestHeader, Handler> onRequestReceived(RequestHeader arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option<Handler> onRouteRequest(RequestHeader arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStart(Application arg0) {
		Log.info("onStart test");		
	}

	@Override
	public void onStop(Application arg0) {
		// TODO Auto-generated method stub
		
	}

}

package controllers;

import play.GlobalSettings;
import play.*;
import play.libs.*;

import java.util.*;
import redis.clients.jedis.*;
import java.net.URI;
import controllers.HomeFoodGateKeeperService;
import java.sql.*;
import org.apache.commons.dbcp.*;

public class  Global extends GlobalSettings {
	private BasicDataSource connectionPool;

	public void onStart(Application app) {
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
		} catch (Exception e) {
			Logger.error("Connection pool could  not be initialized.", e);
			controllers.HomeFoodGateKeeperService.pool = null;
		}
	}
}
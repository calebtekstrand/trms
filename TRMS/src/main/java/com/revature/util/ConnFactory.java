package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	private final static String user = "TRMS"; // System.getenv("jdbc_user")
	private final static String password = "p4ssw0rd";
	private final static String url = "jdbc:oracle:thin:@octocatdb.ckn7zuvrx3td.us-east-2.rds.amazonaws.com:1521:ORCL";

	private ConnFactory() {
		super();
	}
	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		//Don't hard code url, user, password----------------BAD BOI
		
		//Properties prop = new Properties();
		try {
			//prop.load(new FileReader("database.properties"));
			//Class.forName(prop.getProperty("oracle.jdbc.driver.OracleDriver"));
			conn = DriverManager.getConnection(url, user, password);
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@octocatdb.c0ctdglcl6gk.us-east-2.rds.amazonaws.com:1521:ORCL", "trms_db", "p4ssw0rd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
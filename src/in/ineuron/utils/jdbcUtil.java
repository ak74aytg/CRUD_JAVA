package in.ineuron.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
	private jdbcUtil() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException{
		FileInputStream fis = new FileInputStream("src//in//ineuron//properties//db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}

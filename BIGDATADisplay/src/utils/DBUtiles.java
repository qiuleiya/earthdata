package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtiles {
	//声明四个变量存放配置文件中的数据
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	static{//静态代码块
		//读取配置文件
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driverClass=rb.getString("driverClass");
		url=rb.getString("url")+"?useUnicode=true&characterEncoding=utf8";
		username=rb.getString("username");
		password=rb.getString("password");
		//驱动的加载
		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取连接的方法
	public static Connection getConnection() throws Exception{
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	//关闭连接的方法
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps=null;
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
	}
}

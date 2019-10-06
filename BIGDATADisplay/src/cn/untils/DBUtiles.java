package cn.untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtiles {
	//�����ĸ�������������ļ��е�����
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	static{//��̬�����
		//��ȡ�����ļ�
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driverClass=rb.getString("driverClass");
		url=rb.getString("url")+"?useUnicode=true&characterEncoding=utf8";
		username=rb.getString("username");
		password=rb.getString("password");
		//�����ļ���
		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ȡ���ӵķ���
	public static Connection getConnection() throws Exception{
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	//�ر����ӵķ���
	public static void closeAll(Connection conn,Statement stat,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stat=null;
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
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

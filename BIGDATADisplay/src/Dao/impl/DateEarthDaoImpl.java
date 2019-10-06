package Dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.DateEarthDao;
import pojo.Earthquake;
import utils.DBUtiles;

public class DateEarthDaoImpl implements DateEarthDao {

	@Override
	public List<Earthquake> getDateEarth(Date startDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		
		List<Earthquake> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from eq where date between ? and ?");
			ps.setDate(1, startDate);
			ps.setDate(2, endDate);
			rs=ps.executeQuery();
			while(rs.next()){
				Earthquake e=new Earthquake();
				e.setDate(rs.getDate("date"));
				e.setDepth(rs.getDouble("depth"));
				String[] value={rs.getDouble("longitude")+"",rs.getDouble("latitude")+""};
				e.setValue(value);
				e.setMagnitude(rs.getDouble("magnitude"));
				e.setMagnitudetype(rs.getString("magnitudetype"));
				e.setTime(rs.getTime("time"));
				e.setSource(rs.getString("source"));
				e.setStatus(rs.getString("statu"));
			   
				list.add(e);
			}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		DBUtiles.closeAll(conn, ps, rs);
	}
		return list;
	}
	

}

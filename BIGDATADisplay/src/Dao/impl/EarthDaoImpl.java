package Dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.EarthDataDao;
import pojo.EarthData;
import utils.DBUtiles;

public class EarthDaoImpl implements EarthDataDao {

	@Override
	public List<EarthData> getEarthData(Date startDate, Date endDate)throws Exception {
		// TODO Auto-generated method stub
		List<EarthData> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from eq where date between ? and ?");
			System.out.print("conn");
			ps.setDate(1, startDate);
			ps.setDate(2, endDate);
			rs=ps.executeQuery();
			while(rs.next()){
				EarthData e=new EarthData();
				String name="Magnitude:"+rs.getDouble("magnitude")+"MW"+"\nDepth:"+rs.getDouble("depth")+"KM";
				e.setName(name);
				String[] value={rs.getDouble("longitude")+"",rs.getDouble("latitude")+""};
				e.setValue(value);
				list.add(e);
			}
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBUtiles.closeAll(conn, ps, rs);
	}
		return list;
	}

}

package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.dao.ValueStrengthDao;
import cn.pojo.ValueStrength;
import cn.untils.DBUtiles;

public class ValueStrengthDaoImpl implements ValueStrengthDao{

	@Override
	public List<ValueStrength> getValue(Double lati, Double longi) throws Exception {
		// TODO Auto-generated method stub
		
		List<ValueStrength> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("SELECT * FROM eq WHERE  latitude<(?+10) AND latitude>(?-10) AND longitude<(?+10) AND longitude>(?-10)");
			ps.setDouble(1, lati);
			ps.setDouble(2, lati);
			ps.setDouble(3,longi);
			ps.setDouble(4,longi);
			rs=ps.executeQuery();
			
			while(rs.next()){
				ValueStrength v=new ValueStrength();
				v.setDate(rs.getDate("date"));
				double ma=rs.getDouble("magnitude");
				v.setMagnitude(ma);
				if(ma>5 &ma<6){
					v.setFlag(5);
				}
				else if(ma>=6 &ma<7){
					v.setFlag(6);
				}
				else if(ma>=7 &ma<8){
					v.setFlag(7);
				}
				else if(ma>=8 &ma<9){
					v.setFlag(8);
				}
				else {v.setFlag(9); }
				String[] value={rs.getDouble("longitude")+"",rs.getDouble("latitude")+""};
				v.setValue(value);
				list.add(v);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());
		return list;

}
}

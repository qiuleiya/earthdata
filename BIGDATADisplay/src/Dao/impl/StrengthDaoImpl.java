package Dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Dao.StrengthDao;
import pojo.Strength;
import utils.DBUtiles;

/**数据库中查询一段时间内震级情况
 * @author qiulei
 *
 */
public class StrengthDaoImpl implements StrengthDao {

	@Override
	public List<Strength> getDateStrength(Date startDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		List<Strength> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select date,latitude,longitude,magnitude from eq where date between ? and ?");
			ps.setDate(1, startDate);
			ps.setDate(2, endDate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String dateperiod=sdf.format(startDate)+"~"+sdf.format(endDate);
			System.out.println(dateperiod);
			rs=ps.executeQuery();
			while(rs.next()){
				Strength s=new Strength();
				s.setDateperiod(dateperiod);
				double ma=rs.getDouble("magnitude");
				s.setMagnitude(ma);
				if(ma>5 &ma<6){
					s.setFlag(5);
				}
				else if(ma>=6 &ma<7){
					s.setFlag(6);
				}
				else if(ma>=7 &ma<8){
					s.setFlag(7);
				}
				else if(ma>=8 &ma<9){
					s.setFlag(8);
				}
				else {s.setFlag(9); }
				String[] value={rs.getDouble("longitude")+"",rs.getDouble("latitude")+""};
				s.setValue(value);
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}

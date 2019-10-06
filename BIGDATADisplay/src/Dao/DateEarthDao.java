package Dao;

import java.sql.Date;
import java.util.List;

import pojo.Earthquake;
//根据日期的到各地震地点地震信息
public interface DateEarthDao {

	public List<Earthquake> getDateEarth(Date startDate,Date endDate)throws Exception;
}

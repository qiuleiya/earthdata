package Dao;

import java.sql.Date;
import java.util.List;

import pojo.Earthquake;
//�������ڵĵ�������ص������Ϣ
public interface DateEarthDao {

	public List<Earthquake> getDateEarth(Date startDate,Date endDate)throws Exception;
}

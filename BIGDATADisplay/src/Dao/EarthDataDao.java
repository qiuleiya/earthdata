package Dao;

import java.sql.Date;
import java.util.List;

import pojo.EarthData;

public interface EarthDataDao {
	public List<EarthData> getEarthData(Date startDate,Date endDate)throws Exception;
}

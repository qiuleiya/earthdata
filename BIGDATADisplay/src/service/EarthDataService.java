package service;

import java.sql.Date;
import java.util.List;

import pojo.EarthData;

public interface EarthDataService {
	public List<EarthData> getEarthDate(Date startDate, Date endDate) throws Exception;
}

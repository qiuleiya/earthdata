package service;

import java.sql.Date;
import java.util.Map;

import pojo.DateMagCount;

public interface DateMagnitudeService {
	public Map<String, String> getMagnitudeData(Date startDate,Date endDate) throws Exception;
	
	//从数据库查询指定日期不同地震级别的数据，并封装到对应的集合中,并返回一个各级数次数类
	public DateMagCount getDateMagnitude(Date startDate,Date endDate) throws Exception;

}

package service;

import java.sql.Date;
import java.util.List;

import pojo.Earthquake;

public interface  DateEarthService {

	public List<Earthquake> getDateEarth(Date startDate, Date endDate) throws Exception;

}

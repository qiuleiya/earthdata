package service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.DateEarthDao;
import Dao.impl.DateEarthDaoImpl;
import pojo.Earthquake;
import service.DateEarthService;

public class DateEarthServiceImpl implements DateEarthService{
	private DateEarthDao earthdao=new DateEarthDaoImpl();
	private static Map<String, List<Earthquake>> earth=new HashMap<>();
	
	public void cache(Date startDate,Date endDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateperiod=sdf.format(startDate)+sdf.format(endDate);
		//缓存内有当前数据则不用加
		if(!earth.containsKey(dateperiod)){
			//查询数据库
			List<Earthquake> list=earthdao.getDateEarth(startDate, endDate);
			//添加到缓存
			earth.put(dateperiod,list);
			
		}
	}
	
	@Override
	public List<Earthquake> getDateEarth(Date startDate,Date endDate) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateperiod=sdf.format(startDate)+sdf.format(endDate);
		cache(startDate, endDate);
		return earth.get(dateperiod);
	}
	
}

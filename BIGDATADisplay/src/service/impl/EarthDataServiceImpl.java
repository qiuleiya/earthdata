package service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Dao.EarthDataDao;

import Dao.impl.EarthDaoImpl;
import pojo.EarthData;

import service.EarthDataService;

public class EarthDataServiceImpl implements EarthDataService {

	private EarthDataDao earthdao=new EarthDaoImpl();
	private static Map<String, List<EarthData>> earth=new HashMap<>();
	
	public void cache(Date startDate,Date endDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateperiod=sdf.format(startDate)+sdf.format(endDate);
		//缓存内有当前数据则不用加
		if(!earth.containsKey(dateperiod)){
			//查询数据库
			List<EarthData> list=earthdao.getEarthData(startDate, endDate);
			//添加到缓存
			earth.put(dateperiod,list);
			
		}
	}
	
	
	@Override
	public List<EarthData> getEarthDate(Date startDate, Date endDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateperiod=sdf.format(startDate)+sdf.format(endDate);
		cache(startDate, endDate);
		return earth.get(dateperiod);
	}

}

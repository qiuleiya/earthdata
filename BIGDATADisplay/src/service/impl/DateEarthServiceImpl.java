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
		//�������е�ǰ�������ü�
		if(!earth.containsKey(dateperiod)){
			//��ѯ���ݿ�
			List<Earthquake> list=earthdao.getDateEarth(startDate, endDate);
			//��ӵ�����
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

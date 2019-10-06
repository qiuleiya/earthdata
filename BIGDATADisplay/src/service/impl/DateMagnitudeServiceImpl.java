package service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import Dao.StrengthDao;
import Dao.impl.StrengthDaoImpl;
import pojo.DateMagCount;
import pojo.Strength;
import service.DateMagnitudeService;
//将不同震级范围的数据存到map中
public class DateMagnitudeServiceImpl implements DateMagnitudeService{
	private StrengthDao strdao=new StrengthDaoImpl();
	private List<Strength> five,six,seven,eight,nine;
	
	
	public Map<String, String> getMagnitudeData(Date startDate,Date endDate) throws Exception{
		DateMagCount count=getDateMagnitude(startDate,endDate);
		
		Map<String, String> map = new HashMap<>();
		System.out.println(seven.size()+"+++++++++++++++++++++++++++++");
		map.put("five", JSON.toJSONString(five));
		map.put("six", JSON.toJSONString(six));
		map.put("seven", JSON.toJSONString(seven));
		map.put("eight", JSON.toJSONString(eight));
		map.put("nine", JSON.toJSONString(nine));
		map.put("datemagcount", JSON.toJSONString(count));//不同震级的次数
		
		return map;
	}
	

//根据日期得到不同震级范围的次数
	@Override
	public DateMagCount getDateMagnitude(Date startDate,Date endDate) throws Exception {
		// TODO Auto-generated method stub
		DateMagCount count=new DateMagCount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateperiod=sdf.format(startDate)+"~"+sdf.format(endDate);
		List<Strength> list=strdao.getDateStrength(startDate, endDate);
		five= new ArrayList<>();
		six = new ArrayList<>();
		seven = new ArrayList<>();
		eight = new ArrayList<>();
		nine = new ArrayList<>();
		int f=0;int si=0;int se=0;int e=0;int n=0;
		for(Strength s : list){
			if(s.getFlag()==5) {
				five.add(s);
				f++;
			}else if (s.getFlag()==6) {
				six.add(s);
				si++;
			}else if (s.getFlag()==7) {
				seven.add(s);
				se++;
			}else if (s.getFlag()==8) {
				eight.add(s);
				e++;
			}else if (s.getFlag()==9) {
				nine.add(s);
				n++;
			}
		}
		count.setFive(f);
		count.setSix(si);
		count.setSeven(se);
		count.setEight(e);
		count.setNine(n);
		count.setDateperiod(dateperiod);
		return count;
		
	}
}

package cn.service.impl;


import java.util.List;

import cn.dao.ValueStrengthDao;
import cn.dao.impl.ValueStrengthDaoImpl;
import cn.pojo.MagCount;
import cn.pojo.ValueStrength;
import service.ValueStrengthService;

public class ValueStrengthServiceImpl implements ValueStrengthService{
	private ValueStrengthDao valdao=new ValueStrengthDaoImpl();
	
	@Override
	public MagCount getMagnitude(Double lati,Double longi) throws Exception {
		// TODO Auto-generated method stub
		
		MagCount count=new MagCount();
		List<ValueStrength> list=valdao.getValue(lati, longi);
		
		int f=0;int si=0;int se=0;int e=0;int n=0;
		for(ValueStrength v1 : list){
			if(v1.getFlag()==5) {
				
				f++;
			}else if (v1.getFlag()==6) {
			
				si++;
			}else if (v1.getFlag()==7) {
				
				se++;
			}else if (v1.getFlag()==8) {
				
				e++;
			}else if (v1.getFlag()==9) {
			
				n++;
			}
		}
		String[] value={"longitude"+"","latitude"+""};
		count.setFive(f);
		count.setSix(si);
		count.setSeven(se);
		count.setEight(e);
		count.setNine(n);
		count.setValue(value);
		return count;
		
	}
}

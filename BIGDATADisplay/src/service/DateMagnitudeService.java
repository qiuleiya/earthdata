package service;

import java.sql.Date;
import java.util.Map;

import pojo.DateMagCount;

public interface DateMagnitudeService {
	public Map<String, String> getMagnitudeData(Date startDate,Date endDate) throws Exception;
	
	//�����ݿ��ѯָ�����ڲ�ͬ���𼶱�����ݣ�����װ����Ӧ�ļ�����,������һ��������������
	public DateMagCount getDateMagnitude(Date startDate,Date endDate) throws Exception;

}

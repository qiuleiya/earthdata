package service;

import cn.pojo.MagCount;

public interface ValueStrengthService {
	//�����ݿ��ѯָ����γ�Ȳ�ͬ���𼶱�����ݣ�����װ����Ӧ�ļ�����,������һ��������������
		public MagCount getMagnitude(Double lati,Double longi) throws Exception;

}

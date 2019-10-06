package service;

import cn.pojo.MagCount;

public interface ValueStrengthService {
	//从数据库查询指定经纬度不同地震级别的数据，并封装到对应的集合中,并返回一个各级数次数类
		public MagCount getMagnitude(Double lati,Double longi) throws Exception;

}

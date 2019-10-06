package cn.dao;

import java.util.List;


import cn.pojo.ValueStrength;

public interface ValueStrengthDao {
	/**查找指定经纬度的不同时间震级
	 * @param lati
	 * @param longi
	 * @return
	 * @throws Exception
	 */
	public List<ValueStrength> getValue(Double lati,Double longi)throws Exception;


}

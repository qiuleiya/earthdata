package cn.dao;

import java.util.List;


import cn.pojo.ValueStrength;

public interface ValueStrengthDao {
	/**����ָ����γ�ȵĲ�ͬʱ����
	 * @param lati
	 * @param longi
	 * @return
	 * @throws Exception
	 */
	public List<ValueStrength> getValue(Double lati,Double longi)throws Exception;


}

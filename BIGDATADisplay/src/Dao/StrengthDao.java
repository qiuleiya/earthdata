package Dao;

import java.sql.Date;
import java.util.List;

import pojo.Strength;

public interface StrengthDao {

	/**����ָ��ʱ��εĲ�ͬ�ط���
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List<Strength> getDateStrength(Date startDate,Date endDate)throws Exception;
}

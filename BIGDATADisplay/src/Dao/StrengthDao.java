package Dao;

import java.sql.Date;
import java.util.List;

import pojo.Strength;

public interface StrengthDao {

	/**查找指定时间段的不同地方震级
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List<Strength> getDateStrength(Date startDate,Date endDate)throws Exception;
}

package com.Service;

import java.util.Date;
import java.util.List;

import com.Pojo.PlanPk10;

public interface PlanPk10_Service {
	
	/**
	 * 根据id和时间查询
	 * @param id id
	 * @param date 开始时间
	 * @param da   结束时间
	 * @return
	 */
	List<PlanPk10> selectByExample (Long id , Date startTime , Date endTime);
}

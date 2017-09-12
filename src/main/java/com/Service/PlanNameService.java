package com.Service;


import com.Pojo.PlanName;
import com.util.EUDataGridResult;

public interface PlanNameService {
	/**
	 * 插入PlanName表
	 * @param PlanName 数据
	 * @return
	 */
	int insertPlanName(PlanName planName);
	/**
	 * 分页
	 * @param count_id id
	 * @param page 页数
	 * @param size 显示个数
	 * @return
	 */
	EUDataGridResult getCarTreeNodesList(String count_id , String page , String size , String sort , String type );
}

package com.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mapper.PlanNameMapper;
import com.Pojo.PlanName;
import com.Pojo.PlanNameExample;
import com.Pojo.PlanNameExample.Criteria;
import com.Service.PlanNameService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.EUDataGridResult;
import com.util.JStringKit;
@Service
public class PlanNameService_Im implements PlanNameService {

	@Autowired
	private PlanNameMapper planNameMapper;
	
	public int insertPlanName(PlanName planName) {
		
		return planNameMapper.insert(planName);
	}

	public EUDataGridResult getCarTreeNodesList(String count_id, String page,String size, String sort, String type) {
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
		PlanNameExample example = new PlanNameExample();
		Criteria criteria = example.createCriteria();
		if (JStringKit.notBlank(count_id)) {
			criteria.andAccountidEqualTo(Long.parseLong(count_id));//如果根据什么查询  名称必须位long
		}
		if (JStringKit.notBlank(type)) {
			criteria.andTypeEqualTo(Integer.parseInt(type));
		}
		if (JStringKit.notBlank(sort)) {
			if(sort.equals("1")){
				example.setOrderByClause("createtime DESC");
			}
		}
		List<PlanName> listPlan = planNameMapper.selectByExample(example);
		PageInfo<PlanName> pageInfo = new PageInfo<PlanName>(listPlan);
		long total = pageInfo.getTotal();// 取出记录的总条数
		EUDataGridResult eResult = new EUDataGridResult();
		eResult.setRows(listPlan);
		eResult.setTotal(total);
		return eResult;
	}


}

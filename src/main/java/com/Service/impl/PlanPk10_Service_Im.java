package com.Service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mapper.PlanPk10Mapper;
import com.Pojo.PlanPk10;
import com.Service.PlanPk10_Service;
@Service
public class PlanPk10_Service_Im implements PlanPk10_Service {
	
	@Autowired
	private PlanPk10Mapper planPk10Mapper;
	
	public List<PlanPk10> selectByExample(Long id , Date startTime , Date endTime) {
		
		return planPk10Mapper.selectByDate(id, startTime, endTime);
	}

}

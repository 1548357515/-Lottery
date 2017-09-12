package com.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mapper.Pk10NewMapper;
import com.Pojo.Pk10New;
import com.Service.Pk10_Service;
@Service
public class Pk10_Service_Im implements Pk10_Service {
	
	@Autowired
	private Pk10NewMapper pkMapper;
	
	public Pk10New selectPk10(long expect) {
		
		return pkMapper.selectByexpect(expect);
	}

}

package com.Service;

import com.Pojo.Pk10New;

public interface Pk10_Service {
	
	/**
	 * 查询pk10new表
	 * @param expect 根据
	 * @return
	 */
	Pk10New selectPk10 (long expect);
}

package com.util;

import java.util.List;
/**
 * 分页列表util类
 *<p>Title:  EUDataGridResult</p>
 *<p>Description: </p>
 *<p>Company: </p>
 * @author   陈立志
 * @date  2017-3-30上午10:54:53
 * @version
 */
public class EUDataGridResult {
	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}

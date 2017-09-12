package com.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EntityUtil.UtilPlanPk10;
import com.Pojo.Pk10New;
import com.Pojo.PlanPk10;
import com.Service.Pk10_Service;
import com.Service.PlanPk10_Service;
import com.util.JStringKit;
import com.util.JsonUtils;
import com.util.StatceCode;

@Controller
@RequestMapping("/PlanPk10/planpk")
public class PlanPk10_Controller {
	
	@Autowired
	private PlanPk10_Service planPk10_Service;
	
	@Autowired
	private Pk10_Service pk10_Service_Im;
	
	private static final Logger logger = Logger.getLogger(Account_Controller.class);
	
	@RequestMapping(value = "/selectDate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String createContentCategory(String planId , String date , String da) {
		Date startTime = null;
		Date endTime =null;
		Map<String, Object> map = new HashMap<String, Object>();
		if(JStringKit.isBlank(planId)){
			return StatceCode.MapCode(10001,"planId不能为空", null);
		}
		if(!JStringKit.isBlank(date)){
			startTime = JsonUtils.strToDateLong(date);
		}
		if(!JStringKit.isBlank(da)){
			endTime = JsonUtils.strToDateLong(da);
		}
		logger.debug("根据id和时间查询PlanPk10表 , planId =" + planId + "开始时间为 =" + startTime + " 结束时间为 =" + endTime);
		List<PlanPk10> selList = planPk10_Service.selectByExample(Long.parseLong(planId), startTime , endTime);
		if(selList.size()==0){
			return StatceCode.MapCode(10001,"id或者日期不对", null);
		}
		List<UtilPlanPk10> pl = new ArrayList<UtilPlanPk10>();
		Pk10New selectPk10 = new Pk10New ();
		for (PlanPk10 planPk10 : selList) {
			UtilPlanPk10 pk10 = new UtilPlanPk10();
			BeanUtils.copyProperties(planPk10, pk10, new String[] { "createtime" , "updatetime" , "opentime"});
				logger.debug("根据Starte是否等于2查询PK10new表 ,时间为 =" + new Date());
				 selectPk10 = pk10_Service_Im.selectPk10(planPk10.getExpect());
				 if (selectPk10 !=null) {
						pk10.setOpennumber(selectPk10.getNumber());
						System.out.println(selectPk10.getTime());
						pk10.setOpentime(JsonUtils.dateToStrLong(selectPk10.getTime()));
						pk10.setCreatetime(JsonUtils.dateToStrLong(planPk10.getCreatetime()));
						pk10.setUpdatetime(JsonUtils.dateToStrLong(planPk10.getUpdatetime()));
						pl.add(pk10);
					}else {
						if (planPk10.getOpentime() != null) {
							pk10.setOpentime(JsonUtils.dateToStrLong(planPk10.getOpentime()));
							}
							pk10.setCreatetime(JsonUtils.dateToStrLong(planPk10.getCreatetime()));
							pk10.setUpdatetime(JsonUtils.dateToStrLong(planPk10.getUpdatetime()));
							pl.add(pk10);
					
			}
		}
		map.put("list", pl);
		return StatceCode.MapCodeEntity(10001,"查询成功！", map);
	}
}

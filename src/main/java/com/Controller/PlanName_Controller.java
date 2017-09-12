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

import com.EntityUtil.UtilPlanName;
import com.Pojo.AccountInfo;
import com.Pojo.PlanName;
import com.Service.AccountInfo_Service;
import com.Service.PlanNameService;
import com.util.EUDataGridResult;
import com.util.Encrypt;
import com.util.JStringKit;
import com.util.JsonUtils;
import com.util.StatceCode;

@Controller
@RequestMapping("/PlanName/plan")
public class PlanName_Controller {
	
	@Autowired
	private PlanNameService planNameService;
	
	@Autowired
	private AccountInfo_Service accountInfo_Service;
	
	private static final Logger logger = Logger.getLogger(Account_Controller.class);
	
	@RequestMapping(value = "/save", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String createContentCategory(String accountId , String name , String description , String type) {
		PlanName plName = new PlanName();
		if(JStringKit.isBlank(accountId)){
			return StatceCode.MapCode(10001,"accountid不能为空", null);
		}
		plName.setAccountid(Long.parseLong(Encrypt.AseJie(accountId)));
		if(JStringKit.isBlank(name)){
			return StatceCode.MapCode(10001,"name不能为空", null);
		}
		plName.setName(name);
		if(JStringKit.isBlank(description)){
			return StatceCode.MapCode(10001,"description不能为空", null);
		}
		plName.setDescription(description);
		if(!JStringKit.isBlank(type)){
		plName.setType(Integer.parseInt(type));
		}
		plName.setType(1);
		plName.setCreatetime(new Date());
		plName.setUpdatetime(new Date());
		logger.debug("插入PlanName表 accountId =" + plName.getAccountid() + " name =" + name + " description = " +description + "类型" + type);
		int insert = planNameService.insertPlanName(plName);
		if(insert == 0){
			return StatceCode.MapCode(10001,"增加失败！", null);
		}
		return StatceCode.MapCode(10001,"增加成功！", null);
	}
	
	@RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String PlanNameList(String accountId , String page , String size , String sort , String type ) {
		String aseJie = "";
		if(JStringKit.notBlank(accountId)){
			aseJie = Encrypt.AseJie(accountId);
		}
		if(JStringKit.isBlank(page)){
			page="1";
		}
		if(JStringKit.isBlank(size)){
			size="10";
		}
		logger.debug("PlanName分页, accountId = " + aseJie + " 第几页 =" + page + " 每一页的数据条数 =" + size);
		EUDataGridResult carTreeNodesList = planNameService.getCarTreeNodesList(aseJie, page, size, sort, type);
		if (carTreeNodesList.getRows().size()==0) {
			return StatceCode.MapCodeEntity(10001, "PlanName没有这个id", null);
		}
		com.util.Result eResult = new com.util.Result();
		List<UtilPlanName> list = new ArrayList<UtilPlanName>();
		for (int i = 0; i < carTreeNodesList.getRows().size(); i++) {
			PlanName pa = (PlanName) carTreeNodesList.getRows().get(i);
			AccountInfo selectPwd = accountInfo_Service.selectPwd(new Long(pa.getAccountid()).intValue());
			UtilPlanName pName = new UtilPlanName();
			BeanUtils.copyProperties(pa, pName, new String[] { "accountid","createtime" , "updatetime","username","phonenumber","realname","headimg","email","wechat"});
			pName.setCreatetime(JsonUtils.dateToStrLong(pa.getCreatetime()));
			pName.setUpdatetime(JsonUtils.dateToStrLong(pa.getUpdatetime()));
			pName.setAccountid(Encrypt.AseJia(pa.getAccountid().toString()));
			BeanUtils.copyProperties(selectPwd, pName, new String[] { "id" , "description","accountid","name","type","createtime","updatetime"});
			list.add(pName);
		}
		eResult.setList(list);
		return StatceCode.Fname(1001, "获取成功", carTreeNodesList.getTotal(), eResult);
	}
}

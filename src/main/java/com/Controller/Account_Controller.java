package com.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EntityUtil.UtilAccountInfo;
import com.EntityUtil.UtilAcountFund;
import com.Pojo.AccountInfo;
import com.Service.AccountInfo_Service;
import com.Service.AcountFund_Service;
import com.util.Encrypt;
import com.util.JStringKit;
import com.util.StatceCode;

@Controller
@RequestMapping("/account/category")
public class Account_Controller {

	@Autowired
	private AccountInfo_Service accountInfo_Service;

	@Autowired
	private AcountFund_Service acountFund_Service;

	private static final Logger logger = Logger.getLogger(Account_Controller.class);

	@RequestMapping(value = "/save", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String createContentCategory(AccountInfo accountInfo) {
		if(JStringKit.isBlank(accountInfo.getUsername())){
			return StatceCode.MapCode(10001,"姓名不能为空", null);
		}
		if(JStringKit.isBlank(accountInfo.getPassword())){
			return StatceCode.MapCode(10001,"密码不能为空", null);
		}
		if(JStringKit.isBlank(accountInfo.getPhonenumber())){
			return StatceCode.MapCode(10001,"手机号不能为空", null);
		}
		if(JStringKit.isBlank(accountInfo.getRealname())){
			return StatceCode.MapCode(10001,"邮箱不能为空", null);
		}
		logger.debug("注册： 昵称为 ：" + accountInfo.getUsername() + "密码为：" + accountInfo.getPassword() + "手机号为 ：" +accountInfo.getPhonenumber() + "邮箱为 ：" + accountInfo.getEmail() + "注册时间" + new Date());
		System.out.println(accountInfo.getPhonenumber());
		AccountInfo selectByNameKey = accountInfo_Service.selectByNameKey(accountInfo.getPhonenumber());
		if(selectByNameKey != null){
			return StatceCode.MapCode(10001,"该手机已经注册！", null);
		}
		Date date = new Date();
		accountInfo.setCreatetime(date);
		accountInfo.setUpdatetime(date);
		accountInfo.setPassword(Encrypt.md5(accountInfo.getPassword()));
		int count = accountInfo_Service.insertAccountInfo(accountInfo);
		if(count == 0){
			return StatceCode.MapCode(10001,"注册失败！", null);
		}
		AccountInfo acount = accountInfo_Service.selectByNameKey(accountInfo.getPhonenumber());
		acountFund_Service.insertAcountFund(acount.getId(), acount.getCreatetime(), acount.getUpdatetime());
		return StatceCode.MapCode(10001,"注册成功！", null);
	}
	
	@RequestMapping(value = "/login", produces=MediaType.APPLICATION_JSON_VALUE+ ";charset=utf-8")
	@ResponseBody
	public String Login(String userName, String password) {
		if(JStringKit.isBlank(userName)){
			return StatceCode.MapCode(10001,"昵称不能为空", null);
		}
		if(JStringKit.isBlank(password)){
			return StatceCode.MapCode(10001,"密码不能为空", null);
		}
		logger.debug("登录 : 昵称 " + userName + "密码 :" + password + "登录时间" + new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		UtilAccountInfo login = null;
		try {
			 login = accountInfo_Service.selectByLogin(userName, Encrypt.md5(password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(login == null){
			return StatceCode.MapCode(10001,"登录失败,用户或密码错误！", null);
		}
		UtilAcountFund seFund = acountFund_Service.selectBycount(login.getId());
		String id = Encrypt.AseJia(Integer.toString(login.getId()));  
		login.setId(-1);
		seFund.setAccountid(-1);
		map.put("accountInfo", login);
		map.put("acountFund", seFund);
		return StatceCode.CodeMap(10001,"登录成功",id, map);
	}

	@RequestMapping(value = "/updatepwd", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateAccountPwd(String id, String pwd, String password) {
		if(JStringKit.isBlank(id)){
			return StatceCode.MapCode(10001,"id不能为空", null);
		}
		if(JStringKit.isBlank(pwd)){
			return StatceCode.MapCode(10001,"旧密码不能为空", null);
		}
		if(JStringKit.isBlank(password)){
			return StatceCode.MapCode(10001,"新密码不能为空", null);
		}
		String aseJie = Encrypt.AseJie(id);
		AccountInfo acInfo = accountInfo_Service.selectPwd(Integer.parseInt(aseJie));
		if(acInfo == null){
			return StatceCode.MapCode(10001,"id输入错误", null);
		}
		if(!acInfo.getPassword().equals(Encrypt.md5(pwd))){
			return StatceCode.MapCode(10001,"旧密码输入错误", null);
		}
		logger.debug("修改密码 : id " + aseJie + "旧密码 :" + pwd + "新密码 :" + password + "修改时间" + new Date());
		acInfo.setPassword(Encrypt.md5(password));
		acInfo.setUpdatetime(new Date());
		int up = accountInfo_Service.updateAccount(acInfo);
		if(up == 0){
			return StatceCode.MapCode(10001,"修改失败，请重新尝试", null);
		}
			return StatceCode.MapCodeEntity(10001,"修改密码成功", null);
	}
}

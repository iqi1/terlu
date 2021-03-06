/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.terlu.modules.entity.TlContract;
import com.terlu.modules.entity.TlDriverZj;
import com.terlu.modules.service.TlContractService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 合同添加Controller
 * @author wangqi
 * @version 2020-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlContract")
public class TlContractController extends BaseController {

	@Autowired
	private TlContractService tlContractService;
	
	@ModelAttribute
	public TlContract get(@RequestParam(required=false) String id) {
		TlContract entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlContractService.get(id);
		}
		if (entity == null){
			entity = new TlContract();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlContract:edit")
	@RequestMapping(value = {"formView"})
	public String formView(TlContract tlContract, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		Page<TlContract> page = tlContractService.findPage(new Page<TlContract>(request, response), tlContract); 
		model.addAttribute("page", page);
		model.addAttribute("tlContract", tlContract);
		return "terlu/modules/tlContractAuditPage";
	}

	@RequiresPermissions("modules:tlContract:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlContract tlContract, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlContract> page = tlContractService.findPage(new Page<TlContract>(request, response), tlContract); 
		model.addAttribute("page", page);
		return "terlu/modules/tlContractList";
	}
	
	@RequiresPermissions("modules:tlContract:view")
	@RequestMapping(value = "form")
	public String form(TlContract tlContract, Model model) {
		model.addAttribute("tlContract", tlContract);
//		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
//		String applyId = "";
//		String originalContractId = null;
//		String contractCode = null;
//		String a = "00001";
//		List<TlContract> list = tlContractService.findList(tlContract);
//		if(list.size()!=0) {
//			TlContract contract = list.get(0);
//			String dbApplyId = contract.getApplyId();
//			String serialNum = dbApplyId.substring(10, 16);
//			int b = Integer.valueOf(serialNum);
//			b = b++;
//			String c = String.valueOf(b);
//			applyId = "CN" + date + c;
//			originalContractId = applyId;
//			contractCode = "C"+date+c;
//			tlContract.setApplyId(applyId);
//			tlContract.setOriginalContractId(originalContractId);
//			tlContract.setContractCode(contractCode);
//		}else {
//			applyId = "CN"+date+a;
//			originalContractId = applyId;
//			contractCode = "C"+date+a;
//			tlContract.setApplyId(applyId);
//			tlContract.setOriginalContractId(originalContractId);
//			tlContract.setContractCode(contractCode);
//		}
		return "terlu/modules/tlContractForm";
	}
	
	@RequiresPermissions("modules:tlContract:edit")
	@RequestMapping(value = "save")
	public String save(TlContract tlContract, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlContract)){
			return form(tlContract, model);
		}
		tlContractService.save(tlContract);
		addMessage(redirectAttributes, "保存合同添加成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlContract/?repage";
	}
	
	@RequiresPermissions("modules:tlContract:edit")
	@RequestMapping(value = "delete")
	public String delete(TlContract tlContract, RedirectAttributes redirectAttributes) {
		tlContractService.delete(tlContract);
		addMessage(redirectAttributes, "删除合同添加成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlContract/?repage";
	}
	
	//流程处理
		@RequiresPermissions("modules:tlContract:audit")
		@RequestMapping(value = {"listTodo"})
		public String listTodo(TlContract tlContract, HttpServletRequest request, HttpServletResponse response, Model model) {
			Page<TlContract> page = tlContractService.findToDoTaskPage(tlContract);
			model.addAttribute("page", page);
			return "terlu/modules/tlContractList";
		}
		
		@RequiresPermissions("modules:tlContract:audit")
		@RequestMapping(value = "formAudit")
		public String formAudit(TlContract tlContract, Model model, RedirectAttributes redirectAttributes) {
			model.addAttribute("tlContract",tlContract);
			return "terlu/modules/tlContractAudit";
		}
		
		@RequiresPermissions("modules:tlContract:edit")
		@RequestMapping(value = "submitAudit")
		public String submitAudit(TlContract tlContract, Model model, RedirectAttributes redirectAttributes) {
			tlContractService.submitAudit(tlContract);
			addMessage(redirectAttributes, "保存合同申请表成功");
			return "redirect:"+Global.getAdminPath()+"/modules/tlContract/list";
		}
		
		@RequiresPermissions("modules:tlContract:audit")
		@RequestMapping(value = "audit")
		public String audit(TlContract tlContract, Model model, RedirectAttributes redirectAttributes) {
			if(tlContract.getStatus() == 2) {
				return submitAudit(tlContract,model, redirectAttributes);
			}
			tlContractService.audit(tlContract);
			addMessage(redirectAttributes, "保存合同申请表成功");
			return "redirect:"+Global.getAdminPath()+"/modules/tlContract/listTodo";
		}

}
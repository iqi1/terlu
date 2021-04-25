/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.terlu.modules.entity.TlSettleAccounts;
import com.terlu.modules.service.TlSettleAccountsService;

/**
 * 结算统计Controller
 * @author wangqi
 * @version 2020-02-20
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlSettleAccounts")
public class TlSettleAccountsController extends BaseController {

	@Autowired
	private TlSettleAccountsService tlSettleAccountsService;
	
	@ModelAttribute
	public TlSettleAccounts get(@RequestParam(required=false) String id) {
		TlSettleAccounts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlSettleAccountsService.get(id);
		}
		if (entity == null){
			entity = new TlSettleAccounts();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlSettleAccounts:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlSettleAccounts tlSettleAccounts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlSettleAccounts> page = tlSettleAccountsService.findPage(new Page<TlSettleAccounts>(request, response), tlSettleAccounts); 
		model.addAttribute("page", page);
		return "terlu/modules/tlSettleAccountsList";
	}

	@RequiresPermissions("modules:tlSettleAccounts:view")
	@RequestMapping(value = "form")
	public String form(TlSettleAccounts tlSettleAccounts, Model model) {
		model.addAttribute("tlSettleAccounts", tlSettleAccounts);
		return "terlu/modules/tlSettleAccountsForm";
	}

	@RequiresPermissions("modules:tlSettleAccounts:edit")
	@RequestMapping(value = "save")
	public String save(TlSettleAccounts tlSettleAccounts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlSettleAccounts)){
			return form(tlSettleAccounts, model);
		}
		tlSettleAccountsService.save(tlSettleAccounts);
		addMessage(redirectAttributes, "保存结算统计成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSettleAccounts/?repage";
	}
	
	@RequiresPermissions("modules:tlSettleAccounts:edit")
	@RequestMapping(value = "delete")
	public String delete(TlSettleAccounts tlSettleAccounts, RedirectAttributes redirectAttributes) {
		tlSettleAccountsService.delete(tlSettleAccounts);
		addMessage(redirectAttributes, "删除结算统计成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSettleAccounts/?repage";
	}

}
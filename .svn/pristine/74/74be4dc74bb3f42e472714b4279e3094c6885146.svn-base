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
import com.terlu.modules.entity.TlProjectPlan;
import com.terlu.modules.service.TlProjectPlanService;

/**
 * 项目计划Controller
 * @author wangqi
 * @version 2020-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlProjectPlan")
public class TlProjectPlanController extends BaseController {

	@Autowired
	private TlProjectPlanService tlProjectPlanService;
	
	@ModelAttribute
	public TlProjectPlan get(@RequestParam(required=false) String id) {
		TlProjectPlan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlProjectPlanService.get(id);
		}
		if (entity == null){
			entity = new TlProjectPlan();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlProjectPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlProjectPlan tlProjectPlan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlProjectPlan> page = tlProjectPlanService.findPage(new Page<TlProjectPlan>(request, response), tlProjectPlan); 
		model.addAttribute("page", page);
		return "terlu/modules/tlProjectPlanList";
	}

	@RequiresPermissions("modules:tlProjectPlan:view")
	@RequestMapping(value = "form")
	public String form(TlProjectPlan tlProjectPlan, Model model) {
		model.addAttribute("tlProjectPlan", tlProjectPlan);
		return "terlu/modules/tlProjectPlanForm";
	}

	@RequiresPermissions("modules:tlProjectPlan:edit")
	@RequestMapping(value = "save")
	public String save(TlProjectPlan tlProjectPlan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlProjectPlan)){
			return form(tlProjectPlan, model);
		}
		tlProjectPlanService.save(tlProjectPlan);
		addMessage(redirectAttributes, "保存项目计划成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlProjectPlan/?repage";
	}
	
	@RequiresPermissions("modules:tlProjectPlan:edit")
	@RequestMapping(value = "delete")
	public String delete(TlProjectPlan tlProjectPlan, RedirectAttributes redirectAttributes) {
		tlProjectPlanService.delete(tlProjectPlan);
		addMessage(redirectAttributes, "删除项目计划成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlProjectPlan/?repage";
	}

}
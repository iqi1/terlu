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
import com.terlu.modules.entity.TlTestCarPlan;
import com.terlu.modules.service.TlTestCarPlanService;

/**
 * 测试车俩 计划Controller
 * @author sunlifeng
 * @version 2020-05-14
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlTestCarPlan")
public class TlTestCarPlanController extends BaseController {

	@Autowired
	private TlTestCarPlanService tlTestCarPlanService;
	
	@ModelAttribute
	public TlTestCarPlan get(@RequestParam(required=false) String id) {
		TlTestCarPlan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlTestCarPlanService.get(id);
		}
		if (entity == null){
			entity = new TlTestCarPlan();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlTestCarPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlTestCarPlan tlTestCarPlan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlTestCarPlan> page = tlTestCarPlanService.findPage(new Page<TlTestCarPlan>(request, response), tlTestCarPlan); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestCarPlanList";
	}

	@RequiresPermissions("modules:tlTestCarPlan:view")
	@RequestMapping(value = "form")
	public String form(TlTestCarPlan tlTestCarPlan, Model model) {
		model.addAttribute("tlTestCarPlan", tlTestCarPlan);
		return "terlu/modules/tlTestCarPlanForm";
	}

	@RequiresPermissions("modules:tlTestCarPlan:edit")
	@RequestMapping(value = "save")
	public String save(TlTestCarPlan tlTestCarPlan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlTestCarPlan)){
			return form(tlTestCarPlan, model);
		}
		tlTestCarPlanService.save(tlTestCarPlan);
		addMessage(redirectAttributes, "保存测试车俩 计划成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestCarPlan/?repage";
	}
	
	@RequiresPermissions("modules:tlTestCarPlan:edit")
	@RequestMapping(value = "delete")
	public String delete(TlTestCarPlan tlTestCarPlan, RedirectAttributes redirectAttributes) {
		tlTestCarPlanService.delete(tlTestCarPlan);
		addMessage(redirectAttributes, "删除测试车俩 计划成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestCarPlan/?repage";
	}

}
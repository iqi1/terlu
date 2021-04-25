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
import com.terlu.modules.entity.TlMainSchedule;
import com.terlu.modules.service.TlMainScheduleService;

/**
 * 周计划主表Controller
 * @author wangqi
 * @version 2020-05-08
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlMainSchedule")
public class TlMainScheduleController extends BaseController {

	@Autowired
	private TlMainScheduleService tlMainScheduleService;
	
	@ModelAttribute
	public TlMainSchedule get(@RequestParam(required=false) String id) {
		TlMainSchedule entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlMainScheduleService.get(id);
		}
		if (entity == null){
			entity = new TlMainSchedule();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlMainSchedule:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlMainSchedule tlMainSchedule, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlMainSchedule> page = tlMainScheduleService.findPage(new Page<TlMainSchedule>(request, response), tlMainSchedule); 
		model.addAttribute("page", page);
		return "terlu/modules/tlMainScheduleList";
	}

	@RequiresPermissions("modules:tlMainSchedule:view")
	@RequestMapping(value = "form")
	public String form(TlMainSchedule tlMainSchedule, Model model) {
		model.addAttribute("tlMainSchedule", tlMainSchedule);
		return "terlu/modules/tlMainScheduleForm";
	}

	@RequiresPermissions("modules:tlMainSchedule:edit")
	@RequestMapping(value = "save")
	public String save(TlMainSchedule tlMainSchedule, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlMainSchedule)){
			return form(tlMainSchedule, model);
		}
		tlMainScheduleService.save(tlMainSchedule);
		addMessage(redirectAttributes, "保存周计划主表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlMainSchedule/?repage";
	}
	
	@RequiresPermissions("modules:tlMainSchedule:edit")
	@RequestMapping(value = "delete")
	public String delete(TlMainSchedule tlMainSchedule, RedirectAttributes redirectAttributes) {
		tlMainScheduleService.delete(tlMainSchedule);
		addMessage(redirectAttributes, "删除周计划主表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlMainSchedule/?repage";
	}

}
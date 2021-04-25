/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.util.List;

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
import com.terlu.modules.entity.TlWeekSchedule;
import com.terlu.modules.service.TlMainScheduleService;
import com.terlu.modules.service.TlWeekScheduleService;

/**
 * 周计划附表Controller
 * @author wangqi
 * @version 2020-05-08
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlWeekSchedule")
public class TlWeekScheduleController extends BaseController {
	@Autowired
	private TlMainScheduleService tlMainScheduleService;

	@Autowired
	private TlWeekScheduleService tlWeekScheduleService;
	
	@ModelAttribute
	public TlWeekSchedule get(@RequestParam(required=false) String id) {
		TlWeekSchedule entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlWeekScheduleService.get(id);
		}
		if (entity == null){
			entity = new TlWeekSchedule();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlWeekSchedule:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlWeekSchedule tlWeekSchedule, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlWeekSchedule> page = tlWeekScheduleService.findPage(new Page<TlWeekSchedule>(request, response), tlWeekSchedule); 
		model.addAttribute("page", page);
		return "terlu/modules/tlWeekScheduleList";
	}

	@RequiresPermissions("modules:tlWeekSchedule:view")
	@RequestMapping(value = "form")
	public String form(TlWeekSchedule tlWeekSchedule, Model model) {
		model.addAttribute("tlWeekSchedule", tlWeekSchedule);
		List<TlMainSchedule> list = tlMainScheduleService.findList(new TlMainSchedule());
		model.addAttribute("list",list);
		return "terlu/modules/tlWeekScheduleForm";
	}

	@RequiresPermissions("modules:tlWeekSchedule:edit")
	@RequestMapping(value = "save")
	public String save(TlWeekSchedule tlWeekSchedule, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlWeekSchedule)){
			return form(tlWeekSchedule, model);
		}
		tlWeekScheduleService.save(tlWeekSchedule);
		addMessage(redirectAttributes, "保存周计划附表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlWeekSchedule/?repage";
	}
	
	@RequiresPermissions("modules:tlWeekSchedule:edit")
	@RequestMapping(value = "delete")
	public String delete(TlWeekSchedule tlWeekSchedule, RedirectAttributes redirectAttributes) {
		tlWeekScheduleService.delete(tlWeekSchedule);
		addMessage(redirectAttributes, "删除周计划附表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlWeekSchedule/?repage";
	}

}
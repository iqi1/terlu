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
import com.terlu.modules.entity.TsAppointment;
import com.terlu.modules.service.TsAppointmentService;

/**
 * 试验预约Controller
 * @author sunlifeng
 * @version 2019-12-25
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tsAppointment")
public class TsAppointmentController extends BaseController {

	@Autowired
	private TsAppointmentService tsAppointmentService;
	
	@ModelAttribute
	public TsAppointment get(@RequestParam(required=false) String id) {
		TsAppointment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tsAppointmentService.get(id);
		}
		if (entity == null){
			entity = new TsAppointment();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tsAppointment:view")
	@RequestMapping(value = {"list", ""})
	public String list(TsAppointment tsAppointment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TsAppointment> page = tsAppointmentService.findPage(new Page<TsAppointment>(request, response), tsAppointment); 
		model.addAttribute("page", page);
		return "terlu/modules/tsAppointmentList";
	}

	@RequiresPermissions("modules:tsAppointment:view")
	@RequestMapping(value = "form")
	public String form(TsAppointment tsAppointment, Model model) {
		model.addAttribute("tsAppointment", tsAppointment);
		return "terlu/modules/tsAppointmentForm";
	}

	@RequiresPermissions("modules:tsAppointment:edit")
	@RequestMapping(value = "save")
	public String save(TsAppointment tsAppointment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tsAppointment)){
			return form(tsAppointment, model);
		}
		tsAppointmentService.save(tsAppointment);
		addMessage(redirectAttributes, "保存试验预约成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tsAppointment/?repage";
	}
	
	@RequiresPermissions("modules:tsAppointment:edit")
	@RequestMapping(value = "delete")
	public String delete(TsAppointment tsAppointment, RedirectAttributes redirectAttributes) {
		tsAppointmentService.delete(tsAppointment);
		addMessage(redirectAttributes, "删除试验预约成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tsAppointment/?repage";
	}

}
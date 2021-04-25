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
import com.terlu.modules.entity.TlCarTestGroundDriver;
import com.terlu.modules.service.TlCarTestGroundDriverService;

/**
 * 驾驶员管理Controller
 * @author wangqi
 * @version 2020-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlCarTestGroundDriver")
public class TlCarTestGroundDriverController extends BaseController {

	@Autowired
	private TlCarTestGroundDriverService tlCarTestGroundDriverService;
	
	@ModelAttribute
	public TlCarTestGroundDriver get(@RequestParam(required=false) String id) {
		TlCarTestGroundDriver entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlCarTestGroundDriverService.get(id);
		}
		if (entity == null){
			entity = new TlCarTestGroundDriver();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlCarTestGroundDriver:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlCarTestGroundDriver tlCarTestGroundDriver, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlCarTestGroundDriver> page = tlCarTestGroundDriverService.findPage(new Page<TlCarTestGroundDriver>(request, response), tlCarTestGroundDriver); 
		model.addAttribute("page", page);
		return "terlu/modules/tlCarTestGroundDriverList";
	}

	@RequiresPermissions("modules:tlCarTestGroundDriver:view")
	@RequestMapping(value = "form")
	public String form(TlCarTestGroundDriver tlCarTestGroundDriver, Model model) {
		model.addAttribute("tlCarTestGroundDriver", tlCarTestGroundDriver);
		return "terlu/modules/tlCarTestGroundDriverForm";
	}

	@RequiresPermissions("modules:tlCarTestGroundDriver:edit")
	@RequestMapping(value = "save")
	public String save(TlCarTestGroundDriver tlCarTestGroundDriver, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlCarTestGroundDriver)){
			return form(tlCarTestGroundDriver, model);
		}
		tlCarTestGroundDriverService.save(tlCarTestGroundDriver);
		addMessage(redirectAttributes, "保存驾驶员管理成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCarTestGroundDriver/?repage";
	}
	
	@RequiresPermissions("modules:tlCarTestGroundDriver:edit")
	@RequestMapping(value = "delete")
	public String delete(TlCarTestGroundDriver tlCarTestGroundDriver, RedirectAttributes redirectAttributes) {
		tlCarTestGroundDriverService.delete(tlCarTestGroundDriver);
		addMessage(redirectAttributes, "删除驾驶员管理成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCarTestGroundDriver/?repage";
	}

}
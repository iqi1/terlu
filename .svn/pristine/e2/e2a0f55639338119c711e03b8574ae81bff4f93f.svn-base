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
import com.terlu.modules.entity.TlDynamicGetEq;
import com.terlu.modules.service.TlDynamicGetEqService;

/**
 * 动态获取设备使用记录Controller
 * @author wangqi
 * @version 2020-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlDynamicGetEq")
public class TlDynamicGetEqController extends BaseController {

	@Autowired
	private TlDynamicGetEqService tlDynamicGetEqService;
	
	@ModelAttribute
	public TlDynamicGetEq get(@RequestParam(required=false) String id) {
		TlDynamicGetEq entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlDynamicGetEqService.get(id);
		}
		if (entity == null){
			entity = new TlDynamicGetEq();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlDynamicGetEq:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlDynamicGetEq tlDynamicGetEq, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDynamicGetEq> page = tlDynamicGetEqService.findPage(new Page<TlDynamicGetEq>(request, response), tlDynamicGetEq); 
		model.addAttribute("page", page);
		return "terlu/modules/tlDynamicGetEqList";
	}

	@RequiresPermissions("modules:tlDynamicGetEq:view")
	@RequestMapping(value = "form")
	public String form(TlDynamicGetEq tlDynamicGetEq, Model model) {
		model.addAttribute("tlDynamicGetEq", tlDynamicGetEq);
		return "terlu/modules/tlDynamicGetEqForm";
	}

	@RequiresPermissions("modules:tlDynamicGetEq:edit")
	@RequestMapping(value = "save")
	public String save(TlDynamicGetEq tlDynamicGetEq, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlDynamicGetEq)){
			return form(tlDynamicGetEq, model);
		}
		tlDynamicGetEqService.save(tlDynamicGetEq);
		addMessage(redirectAttributes, "保存动态获取设备使用记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDynamicGetEq/?repage";
	}
	
	@RequiresPermissions("modules:tlDynamicGetEq:edit")
	@RequestMapping(value = "delete")
	public String delete(TlDynamicGetEq tlDynamicGetEq, RedirectAttributes redirectAttributes) {
		tlDynamicGetEqService.delete(tlDynamicGetEq);
		addMessage(redirectAttributes, "删除动态获取设备使用记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDynamicGetEq/?repage";
	}

}
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
import com.terlu.modules.entity.TlEquDis;
import com.terlu.modules.service.TlEquDisService;

/**
 * 设备分配表Controller
 * @author wangqi
 * @version 2020-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlEquDis")
public class TlEquDisController extends BaseController {

	@Autowired
	private TlEquDisService tlEquDisService;
	
	@ModelAttribute
	public TlEquDis get(@RequestParam(required=false) String id) {
		TlEquDis entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlEquDisService.get(id);
		}
		if (entity == null){
			entity = new TlEquDis();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlEquDis:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlEquDis tlEquDis, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlEquDis> page = tlEquDisService.findPage(new Page<TlEquDis>(request, response), tlEquDis); 
		model.addAttribute("page", page);
		return "terlu/modules/tlEquDisList";
	}

	@RequiresPermissions("modules:tlEquDis:view")
	@RequestMapping(value = "form")
	public String form(TlEquDis tlEquDis, Model model) {
		model.addAttribute("tlEquDis", tlEquDis);
		return "terlu/modules/tlEquDisForm";
	}

	@RequiresPermissions("modules:tlEquDis:edit")
	@RequestMapping(value = "save")
	public String save(TlEquDis tlEquDis, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlEquDis)){
			return form(tlEquDis, model);
		}
		tlEquDisService.save(tlEquDis);
		addMessage(redirectAttributes, "保存设备分配表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlEquDis/?repage";
	}
	
	@RequiresPermissions("modules:tlEquDis:edit")
	@RequestMapping(value = "delete")
	public String delete(TlEquDis tlEquDis, RedirectAttributes redirectAttributes) {
		tlEquDisService.delete(tlEquDis);
		addMessage(redirectAttributes, "删除设备分配表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlEquDis/?repage";
	}

}
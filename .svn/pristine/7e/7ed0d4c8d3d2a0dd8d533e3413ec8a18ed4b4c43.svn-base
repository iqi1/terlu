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
import com.terlu.modules.entity.TlStaticWriteEq;
import com.terlu.modules.service.TlStaticWriteEqService;

/**
 * 静态录入设备信息表Controller
 * @author wangqi
 * @version 2020-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlStaticWriteEq")
public class TlStaticWriteEqController extends BaseController {

	@Autowired
	private TlStaticWriteEqService tlStaticWriteEqService;
	
	@ModelAttribute
	public TlStaticWriteEq get(@RequestParam(required=false) String id) {
		TlStaticWriteEq entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlStaticWriteEqService.get(id);
		}
		if (entity == null){
			entity = new TlStaticWriteEq();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlStaticWriteEq:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlStaticWriteEq tlStaticWriteEq, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlStaticWriteEq> page = tlStaticWriteEqService.findPage(new Page<TlStaticWriteEq>(request, response), tlStaticWriteEq); 
		model.addAttribute("page", page);
		return "terlu/modules/tlStaticWriteEqList";
	}

	@RequiresPermissions("modules:tlStaticWriteEq:view")
	@RequestMapping(value = "form")
	public String form(TlStaticWriteEq tlStaticWriteEq, Model model) {
		model.addAttribute("tlStaticWriteEq", tlStaticWriteEq);
		return "terlu/modules/tlStaticWriteEqForm";
	}

	@RequiresPermissions("modules:tlStaticWriteEq:edit")
	@RequestMapping(value = "save")
	public String save(TlStaticWriteEq tlStaticWriteEq, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlStaticWriteEq)){
			return form(tlStaticWriteEq, model);
		}
		tlStaticWriteEqService.save(tlStaticWriteEq);
		addMessage(redirectAttributes, "保存静态录入设备信息表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlStaticWriteEq/?repage";
	}
	
	@RequiresPermissions("modules:tlStaticWriteEq:edit")
	@RequestMapping(value = "delete")
	public String delete(TlStaticWriteEq tlStaticWriteEq, RedirectAttributes redirectAttributes) {
		tlStaticWriteEqService.delete(tlStaticWriteEq);
		addMessage(redirectAttributes, "删除静态录入设备信息表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlStaticWriteEq/?repage";
	}

}
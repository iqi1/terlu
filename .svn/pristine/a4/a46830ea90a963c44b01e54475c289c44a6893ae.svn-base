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
import com.terlu.modules.entity.TlVistorRegister;
import com.terlu.modules.service.TlVistorRegisterService;

/**
 * 到访人员信息登记Controller
 * @author sunlifeng
 * @version 2019-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlVistorRegister")
public class TlVistorRegisterController extends BaseController {

	@Autowired
	private TlVistorRegisterService tlVistorRegisterService;
	
	@ModelAttribute
	public TlVistorRegister get(@RequestParam(required=false) String id) {
		TlVistorRegister entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlVistorRegisterService.get(id);
		}
		if (entity == null){
			entity = new TlVistorRegister();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlVistorRegister:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlVistorRegister tlVistorRegister, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlVistorRegister> page = tlVistorRegisterService.findPage(new Page<TlVistorRegister>(request, response), tlVistorRegister); 
		model.addAttribute("page", page);
		return "terlu/modules/tlVistorRegisterList";
	}

	@RequiresPermissions("modules:tlVistorRegister:view")
	@RequestMapping(value = "form")
	public String form(TlVistorRegister tlVistorRegister, Model model) {
		model.addAttribute("tlVistorRegister", tlVistorRegister);
		return "terlu/modules/tlVistorRegisterForm";
	}

	@RequiresPermissions("modules:tlVistorRegister:edit")
	@RequestMapping(value = "save")
	public String save(TlVistorRegister tlVistorRegister, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlVistorRegister)){
			return form(tlVistorRegister, model);
		}
		tlVistorRegisterService.save(tlVistorRegister);
		addMessage(redirectAttributes, "保存到访人员信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlVistorRegister/?repage";
	}
	
	@RequiresPermissions("modules:tlVistorRegister:edit")
	@RequestMapping(value = "delete")
	public String delete(TlVistorRegister tlVistorRegister, RedirectAttributes redirectAttributes) {
		tlVistorRegisterService.delete(tlVistorRegister);
		addMessage(redirectAttributes, "删除到访人员信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlVistorRegister/?repage";
	}

}
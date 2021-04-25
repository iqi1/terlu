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
import com.terlu.modules.entity.TlDriverQualification;
import com.terlu.modules.service.TlDriverQualificationService;

/**
 * 驾驶员资质Controller
 * @author wangqi
 * @version 2020-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlDriverQualification")
public class TlDriverQualificationController extends BaseController {

	@Autowired
	private TlDriverQualificationService tlDriverQualificationService;
	
	@ModelAttribute
	public TlDriverQualification get(@RequestParam(required=false) String id) {
		TlDriverQualification entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlDriverQualificationService.get(id);
		}
		if (entity == null){
			entity = new TlDriverQualification();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlDriverQualification:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlDriverQualification tlDriverQualification, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDriverQualification> page = tlDriverQualificationService.findPage(new Page<TlDriverQualification>(request, response), tlDriverQualification); 
		model.addAttribute("page", page);
		return "terlu/modules/tlDriverQualificationList";
	}

	@RequiresPermissions("modules:tlDriverQualification:view")
	@RequestMapping(value = "form")
	public String form(TlDriverQualification tlDriverQualification, Model model) {
		model.addAttribute("tlDriverQualification", tlDriverQualification);
		return "terlu/modules/tlDriverQualificationForm";
	}

	@RequiresPermissions("modules:tlDriverQualification:edit")
	@RequestMapping(value = "save")
	public String save(TlDriverQualification tlDriverQualification, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlDriverQualification)){
			return form(tlDriverQualification, model);
		}
		tlDriverQualificationService.save(tlDriverQualification);
		addMessage(redirectAttributes, "保存驾驶员资质成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverQualification/?repage";
	}
	
	@RequiresPermissions("modules:tlDriverQualification:edit")
	@RequestMapping(value = "delete")
	public String delete(TlDriverQualification tlDriverQualification, RedirectAttributes redirectAttributes) {
		tlDriverQualificationService.delete(tlDriverQualification);
		addMessage(redirectAttributes, "删除驾驶员资质成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverQualification/?repage";
	}

}
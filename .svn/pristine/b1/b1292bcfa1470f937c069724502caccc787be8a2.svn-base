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
import com.terlu.modules.entity.TlTestprojectChild;
import com.terlu.modules.service.TlTestprojectChildService;

/**
 * 试验项目管理Controller
 * @author wangqi
 * @version 2019-12-31
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlTestprojectChild")
public class TlTestprojectChildController extends BaseController {

	@Autowired
	private TlTestprojectChildService tlTestprojectChildService;
	
	@ModelAttribute
	public TlTestprojectChild get(@RequestParam(required=false) String id) {
		TlTestprojectChild entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlTestprojectChildService.get(id);
		}
		if (entity == null){
			entity = new TlTestprojectChild();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlTestprojectChild:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlTestprojectChild tlTestprojectChild, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlTestprojectChild> page = tlTestprojectChildService.findPage(new Page<TlTestprojectChild>(request, response), tlTestprojectChild); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestprojectChildList";
	}

	@RequiresPermissions("modules:tlTestprojectChild:view")
	@RequestMapping(value = "form")
	public String form(TlTestprojectChild tlTestprojectChild, Model model) {
		model.addAttribute("tlTestprojectChild", tlTestprojectChild);
		return "terlu/modules/tlTestprojectChildForm";
	}

	@RequiresPermissions("modules:tlTestprojectChild:edit")
	@RequestMapping(value = "save")
	public String save(TlTestprojectChild tlTestprojectChild,HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlTestprojectChild)){
			return form(tlTestprojectChild, model);
		}
		tlTestprojectChildService.save(tlTestprojectChild);
		addMessage(redirectAttributes, "保存试验项目管理成功");
		
		Page<TlTestprojectChild> page = tlTestprojectChildService.findPage(new Page<TlTestprojectChild>(request, response), tlTestprojectChild); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestprojectChildList";
		//return "redirect:"+Global.getAdminPath()+"/modules/tlTestprojectChild/?repage";
	}
	
	@RequiresPermissions("modules:tlTestprojectChild:edit")
	@RequestMapping(value = "delete")
	public String delete(TlTestprojectChild tlTestprojectChild, RedirectAttributes redirectAttributes) {
		tlTestprojectChildService.delete(tlTestprojectChild);
		addMessage(redirectAttributes, "删除试验项目管理成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestprojectChild/?repage";
	}

}
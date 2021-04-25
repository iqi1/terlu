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
import com.terlu.modules.entity.TlRoadGate;
import com.terlu.modules.service.TlRoadGateService;

/**
 * 闸机信息Controller
 * @author wangqi
 * @version 2020-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlRoadGate")
public class TlRoadGateController extends BaseController {

	@Autowired
	private TlRoadGateService tlRoadGateService;
	
	@ModelAttribute
	public TlRoadGate get(@RequestParam(required=false) String id) {
		TlRoadGate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlRoadGateService.get(id);
		}
		if (entity == null){
			entity = new TlRoadGate();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlRoadGate:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlRoadGate tlRoadGate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlRoadGate> page = tlRoadGateService.findPage(new Page<TlRoadGate>(request, response), tlRoadGate); 
		model.addAttribute("page", page);
		return "terlu/modules/tlRoadGateList";
	}

	@RequiresPermissions("modules:tlRoadGate:view")
	@RequestMapping(value = "form")
	public String form(TlRoadGate tlRoadGate, Model model) {
		model.addAttribute("tlRoadGate", tlRoadGate);
		return "terlu/modules/tlRoadGateForm";
	}

	@RequiresPermissions("modules:tlRoadGate:edit")
	@RequestMapping(value = "save")
	public String save(TlRoadGate tlRoadGate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlRoadGate)){
			return form(tlRoadGate, model);
		}
		tlRoadGateService.save(tlRoadGate);
		addMessage(redirectAttributes, "保存闸机信息成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlRoadGate/?repage";
	}
	
	@RequiresPermissions("modules:tlRoadGate:edit")
	@RequestMapping(value = "delete")
	public String delete(TlRoadGate tlRoadGate, RedirectAttributes redirectAttributes) {
		tlRoadGateService.delete(tlRoadGate);
		addMessage(redirectAttributes, "删除闸机信息成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlRoadGate/?repage";
	}

}
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
import com.terlu.modules.entity.TlMidRoadGate;
import com.terlu.modules.entity.TlRoadGate;
import com.terlu.modules.service.TlMidRoadGateService;
import com.terlu.modules.service.TlRoadGateService;

/**
 * 场地控制Controller
 * @author wangqi
 * @version 2020-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlMidRoadGate")
public class TlMidRoadGateController extends BaseController {

	@Autowired
	private TlMidRoadGateService tlMidRoadGateService;
	
	@Autowired
	private TlRoadGateService tlRoadGateService;
	
	@ModelAttribute
	public TlMidRoadGate get(@RequestParam(required=false) String id) {
		TlMidRoadGate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlMidRoadGateService.get(id);
		}
		if (entity == null){
			entity = new TlMidRoadGate();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlMidRoadGate:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlMidRoadGate tlMidRoadGate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlMidRoadGate> page = tlMidRoadGateService.findPage(new Page<TlMidRoadGate>(request, response), tlMidRoadGate); 
		model.addAttribute("page", page);
//		List<TlRoadGate> list =  tlRoadGateService.findList(new TlRoadGate());
//		model.addAttribute("list",list);
		return "terlu/modules/tlMidRoadGateList";
	}

	@RequiresPermissions("modules:tlMidRoadGate:view")
	@RequestMapping(value = "form")
	public String form(TlMidRoadGate tlMidRoadGate, Model model) {
		model.addAttribute("tlMidRoadGate", tlMidRoadGate);
		List<TlRoadGate> list =  tlRoadGateService.findList(new TlRoadGate());
		model.addAttribute("list",list);
		return "terlu/modules/tlMidRoadGateForm";
	}

	@RequiresPermissions("modules:tlMidRoadGate:edit")
	@RequestMapping(value = "save")
	public String save(TlMidRoadGate tlMidRoadGate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlMidRoadGate)){
			return form(tlMidRoadGate, model);
		}
		tlMidRoadGateService.save(tlMidRoadGate);
		addMessage(redirectAttributes, "保存场地控制成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlMidRoadGate/?repage";
	}
	
	@RequiresPermissions("modules:tlMidRoadGate:edit")
	@RequestMapping(value = "delete")
	public String delete(TlMidRoadGate tlMidRoadGate, RedirectAttributes redirectAttributes) {
		tlMidRoadGateService.delete(tlMidRoadGate);
		addMessage(redirectAttributes, "删除场地控制成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlMidRoadGate/?repage";
	}

}
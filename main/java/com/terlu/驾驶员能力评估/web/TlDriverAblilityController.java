/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.驾驶员能力评估.web;

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
import com.terlu.驾驶员能力评估.entity.TlDriverAblility;
import com.terlu.驾驶员能力评估.service.TlDriverAblilityService;

/**
 * 驾驶员能力评估Controller
 * @author wangqi
 * @version 2020-06-02
 */
@Controller
@RequestMapping(value = "${adminPath}/驾驶员能力评估/tlDriverAblility")
public class TlDriverAblilityController extends BaseController {

	@Autowired
	private TlDriverAblilityService tlDriverAblilityService;
	
	@ModelAttribute
	public TlDriverAblility get(@RequestParam(required=false) String id) {
		TlDriverAblility entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlDriverAblilityService.get(id);
		}
		if (entity == null){
			entity = new TlDriverAblility();
		}
		return entity;
	}
	
	@RequiresPermissions("驾驶员能力评估:tlDriverAblility:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlDriverAblility tlDriverAblility, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDriverAblility> page = tlDriverAblilityService.findPage(new Page<TlDriverAblility>(request, response), tlDriverAblility); 
		model.addAttribute("page", page);
		return "terlu/驾驶员能力评估/tlDriverAblilityList";
	}

	@RequiresPermissions("驾驶员能力评估:tlDriverAblility:view")
	@RequestMapping(value = "form")
	public String form(TlDriverAblility tlDriverAblility, Model model) {
		model.addAttribute("tlDriverAblility", tlDriverAblility);
		return "terlu/驾驶员能力评估/tlDriverAblilityForm";
	}

	@RequiresPermissions("驾驶员能力评估:tlDriverAblility:edit")
	@RequestMapping(value = "save")
	public String save(TlDriverAblility tlDriverAblility, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlDriverAblility)){
			return form(tlDriverAblility, model);
		}
		tlDriverAblilityService.save(tlDriverAblility);
		addMessage(redirectAttributes, "保存驾驶员能力评估成功");
		return "redirect:"+Global.getAdminPath()+"/驾驶员能力评估/tlDriverAblility/?repage";
	}
	
	@RequiresPermissions("驾驶员能力评估:tlDriverAblility:edit")
	@RequestMapping(value = "delete")
	public String delete(TlDriverAblility tlDriverAblility, RedirectAttributes redirectAttributes) {
		tlDriverAblilityService.delete(tlDriverAblility);
		addMessage(redirectAttributes, "删除驾驶员能力评估成功");
		return "redirect:"+Global.getAdminPath()+"/驾驶员能力评估/tlDriverAblility/?repage";
	}

}
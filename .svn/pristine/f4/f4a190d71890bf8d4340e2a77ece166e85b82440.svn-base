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
import com.terlu.modules.entity.TlGpsTrail;
import com.terlu.modules.service.TlGpsTrailService;

/**
 * 定位轨迹Controller
 * @author wangqi
 * @version 2020-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlGpsTrail")
public class TlGpsTrailController extends BaseController {

	@Autowired
	private TlGpsTrailService tlGpsTrailService;
	
	@ModelAttribute
	public TlGpsTrail get(@RequestParam(required=false) String id) {
		TlGpsTrail entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlGpsTrailService.get(id);
		}
		if (entity == null){
			entity = new TlGpsTrail();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlGpsTrail:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlGpsTrail tlGpsTrail, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlGpsTrail> page = tlGpsTrailService.findPage(new Page<TlGpsTrail>(request, response), tlGpsTrail); 
		model.addAttribute("page", page);
		return "terlu/modules/tlGpsTrailList";
	}

	@RequiresPermissions("modules:tlGpsTrail:view")
	@RequestMapping(value = "form")
	public String form(TlGpsTrail tlGpsTrail, Model model) {
		model.addAttribute("tlGpsTrail", tlGpsTrail);
		return "terlu/modules/tlGpsTrailForm";
	}

	@RequiresPermissions("modules:tlGpsTrail:edit")
	@RequestMapping(value = "save")
	public String save(TlGpsTrail tlGpsTrail, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlGpsTrail)){
			return form(tlGpsTrail, model);
		}
		tlGpsTrailService.save(tlGpsTrail);
		addMessage(redirectAttributes, "保存定位轨迹成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlGpsTrail/?repage";
	}
	
	@RequiresPermissions("modules:tlGpsTrail:edit")
	@RequestMapping(value = "delete")
	public String delete(TlGpsTrail tlGpsTrail, RedirectAttributes redirectAttributes) {
		tlGpsTrailService.delete(tlGpsTrail);
		addMessage(redirectAttributes, "删除定位轨迹成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlGpsTrail/?repage";
	}

}
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
import com.terlu.modules.entity.TlCarInfo;
import com.terlu.modules.service.TlCarInfoService;

/**
 * 车辆信息登记Controller
 * @author wangqi
 * @version 2019-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlCarInfo")
public class TlCarInfoController extends BaseController {

	@Autowired
	private TlCarInfoService tlCarInfoService;
	
	@ModelAttribute
	public TlCarInfo get(@RequestParam(required=false) String id) {
		TlCarInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlCarInfoService.get(id);
		}
		if (entity == null){
			entity = new TlCarInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlCarInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlCarInfo tlCarInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlCarInfo> page = tlCarInfoService.findPage(new Page<TlCarInfo>(request, response), tlCarInfo); 
		model.addAttribute("page", page);
		return "terlu/modules/tlCarInfoList";
	}

	@RequiresPermissions("modules:tlCarInfo:view")
	@RequestMapping(value = "form")
	public String form(TlCarInfo tlCarInfo, Model model) {
		model.addAttribute("tlCarInfo", tlCarInfo);
		return "terlu/modules/tlCarInfoForm";
	}

	@RequiresPermissions("modules:tlCarInfo:edit")
	@RequestMapping(value = "save")
	public String save(TlCarInfo tlCarInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlCarInfo)){
			return form(tlCarInfo, model);
		}
		tlCarInfoService.save(tlCarInfo);
		addMessage(redirectAttributes, "保存车辆信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCarInfo/?repage";
	}
	
	@RequiresPermissions("modules:tlCarInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TlCarInfo tlCarInfo, RedirectAttributes redirectAttributes) {
		tlCarInfoService.delete(tlCarInfo);
		addMessage(redirectAttributes, "删除车辆信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCarInfo/?repage";
	}

}
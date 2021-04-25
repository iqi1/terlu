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
import com.terlu.modules.entity.TlOtherExtendsInfo;
import com.terlu.modules.service.TlOtherExtendsInfoService;

/**
 * 其他扩展信息Controller
 * @author wangqi
 * @version 2020-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlOtherExtendsInfo")
public class TlOtherExtendsInfoController extends BaseController {

	@Autowired
	private TlOtherExtendsInfoService tlOtherExtendsInfoService;
	
	@ModelAttribute
	public TlOtherExtendsInfo get(@RequestParam(required=false) String id) {
		TlOtherExtendsInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlOtherExtendsInfoService.get(id);
		}
		if (entity == null){
			entity = new TlOtherExtendsInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlOtherExtendsInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlOtherExtendsInfo tlOtherExtendsInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlOtherExtendsInfo> page = tlOtherExtendsInfoService.findPage(new Page<TlOtherExtendsInfo>(request, response), tlOtherExtendsInfo); 
		model.addAttribute("page", page);
		return "terlu/modules/tlOtherExtendsInfoList";
	}

	@RequiresPermissions("modules:tlOtherExtendsInfo:view")
	@RequestMapping(value = "form")
	public String form(TlOtherExtendsInfo tlOtherExtendsInfo, Model model) {
		model.addAttribute("tlOtherExtendsInfo", tlOtherExtendsInfo);
		return "terlu/modules/tlOtherExtendsInfoForm";
	}

	@RequiresPermissions("modules:tlOtherExtendsInfo:edit")
	@RequestMapping(value = "save")
	public String save(TlOtherExtendsInfo tlOtherExtendsInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlOtherExtendsInfo)){
			return form(tlOtherExtendsInfo, model);
		}
		tlOtherExtendsInfoService.save(tlOtherExtendsInfo);
		addMessage(redirectAttributes, "保存其他扩展信息成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlOtherExtendsInfo/?repage";
	}
	
	@RequiresPermissions("modules:tlOtherExtendsInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TlOtherExtendsInfo tlOtherExtendsInfo, RedirectAttributes redirectAttributes) {
		tlOtherExtendsInfoService.delete(tlOtherExtendsInfo);
		addMessage(redirectAttributes, "删除其他扩展信息成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlOtherExtendsInfo/?repage";
	}

}
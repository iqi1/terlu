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
import com.terlu.modules.entity.TlPaymentForm;
import com.terlu.modules.service.TlPaymentFormService;

/**
 * 结算单主表Controller
 * @author wangqi
 * @version 2020-02-25
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlPaymentForm")
public class TlPaymentFormController extends BaseController {

	@Autowired
	private TlPaymentFormService tlPaymentFormService;
	
	@ModelAttribute
	public TlPaymentForm get(@RequestParam(required=false) String id) {
		TlPaymentForm entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlPaymentFormService.get(id);
		}
		if (entity == null){
			entity = new TlPaymentForm();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlPaymentForm:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlPaymentForm tlPaymentForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlPaymentForm> page = tlPaymentFormService.findPage(new Page<TlPaymentForm>(request, response), tlPaymentForm); 
		model.addAttribute("page", page);
		return "terlu/modules/tlPaymentFormList";
	}

	@RequiresPermissions("modules:tlPaymentForm:view")
	@RequestMapping(value = "form")
	public String form(TlPaymentForm tlPaymentForm, Model model) {
		model.addAttribute("tlPaymentForm", tlPaymentForm);
		return "terlu/modules/tlPaymentFormForm";
	}

	@RequiresPermissions("modules:tlPaymentForm:edit")
	@RequestMapping(value = "save")
	public String save(TlPaymentForm tlPaymentForm, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlPaymentForm)){
			return form(tlPaymentForm, model);
		}
		tlPaymentFormService.save(tlPaymentForm);
		addMessage(redirectAttributes, "保存结算单主表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlPaymentForm/?repage";
	}
	
	@RequiresPermissions("modules:tlPaymentForm:edit")
	@RequestMapping(value = "delete")
	public String delete(TlPaymentForm tlPaymentForm, RedirectAttributes redirectAttributes) {
		tlPaymentFormService.delete(tlPaymentForm);
		addMessage(redirectAttributes, "删除结算单主表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlPaymentForm/?repage";
	}

}
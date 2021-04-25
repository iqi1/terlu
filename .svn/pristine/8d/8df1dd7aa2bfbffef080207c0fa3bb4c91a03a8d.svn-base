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
import com.terlu.modules.entity.TlFinanceInfo;
import com.terlu.modules.service.TlFinanceInfoService;

/**
 * 财务信息登记Controller
 * @author wangqi
 * @version 2020-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlFinanceInfo")
public class TlFinanceInfoController extends BaseController {

	@Autowired
	private TlFinanceInfoService tlFinanceInfoService;
	
	@ModelAttribute
	public TlFinanceInfo get(@RequestParam(required=false) String id) {
		TlFinanceInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlFinanceInfoService.get(id);
		}
		if (entity == null){
			entity = new TlFinanceInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlFinanceInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlFinanceInfo tlFinanceInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlFinanceInfo> page = tlFinanceInfoService.findPage(new Page<TlFinanceInfo>(request, response), tlFinanceInfo); 
		model.addAttribute("page", page);
		return "terlu/modules/tlFinanceInfoList";
	}

	@RequiresPermissions("modules:tlFinanceInfo:view")
	@RequestMapping(value = "form")
	public String form(TlFinanceInfo tlFinanceInfo, Model model) {
		model.addAttribute("tlFinanceInfo", tlFinanceInfo);
		return "terlu/modules/tlFinanceInfoForm";
	}

	@RequiresPermissions("modules:tlFinanceInfo:edit")
	@RequestMapping(value = "save")
	public String save(TlFinanceInfo tlFinanceInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlFinanceInfo)){
			return form(tlFinanceInfo, model);
		}
		tlFinanceInfoService.save(tlFinanceInfo);
		addMessage(redirectAttributes, "保存财务信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFinanceInfo/?repage";
	}
	
	@RequiresPermissions("modules:tlFinanceInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TlFinanceInfo tlFinanceInfo, RedirectAttributes redirectAttributes) {
		tlFinanceInfoService.delete(tlFinanceInfo);
		addMessage(redirectAttributes, "删除财务信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFinanceInfo/?repage";
	}

}
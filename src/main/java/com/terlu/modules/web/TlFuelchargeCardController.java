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
import com.terlu.modules.entity.TlFuelchargeCard;
import com.terlu.modules.service.TlFuelchargeCardService;

/**
 * 油/电卡Controller
 * @author wangqi
 * @version 2020-02-10
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlFuelchargeCard")
public class TlFuelchargeCardController extends BaseController {

	@Autowired
	private TlFuelchargeCardService tlFuelchargeCardService;
	
	@ModelAttribute
	public TlFuelchargeCard get(@RequestParam(required=false) String id) {
		TlFuelchargeCard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlFuelchargeCardService.get(id);
		}
		if (entity == null){
			entity = new TlFuelchargeCard();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlFuelchargeCard:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlFuelchargeCard tlFuelchargeCard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlFuelchargeCard> page = tlFuelchargeCardService.findPage(new Page<TlFuelchargeCard>(request, response), tlFuelchargeCard); 
		model.addAttribute("page", page);
		return "terlu/modules/tlFuelchargeCardList";
	}

	@RequiresPermissions("modules:tlFuelchargeCard:view")
	@RequestMapping(value = "form")
	public String form(TlFuelchargeCard tlFuelchargeCard, Model model) {
		model.addAttribute("tlFuelchargeCard", tlFuelchargeCard);
		return "terlu/modules/tlFuelchargeCardForm";
	}

	@RequiresPermissions("modules:tlFuelchargeCard:edit")
	@RequestMapping(value = "save")
	public String save(TlFuelchargeCard tlFuelchargeCard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlFuelchargeCard)){
			return form(tlFuelchargeCard, model);
		}
		tlFuelchargeCardService.save(tlFuelchargeCard);
		addMessage(redirectAttributes, "保存油/电卡成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFuelchargeCard/?repage";
	}
	
	@RequiresPermissions("modules:tlFuelchargeCard:edit")
	@RequestMapping(value = "delete")
	public String delete(TlFuelchargeCard tlFuelchargeCard, RedirectAttributes redirectAttributes) {
		tlFuelchargeCardService.delete(tlFuelchargeCard);
		addMessage(redirectAttributes, "删除油/电卡成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFuelchargeCard/?repage";
	}

}
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

import com.terlu.modules.ai.aip.Idcard;
import com.terlu.modules.entity.TlDriverCard;
import com.terlu.modules.service.TlDriverCardService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 驾驶员身份证Controller
 * @author wangqi
 * @version 2020-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlDriverCard")
public class TlDriverCardController extends BaseController {

	@Autowired
	private TlDriverCardService tlDriverCardService;
	
	@ModelAttribute
	public TlDriverCard get(@RequestParam(required=false) String id) {
		TlDriverCard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlDriverCardService.get(id);
		}
		if (entity == null){
			entity = new TlDriverCard();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlDriverCard:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlDriverCard tlDriverCard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDriverCard> page = tlDriverCardService.findPage(new Page<TlDriverCard>(request, response), tlDriverCard); 
		model.addAttribute("page", page);
		return "terlu/modules/tlDriverCardList";
	}

	@RequiresPermissions("modules:tlDriverCard:view")
	@RequestMapping(value = "form")
	public String form(TlDriverCard tlDriverCard, Model model) {
		model.addAttribute("tlDriverCard", tlDriverCard);
		return "terlu/modules/tlDriverCardForm";
	}

	@RequiresPermissions("modules:tlDriverCard:edit")
	@RequestMapping(value = "save")
	public String save(TlDriverCard tlDriverCard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlDriverCard)){
			return form(tlDriverCard, model);
		}
		tlDriverCardService.save(tlDriverCard);
		addMessage(redirectAttributes, "保存驾驶员身份证成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverCard/?repage";
	}
	
	@RequiresPermissions("modules:tlDriverCard:edit")
	@RequestMapping(value = "delete")
	public String delete(TlDriverCard tlDriverCard, RedirectAttributes redirectAttributes) {
		tlDriverCardService.delete(tlDriverCard);
		addMessage(redirectAttributes, "删除驾驶员身份证成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverCard/?repage";
	}
	

}
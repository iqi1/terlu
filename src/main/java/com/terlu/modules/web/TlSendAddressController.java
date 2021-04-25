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
import com.terlu.modules.entity.TlSendAddress;
import com.terlu.modules.service.TlSendAddressService;

/**
 * 寄送信息登记Controller
 * @author wangqi
 * @version 2020-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlSendAddress")
public class TlSendAddressController extends BaseController {

	@Autowired
	private TlSendAddressService tlSendAddressService;
	
	@ModelAttribute
	public TlSendAddress get(@RequestParam(required=false) String id) {
		TlSendAddress entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlSendAddressService.get(id);
		}
		if (entity == null){
			entity = new TlSendAddress();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlSendAddress:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlSendAddress tlSendAddress, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlSendAddress> page = tlSendAddressService.findPage(new Page<TlSendAddress>(request, response), tlSendAddress); 
		model.addAttribute("page", page);
		return "terlu/modules/tlSendAddressList";
	}

	@RequiresPermissions("modules:tlSendAddress:view")
	@RequestMapping(value = "form")
	public String form(TlSendAddress tlSendAddress, Model model) {
		model.addAttribute("tlSendAddress", tlSendAddress);
		return "terlu/modules/tlSendAddressForm";
	}

	@RequiresPermissions("modules:tlSendAddress:edit")
	@RequestMapping(value = "save")
	public String save(TlSendAddress tlSendAddress, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlSendAddress)){
			return form(tlSendAddress, model);
		}
		tlSendAddressService.save(tlSendAddress);
		addMessage(redirectAttributes, "保存寄送信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSendAddress/?repage";
	}
	
	@RequiresPermissions("modules:tlSendAddress:edit")
	@RequestMapping(value = "delete")
	public String delete(TlSendAddress tlSendAddress, RedirectAttributes redirectAttributes) {
		tlSendAddressService.delete(tlSendAddress);
		addMessage(redirectAttributes, "删除寄送信息登记成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSendAddress/?repage";
	}

}
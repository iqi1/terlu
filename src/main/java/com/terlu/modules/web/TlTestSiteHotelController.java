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
import com.terlu.modules.entity.TlTestSiteHotel;
import com.terlu.modules.service.TlTestSiteHotelService;

/**
 * 试验场酒店预定Controller
 * @author wangqi
 * @version 2019-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlTestSiteHotel")
public class TlTestSiteHotelController extends BaseController {

	@Autowired
	private TlTestSiteHotelService tlTestSiteHotelService;
	
	@ModelAttribute
	public TlTestSiteHotel get(@RequestParam(required=false) String id) {
		TlTestSiteHotel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlTestSiteHotelService.get(id);
		}
		if (entity == null){
			entity = new TlTestSiteHotel();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlTestSiteHotel:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlTestSiteHotel tlTestSiteHotel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlTestSiteHotel> page = tlTestSiteHotelService.findPage(new Page<TlTestSiteHotel>(request, response), tlTestSiteHotel); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestSiteHotelList";
	}

	@RequiresPermissions("modules:tlTestSiteHotel:view")
	@RequestMapping(value = "form")
	public String form(TlTestSiteHotel tlTestSiteHotel, Model model) {
		model.addAttribute("tlTestSiteHotel", tlTestSiteHotel);
		return "terlu/modules/tlTestSiteHotelForm";
	}

	@RequiresPermissions("modules:tlTestSiteHotel:edit")
	@RequestMapping(value = "save")
	public String save(TlTestSiteHotel tlTestSiteHotel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlTestSiteHotel)){
			return form(tlTestSiteHotel, model);
		}
		tlTestSiteHotelService.save(tlTestSiteHotel);
		addMessage(redirectAttributes, "保存试验场酒店预定成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestSiteHotel/?repage";
	}
	
	@RequiresPermissions("modules:tlTestSiteHotel:edit")
	@RequestMapping(value = "delete")
	public String delete(TlTestSiteHotel tlTestSiteHotel, RedirectAttributes redirectAttributes) {
		tlTestSiteHotelService.delete(tlTestSiteHotel);
		addMessage(redirectAttributes, "删除试验场酒店预定成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestSiteHotel/?repage";
	}

}
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
import com.terlu.modules.entity.TlTestRoomReservationChild;
import com.terlu.modules.service.TlTestRoomReservationChildService;

/**
 * 测试包场预定Controller
 * @author wangqi
 * @version 2019-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlTestRoomReservationChild")
public class TlTestRoomReservationChildController extends BaseController {

	@Autowired
	private TlTestRoomReservationChildService tlTestRoomReservationChildService;
	
	@ModelAttribute
	public TlTestRoomReservationChild get(@RequestParam(required=false) String id) {
		TlTestRoomReservationChild entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlTestRoomReservationChildService.get(id);
		}
		if (entity == null){
			entity = new TlTestRoomReservationChild();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlTestRoomReservationChild:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlTestRoomReservationChild tlTestRoomReservationChild, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlTestRoomReservationChild> page = tlTestRoomReservationChildService.findPage(new Page<TlTestRoomReservationChild>(request, response), tlTestRoomReservationChild); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestRoomReservationChildList";
	}

	@RequiresPermissions("modules:tlTestRoomReservationChild:view")
	@RequestMapping(value = "form")
	public String form(TlTestRoomReservationChild tlTestRoomReservationChild, Model model) {
		model.addAttribute("tlTestRoomReservationChild", tlTestRoomReservationChild);
		return "terlu/modules/tlTestRoomReservationChildForm";
	}

	@RequiresPermissions("modules:tlTestRoomReservationChild:edit")
	@RequestMapping(value = "save")
	public String save(TlTestRoomReservationChild tlTestRoomReservationChild, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlTestRoomReservationChild)){
			return form(tlTestRoomReservationChild, model);
		}
		tlTestRoomReservationChildService.save(tlTestRoomReservationChild);
		addMessage(redirectAttributes, "保存测试包场预定成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestRoomReservationChild/?repage";
	}
	
	@RequiresPermissions("modules:tlTestRoomReservationChild:edit")
	@RequestMapping(value = "delete")
	public String delete(TlTestRoomReservationChild tlTestRoomReservationChild, RedirectAttributes redirectAttributes) {
		tlTestRoomReservationChildService.delete(tlTestRoomReservationChild);
		addMessage(redirectAttributes, "删除测试包场预定成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlTestRoomReservationChild/?repage";
	}

}
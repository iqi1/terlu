/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.terlu.modules.entity.TlCarTestGroundDriver;
import com.terlu.modules.entity.TlCardRecord;
import com.terlu.modules.entity.TlCardState;
import com.terlu.modules.service.TlCarTestGroundDriverService;
import com.terlu.modules.service.TlCardRecordService;
import com.terlu.modules.service.TlCardStateService;

/**
 * 卡状态Controller
 * @author wangqi
 * @version 2020-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlCardState")
public class TlCardStateController extends BaseController {

	@Autowired
	private TlCardStateService tlCardStateService;
	
	@Autowired
	private TlCardRecordService tlCardRecordService;
	
	@Autowired
	private TlCarTestGroundDriverService tlCarTestGroundDriverService;
	
	@ModelAttribute
	public TlCardState get(@RequestParam(required=false) String id) {
		TlCardState entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlCardStateService.get(id);
		}
		if (entity == null){
			entity = new TlCardState();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlCardState:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlCardState tlCardState, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlCardState> page = tlCardStateService.findPage(new Page<TlCardState>(request, response), tlCardState); 
		model.addAttribute("page", page);
		return "terlu/modules/tlCardStateList";
	}

	@RequiresPermissions("modules:tlCardState:view")
	@RequestMapping(value = "form")
	public String form(TlCardState tlCardState, Model model) {
		List<TlCardRecord> listcr = tlCardRecordService.findList(new TlCardRecord());
		model.addAttribute("listcr", listcr);
		List<TlCarTestGroundDriver> listDriver = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
		model.addAttribute("listDriver", listDriver);
		model.addAttribute("tlCardState", tlCardState);
		return "terlu/modules/tlCardStateForm";
	}

	@RequiresPermissions("modules:tlCardState:edit")
	@RequestMapping(value = "save")
	public String save(TlCardState tlCardState, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlCardState)){
			return form(tlCardState, model);
		}
		tlCardStateService.save(tlCardState);
		addMessage(redirectAttributes, "保存卡状态成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCardState/?repage";
	}
	
	@RequiresPermissions("modules:tlCardState:edit")
	@RequestMapping(value = "delete")
	public String delete(TlCardState tlCardState, RedirectAttributes redirectAttributes) {
		tlCardStateService.delete(tlCardState);
		addMessage(redirectAttributes, "删除卡状态成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCardState/?repage";
	}

}
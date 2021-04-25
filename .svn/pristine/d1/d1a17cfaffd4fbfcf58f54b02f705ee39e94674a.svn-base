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
import com.terlu.modules.entity.TlInOutRecord;
import com.terlu.modules.entity.TlRoadGate;
import com.terlu.modules.service.TlCarTestGroundDriverService;
import com.terlu.modules.service.TlCardRecordService;
import com.terlu.modules.service.TlInOutRecordService;
import com.terlu.modules.service.TlRoadGateService;

/**
 * 进出记录Controller
 * @author wangqi
 * @version 2020-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlInOutRecord")
public class TlInOutRecordController extends BaseController {

	@Autowired
	private TlInOutRecordService tlInOutRecordService;
	
	@Autowired
	private TlCardRecordService tlCardRecordService;
	
	@Autowired
	private TlCarTestGroundDriverService tlCarTestGroundDriverService;
	
	@Autowired
	private TlRoadGateService tlRoadGateService;
	
	@ModelAttribute
	public TlInOutRecord get(@RequestParam(required=false) String id) {
		TlInOutRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlInOutRecordService.get(id);
		}
		if (entity == null){
			entity = new TlInOutRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlInOutRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlInOutRecord tlInOutRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlInOutRecord> page = tlInOutRecordService.findPage(new Page<TlInOutRecord>(request, response), tlInOutRecord); 
		model.addAttribute("page", page);
		return "terlu/modules/tlInOutRecordList";
	}

	@RequiresPermissions("modules:tlInOutRecord:view")
	@RequestMapping(value = "form")
	public String form(TlInOutRecord tlInOutRecord, Model model) {
		List<TlCardRecord> listcs = tlCardRecordService.findList(new TlCardRecord());
		model.addAttribute("listcs", listcs);
		List<TlCarTestGroundDriver> listDriver = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
		model.addAttribute("listDriver", listDriver);
		List<TlRoadGate> listrg =  tlRoadGateService.findList(new TlRoadGate());
		model.addAttribute("listrg",listrg);
		model.addAttribute("tlInOutRecord", tlInOutRecord);
		return "terlu/modules/tlInOutRecordForm";
	}

	@RequiresPermissions("modules:tlInOutRecord:edit")
	@RequestMapping(value = "save")
	public String save(TlInOutRecord tlInOutRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlInOutRecord)){
			return form(tlInOutRecord, model);
		}
		tlInOutRecordService.save(tlInOutRecord);
		addMessage(redirectAttributes, "保存进出记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlInOutRecord/?repage";
	}
	
	@RequiresPermissions("modules:tlInOutRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(TlInOutRecord tlInOutRecord, RedirectAttributes redirectAttributes) {
		tlInOutRecordService.delete(tlInOutRecord);
		addMessage(redirectAttributes, "删除进出记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlInOutRecord/?repage";
	}

}
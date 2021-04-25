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
import com.terlu.modules.entity.TlViolationRecord;
import com.terlu.modules.service.TlViolationRecordService;

/**
 * 违规记录Controller
 * @author wangqi
 * @version 2020-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlViolationRecord")
public class TlViolationRecordController extends BaseController {

	@Autowired
	private TlViolationRecordService tlViolationRecordService;
	
	@ModelAttribute
	public TlViolationRecord get(@RequestParam(required=false) String id) {
		TlViolationRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlViolationRecordService.get(id);
		}
		if (entity == null){
			entity = new TlViolationRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlViolationRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlViolationRecord tlViolationRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlViolationRecord> page = tlViolationRecordService.findPage(new Page<TlViolationRecord>(request, response), tlViolationRecord); 
		model.addAttribute("page", page);
		return "terlu/modules/tlViolationRecordList";
	}

	@RequiresPermissions("modules:tlViolationRecord:view")
	@RequestMapping(value = "form")
	public String form(TlViolationRecord tlViolationRecord, Model model) {
		model.addAttribute("tlViolationRecord", tlViolationRecord);
		return "terlu/modules/tlViolationRecordForm";
	}

	@RequiresPermissions("modules:tlViolationRecord:edit")
	@RequestMapping(value = "save")
	public String save(TlViolationRecord tlViolationRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlViolationRecord)){
			return form(tlViolationRecord, model);
		}
		tlViolationRecordService.save(tlViolationRecord);
		addMessage(redirectAttributes, "保存违规记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlViolationRecord/?repage";
	}
	
	@RequiresPermissions("modules:tlViolationRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(TlViolationRecord tlViolationRecord, RedirectAttributes redirectAttributes) {
		tlViolationRecordService.delete(tlViolationRecord);
		addMessage(redirectAttributes, "删除违规记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlViolationRecord/?repage";
	}

}
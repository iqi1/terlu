/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.util.ArrayList;
import java.util.List;

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
 * 卡记录Controller
 * @author wangqi
 * @version 2020-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlCardRecord")
public class TlCardRecordController extends BaseController {

	@Autowired
	private TlCardRecordService tlCardRecordService;
	
	@Autowired
	private TlCarTestGroundDriverService tlCarTestGroundDriverService;
	
	@ModelAttribute
	public TlCardRecord get(@RequestParam(required=false) String id) {
		TlCardRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlCardRecordService.get(id);
		}
		if (entity == null){
			entity = new TlCardRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlCardRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlCardRecord tlCardRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlCardRecord> page = tlCardRecordService.findPage(new Page<TlCardRecord>(request, response), tlCardRecord); 
		model.addAttribute("page", page);
		return "terlu/modules/tlCardRecordList";
	}

	@RequiresPermissions("modules:tlCardRecord:view")
	@RequestMapping(value = "form")
	public String form(TlCardRecord tlCardRecord, Model model) {
		model.addAttribute("tlCardRecord", tlCardRecord);
		List <TlCarTestGroundDriver> listDriver = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
		model.addAttribute("listDriver",listDriver);
		return "terlu/modules/tlCardRecordForm";
	}

	@RequiresPermissions("modules:tlCardRecord:edit")
	@RequestMapping(value = "save")
	public String save(TlCardRecord tlCardRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlCardRecord)){
			return form(tlCardRecord, model);
		}
		tlCardRecordService.save(tlCardRecord);
		addMessage(redirectAttributes, "保存卡记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCardRecord/?repage";
	}
	
	@RequiresPermissions("modules:tlCardRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(TlCardRecord tlCardRecord, RedirectAttributes redirectAttributes) {
		tlCardRecordService.delete(tlCardRecord);
		addMessage(redirectAttributes, "删除卡记录成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCardRecord/?repage";
	}

}
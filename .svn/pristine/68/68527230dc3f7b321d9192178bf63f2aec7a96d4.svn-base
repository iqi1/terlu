/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

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
import com.terlu.modules.entity.TlMainSchedule;
import com.terlu.modules.entity.TlWeekScheduleDetails;
import com.terlu.modules.service.TlMainScheduleService;
import com.terlu.modules.service.TlWeekScheduleDetailsService;

/**
 * 计划排班Controller
 * @author sunlifeng
 * @version 2020-05-13
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlWeekScheduleDetails")
public class TlWeekScheduleDetailsController extends BaseController {

	@Autowired
	private TlWeekScheduleDetailsService tlWeekScheduleDetailsService;
	
	@Autowired
	private TlMainScheduleService tlMainScheduleService;
	
	@ModelAttribute
	public TlWeekScheduleDetails get(@RequestParam(required=false) String id) {
		TlWeekScheduleDetails entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlWeekScheduleDetailsService.get(id);
		}
		if (entity == null){
			entity = new TlWeekScheduleDetails();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlWeekScheduleDetails:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlWeekScheduleDetails tlWeekScheduleDetails, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlWeekScheduleDetails> page = tlWeekScheduleDetailsService.findPage(new Page<TlWeekScheduleDetails>(request, response), tlWeekScheduleDetails); 
		model.addAttribute("page", page);
		List<TlMainSchedule> list = tlMainScheduleService.findList(new TlMainSchedule());
		model.addAttribute("weekList", list);
		return "terlu/modules/tlWeekScheduleDetailsList";
	}

	@RequiresPermissions("modules:tlWeekScheduleDetails:view")
	@RequestMapping(value = "form")
	public String form(TlWeekScheduleDetails tlWeekScheduleDetails, Model model) {
		List<TlMainSchedule> list = tlMainScheduleService.findList(new TlMainSchedule());
		model.addAttribute("weekList", list);
		model.addAttribute("tlWeekScheduleDetails", tlWeekScheduleDetails);
		return "terlu/modules/tlWeekScheduleDetailsForm";
	}

	@RequiresPermissions("modules:tlWeekScheduleDetails:edit")
	@RequestMapping(value = "save")
	public String save(TlWeekScheduleDetails tlWeekScheduleDetails, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlWeekScheduleDetails)){
			return form(tlWeekScheduleDetails, model);
		}
		
		String selects = tlWeekScheduleDetails.getSelects();
		if(!StringUtils.isBlank(selects)) {
			String[] strs = selects.split(":");
			
			byte[] details = new byte[24];
			
			for(String str : strs) {
				int index = Integer.parseInt(str);
				details[index] = 1;
				
			}
			tlWeekScheduleDetails.setDetails(details);
			
		}
		tlWeekScheduleDetailsService.save(tlWeekScheduleDetails);
		addMessage(redirectAttributes, "保存计划排班成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlWeekScheduleDetails/?repage";
	}
	
	@RequiresPermissions("modules:tlWeekScheduleDetails:edit")
	@RequestMapping(value = "delete")
	public String delete(TlWeekScheduleDetails tlWeekScheduleDetails, RedirectAttributes redirectAttributes) {
		tlWeekScheduleDetailsService.delete(tlWeekScheduleDetails);
		addMessage(redirectAttributes, "删除计划排班成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlWeekScheduleDetails/?repage";
	}

}
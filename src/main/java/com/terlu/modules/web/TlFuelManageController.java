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
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.terlu.modules.entity.TlCarInfo;
import com.terlu.modules.entity.TlCarTestGroundDriver;
import com.terlu.modules.entity.TlCustomBaseinfo;
import com.terlu.modules.entity.TlFuelManage;
import com.terlu.modules.entity.TlTestTaskList;
import com.terlu.modules.entity.TlTestprojectChild;
import com.terlu.modules.service.TlCarInfoService;
import com.terlu.modules.service.TlCarTestGroundDriverService;
import com.terlu.modules.service.TlCustomBaseinfoService;
import com.terlu.modules.service.TlFuelManageService;
import com.terlu.modules.service.TlTestTaskListService;
import com.terlu.modules.service.TlTestprojectChildService;

/**
 * 加油申请Controller
 * @author wangqi
 * @version 2020-02-05
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlFuelManage")
public class TlFuelManageController extends BaseController {

	@Autowired
	private TlFuelManageService tlFuelManageService;
	
	@Autowired
	private TlCustomBaseinfoService tlCustomBaseinfoService;
	
	@Autowired
	private ActTaskService actTaskService;
	
	@ModelAttribute
	public TlFuelManage get(@RequestParam(required=false) String id) {
		TlFuelManage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlFuelManageService.get(id);
		}
		if (entity == null){
			entity = new TlFuelManage();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlFuelManage:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlFuelManage tlFuelManage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlFuelManage> page = tlFuelManageService.findPage(new Page<TlFuelManage>(request, response), tlFuelManage); 
		model.addAttribute("page", page);
		return "terlu/modules/tlFuelManageList";
	}

	@RequiresPermissions("modules:tlFuelManage:view")
	@RequestMapping(value = "form")
	public String form(TlFuelManage tlFuelManage, Model model) {
		List<TlCustomBaseinfo> listCu = tlCustomBaseinfoService.findList(new TlCustomBaseinfo());
		model.addAttribute("listCu", listCu);
		model.addAttribute("tlFuelManage", tlFuelManage);
		return "terlu/modules/tlFuelManageForm";
	}

	@RequiresPermissions("modules:tlFuelManage:edit")
	@RequestMapping(value = "save")
	public String save(TlFuelManage tlFuelManage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlFuelManage)){
			return form(tlFuelManage, model);
		}
		tlFuelManageService.save(tlFuelManage);
		addMessage(redirectAttributes, "保存加油申请成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFuelManage/?repage";
	}
	
	@RequiresPermissions("modules:tlFuelManage:audit")
	@RequestMapping(value = "formAudit")
	public String formAudit(TlFuelManage tlFuelManage, Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("tlFuelManage", tlFuelManage);
		return "terlu/modules/tlFuelManageAudit";
	}
	
	@RequiresPermissions("modules:tlFuelManage:edit")
	@RequestMapping(value = "delete")
	public String delete(TlFuelManage tlFuelManage, RedirectAttributes redirectAttributes) {
		tlFuelManageService.delete(tlFuelManage);
		addMessage(redirectAttributes, "删除加油申请成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlFuelManage/?repage";
	}

}
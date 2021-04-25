/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
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
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.terlu.modules.entity.TlCarTestGroundDriver;
import com.terlu.modules.entity.TlTestTaskList;
import com.terlu.modules.service.TlCarTestGroundDriverService;
import com.terlu.modules.service.TlTestTaskListService;

/**
 * 试验任务单Controller
 * @author sunlifeng
 * @version 2020-01-06
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlTestTaskList")
public class TlTestTaskListController extends BaseController {

	@Autowired
	private TlTestTaskListService tlTestTaskListService;
	
	@Autowired
	private TlCarTestGroundDriverService tlCarTestGroundDriverService;
	
	@ModelAttribute
	public TlTestTaskList get(@RequestParam(required=false) String id) {
		TlTestTaskList entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlTestTaskListService.get(id);
		}
		if (entity == null){
			entity = new TlTestTaskList();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlTestTaskList:view")
	@RequestMapping(value = {"list"})
	public String list(TlTestTaskList tlTestTaskList, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if(!user.getId().equals("1")  && !user.getId().equals("0"))
			tlTestTaskList.setUserId(user.getId());
		Page<TlTestTaskList> page = tlTestTaskListService.findPage(new Page<TlTestTaskList>(request, response), tlTestTaskList); 
		if(page.getList().size() > 0) {
			model.addAttribute("page", page);
			return "terlu/modules/tlTestTaskListList";
		}else {
			List<TlCarTestGroundDriver> list = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
			model.addAttribute("tlTestTaskList", tlTestTaskList);
			model.addAttribute("list", list);
			return "terlu/modules/tlTestTaskListForm";
		}
			
	}
	
	@RequiresPermissions("modules:tlTestTaskList:view")
	@RequestMapping(value = {"listBy", ""})
	public String listBy(int idd,String id, HttpServletRequest request, HttpServletResponse response, Model model) {
		TlTestTaskList tlTestTaskList = new TlTestTaskList();
		tlTestTaskList.setProjectId(id);
		tlTestTaskList.setIsBaoChang(idd);
		User user = UserUtils.getUser();
		if(!user.getId().equals("1")  && !user.getId().equals("0"))
			tlTestTaskList.setUserId(user.getId());
		Page<TlTestTaskList> page = tlTestTaskListService.findPage(new Page<TlTestTaskList>(request, response), tlTestTaskList); 
		boolean isEdit = SecurityUtils.getSubject().isPermitted("modules:tlTestTaskList:edit");
		
		if(page.getList().size() > 0 || !isEdit) {
			model.addAttribute("page", page);
			return "terlu/modules/tlTestTaskListList";
		}else {
			model.addAttribute("tlTestTaskList", tlTestTaskList);
			List<TlCarTestGroundDriver> list = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
			model.addAttribute("list", list);
			return "terlu/modules/tlTestTaskListForm";
		}	
	}

	@RequiresPermissions("modules:tlTestTaskList:edit")
	@RequestMapping(value = "form")
	public String form(TlTestTaskList tlTestTaskList, Model model) {
		model.addAttribute("tlTestTaskList", tlTestTaskList);
		List<TlCarTestGroundDriver> list = tlCarTestGroundDriverService.findList(new TlCarTestGroundDriver());
		model.addAttribute("list", list);
		return "terlu/modules/tlTestTaskListForm";
	}

	@RequiresPermissions("modules:tlTestTaskList:edit")
	@RequestMapping(value = "save")
	public String save(TlTestTaskList tlTestTaskList,HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlTestTaskList)){
			return form(tlTestTaskList, model);
		}
		tlTestTaskListService.save(tlTestTaskList);
		addMessage(redirectAttributes, "保存试验任务单成功");
		Page<TlTestTaskList> page = tlTestTaskListService.findPage(new Page<TlTestTaskList>(request, response), tlTestTaskList); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestTaskListList";

		//return "redirect:"+Global.getAdminPath()+"/modules/tlTestTaskList/?repage";
	}
	
	@RequiresPermissions("modules:tlTestTaskList:edit")
	@RequestMapping(value = "delete")
	public String delete(TlTestTaskList tlTestTaskList,HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		tlTestTaskListService.delete(tlTestTaskList);
		addMessage(redirectAttributes, "删除试验任务单成功");
		Page<TlTestTaskList> page = tlTestTaskListService.findPage(new Page<TlTestTaskList>(request, response), tlTestTaskList); 
		model.addAttribute("page", page);
		return "terlu/modules/tlTestTaskListList";
		//return "redirect:"+Global.getAdminPath()+"/modules/tlTestTaskList/?repage";
	}

}
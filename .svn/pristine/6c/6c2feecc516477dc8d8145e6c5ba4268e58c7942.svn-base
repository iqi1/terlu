/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.terlu.modules.entity.TlCustomBaseinfo;
import com.terlu.modules.entity.TlRequestTestRoad;
import com.terlu.modules.entity.TlTestCarPlan;
import com.terlu.modules.service.TlCustomBaseinfoService;
import com.terlu.modules.service.TlRequestTestRoadService;
import com.terlu.modules.service.TlTestCarPlanService;

/**
 * 测试道路请求Controller
 * @author sunlifeng
 * @version 2020-05-14
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlRequestTestRoad")
public class TlRequestTestRoadController extends BaseController {

	@Autowired
	private TlRequestTestRoadService tlRequestTestRoadService;
	
	@Autowired
	private TlTestCarPlanService tlTestCarPlanService;
	
	@Autowired
	private TlCustomBaseinfoService tlCustomBaseinfoService;
	
	static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd ");
	static SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdfTimeHM = new SimpleDateFormat("HH:mm");
	
	@ModelAttribute
	public TlRequestTestRoad get(@RequestParam(required=false) String id) {
		TlRequestTestRoad entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlRequestTestRoadService.get(id);
		}
		if (entity == null){
			entity = new TlRequestTestRoad();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlRequestTestRoad:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlRequestTestRoad tlRequestTestRoad, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlRequestTestRoad> page = tlRequestTestRoadService.findPage(new Page<TlRequestTestRoad>(request, response), tlRequestTestRoad); 
		TlCustomBaseinfo tlCustomBaseinfo = new TlCustomBaseinfo();
		tlCustomBaseinfo.setDelFlag("0");
		List<TlCustomBaseinfo> list = tlCustomBaseinfoService.findList(tlCustomBaseinfo);
		model.addAttribute("list",  list);
		model.addAttribute("page", page);
		return "terlu/modules/tlRequestTestRoadList";
	}

	@RequiresPermissions("modules:tlRequestTestRoad:view")
	@RequestMapping(value = "form")
	public String form(TlRequestTestRoad tlRequestTestRoad, Model model) {
		TlCustomBaseinfo tlCustomBaseinfo = new TlCustomBaseinfo();
		tlCustomBaseinfo.setDelFlag("0");
		List<TlCustomBaseinfo> list = tlCustomBaseinfoService.findList(tlCustomBaseinfo);
		model.addAttribute("list",  list);
		model.addAttribute("tlRequestTestRoad", tlRequestTestRoad);
		return "terlu/modules/tlRequestTestRoadForm";
	}

	@RequiresPermissions("modules:tlRequestTestRoad:edit")
	@RequestMapping(value = "save")
	public String save(TlRequestTestRoad tlRequestTestRoad, Model model, RedirectAttributes redirectAttributes) {
		
		String selects = tlRequestTestRoad.getSelects();
		if(StringUtils.isBlank(selects)) {
			addMessage(redirectAttributes, "没有选择测试时间");
			return "redirect:"+Global.getAdminPath()+"/modules/tlRequestTestRoad/?repage";
		}
			
		String[] strs = selects.split(";");
		Map<String,SelectItem> map = new HashMap<String,SelectItem>();
		
		SelectItem selectItem;
		for(String str :strs) {
			String[] strItems = str.split("_");
			String key = strItems[0];
			if(map.containsKey(key)) {
				selectItem = map.get(key);
				selectItem.count ++;
				//map.put(key, count);
			}else {
				selectItem = new SelectItem();
				if(strItems.length > 1 && !strItems[1].isEmpty()) {
					selectItem.id = strItems[1];
				}
				selectItem.count = 1;
				selectItem.otherCount = Integer.parseInt(strItems[2]);
				map.put(key, selectItem);
			}
		}
		
		Date startDate = tlRequestTestRoad.getStartTime();
		Date endDate = tlRequestTestRoad.getStartTime();
		String strSDate = sdfDate.format(startDate);
		String strEDate = sdfDate.format(endDate);
		
		TlRequestTestRoad RTR = new TlRequestTestRoad();
		RTR.setProjectId(tlRequestTestRoad.getProjectId());
//		
		String sDate = strSDate + " 00:00:00";
		String eDate = strSDate + " 23:59:59";
		try {
			Date startTime = sdfDateTime.parse(sDate);
			Date endTime = sdfDateTime.parse(eDate);
			RTR.setTestRoad(tlRequestTestRoad.getTestRoad());
			RTR.setStartTime(startTime);
			RTR.setEndTime(endTime);		
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Map<String,TlRequestTestRoad> mapRTR = new HashMap<String,TlRequestTestRoad>();

		List<TlRequestTestRoad> listData = tlRequestTestRoadService.findListFor(RTR);
		
		for(TlRequestTestRoad rtr :listData) {
			String curTime = sdfTimeHM.format(rtr.getStartTime());
			curTime += "-";
			curTime += sdfTimeHM.format(rtr.getEndTime());
			mapRTR.put(curTime, rtr);
		}
		
		
		List<TlRequestTestRoad> list = new ArrayList<TlRequestTestRoad>();
		List<TlRequestTestRoad> listUpdata = new ArrayList<TlRequestTestRoad>();
		

		
		System.out.println();
		Iterator<Entry<String, SelectItem>> entries = map.entrySet().iterator();
		while(entries.hasNext()){
		    Entry<String, SelectItem> entry = entries.next();
		    String key = entry.getKey();
		    selectItem = entry.getValue();
		    String[] strTimes = key.split("-");
		    
		    try {
		    	TlRequestTestRoad tlRTR = new TlRequestTestRoad();
		    	tlRTR.setProjectId(tlRequestTestRoad.getProjectId());
		    	tlRTR.setTestRoad(tlRequestTestRoad.getTestRoad());
				tlRTR.setStartTime(sdfDateTime.parse(strSDate + strTimes[0] + ":00") );
				tlRTR.setEndTime(sdfDateTime.parse(strEDate + strTimes[1] + ":00") );
				tlRTR.setCarCount(selectItem.count);
				
				if(mapRTR.containsKey(key)) {
					RTR = mapRTR.get(key);
		    		if(selectItem.count != RTR.getCarCount()) {
			    		//tlRTR.setId(RTR.getId());
		    			RTR.setCarCount(selectItem.count);
			    		listUpdata.add(RTR);
		    		}
		    		mapRTR.remove(key);
				}else {
		    		tlRTR.preInsert();
		    		list.add(tlRTR);
				}
				
//		    	if(selectItem.id.isEmpty()) {

//		    	}else {
//		    		if(selectItem.count != selectItem.otherCount) {
//			    		tlRTR.setId(selectItem.id);
//			    		listUpdata.add(tlRTR);
//		    		}
//		    	}
				
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		    
		    System.out.printf("%s:%d\n",key,selectItem.count);
		}
		
		Iterator<Entry<String, TlRequestTestRoad>> entriesRTR = mapRTR.entrySet().iterator();
		while(entriesRTR.hasNext()){
		    Entry<String, TlRequestTestRoad> entry = entriesRTR.next();
		    RTR = entry.getValue();
		    RTR.setCarCount(0);
		    listUpdata.add(RTR);
		}
		
		if(list.size() > 0 || listUpdata.size() > 0) {
			tlRequestTestRoadService.saveList(list,listUpdata);
		}
		
//		if (!beanValidator(model, tlRequestTestRoad)){
//			return form(tlRequestTestRoad, model);
//		}
		//tlRequestTestRoadService.save(tlRequestTestRoad);
		addMessage(redirectAttributes, "保存测试道路请求成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlRequestTestRoad/?repage";
	}
	
	@RequiresPermissions("modules:tlRequestTestRoad:edit")
	@RequestMapping(value = "delete")
	public String delete(TlRequestTestRoad tlRequestTestRoad, RedirectAttributes redirectAttributes) {
		tlRequestTestRoadService.delete(tlRequestTestRoad);
		addMessage(redirectAttributes, "删除测试道路请求成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlRequestTestRoad/?repage";
	}
	
	public Map<String,SelectItem> getTestSelected(TlRequestTestRoad tlRequestTestRoad,String projectId){
		
		Map<String,SelectItem> map = new HashMap<String,SelectItem>();
		//TlRequestTestRoad llRequestTestRoad = new TlRequestTestRoad();
		List<TlRequestTestRoad> list = tlRequestTestRoadService.findListFor(tlRequestTestRoad);
		
		SelectItem selectItem;
		for(TlRequestTestRoad rtr : list) {
			String curTime = sdfTimeHM.format(rtr.getStartTime());
			curTime += "-";
			curTime += sdfTimeHM.format(rtr.getEndTime());
			if(map.containsKey(curTime)) {
				selectItem  = map.get(curTime);
				if(projectId.equals(rtr.getProjectId())) {
					selectItem.count += rtr.getCarCount();
					selectItem.id = rtr.getId();
				}else
					selectItem.otherCount += rtr.getCarCount();
			
			}else {
				//int[] vals = new int[2];
				selectItem = new SelectItem();
				if(projectId.equals(rtr.getProjectId())) {
					selectItem.count = rtr.getCarCount();
					selectItem.id = rtr.getId();
				}else
					selectItem.otherCount = rtr.getCarCount();
				map.put(curTime, selectItem);
			}
				
		}
		
//		Iterator<Entry<String, int[]>> entries = map.entrySet().iterator();
//		while(entries.hasNext()){
//		    Entry<String, int[]> entry = entries.next();
//		    String key = entry.getKey();
//		    int[] value = entry.getValue();
//		    System.out.printf("%s\t%d\t%d\n", key,value[0],value[1]);
//		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "TestRoadInfo")
	public List<Map<String,Object>> TestRoadInfo(String date,String projectId,int testRoad) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		try {
			String sDate = date + " 00:00:00";
			String eDate = date + " 23:59:59";
			Date startTime = sdfDateTime.parse(sDate);
			Date endTime = sdfDateTime.parse(eDate);
			TlTestCarPlan tlTestCarPlan = new TlTestCarPlan();
			
			String strTestRoad = new Integer(testRoad).toString();
			tlTestCarPlan.setTestRoad(strTestRoad);
			tlTestCarPlan.setStartTime(startTime);
			tlTestCarPlan.setEndTime(endTime);
			
			TlRequestTestRoad tlRequestTestRoad = new TlRequestTestRoad();
			
			tlRequestTestRoad.setTestRoad(strTestRoad);
			tlRequestTestRoad.setStartTime(startTime);
			tlRequestTestRoad.setEndTime(endTime);
			Map<String,SelectItem> mapSelected = getTestSelected(tlRequestTestRoad,projectId);
			
			
			List<TlTestCarPlan> list = tlTestCarPlanService.findList(tlTestCarPlan);	
			 Calendar nowTime = Calendar.getInstance();
			Map<String,Object> map; 
			List<Map<String,Object>> listDetail = new ArrayList<Map<String,Object>>();
			if(list.size() > 0) {
				
				for(int ii = 0 ; ii < list.size() ; ii ++) {
					tlTestCarPlan = list.get(ii);
					startTime = tlTestCarPlan.getStartTime();
					endTime = tlTestCarPlan.getEndTime();
			    	nowTime.setTime(startTime);
			    	String lastTime = sdfTimeHM.format(startTime.getTime());
			    	
					while (nowTime.getTime().getTime() < endTime.getTime()) {
						nowTime.add(Calendar.MINUTE, 60);
						String curTime = sdfTimeHM.format(nowTime.getTime());
						String strtime = lastTime + "-" + curTime;
						System.out.println(strtime);
						map = new HashMap<String,Object>();
						map.put("rowName", strtime);
						lastTime = curTime;
						int[] details = new int[4];
						details[0] = tlTestCarPlan.getCarCount();
						details[1] = 0;
						if(mapSelected.containsKey(strtime)) {
							SelectItem selectItem = mapSelected.get(strtime);
							details[1] = selectItem.count;
							details[3] = selectItem.otherCount;
							map.put("id", selectItem.id);
						}
							
						
						details[2] = ii;
						map.put("data", details);
						listDetail.add(map);
						
					}

				}
						
			}
			
			return listDetail;
			
		} catch (ParseException e) {

			//e.printStackTrace();
		}

		

		
		return null;
	}
	
	public class SelectItem{
		public String id = "";
		public int count = 0;
		public int otherCount = 0;
		
		
	}

}
/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
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

import com.google.common.collect.Maps;
import com.terlu.modules.entity.TlCarInfo;
import com.terlu.modules.entity.TlCustomBaseinfo;
import com.terlu.modules.entity.TlFinanceInfo;
import com.terlu.modules.entity.TlMainSchedule;
import com.terlu.modules.entity.TlOtherExtendsInfo;
import com.terlu.modules.entity.TlSeal;
import com.terlu.modules.entity.TlSendAddress;
import com.terlu.modules.entity.TlTestRoomReservationChild;
import com.terlu.modules.entity.TlTestSiteHotel;
import com.terlu.modules.entity.TlTestTaskList;
import com.terlu.modules.entity.TlTestprojectChild;
import com.terlu.modules.entity.TlVistorRegister;
import com.terlu.modules.service.TlCarInfoService;
import com.terlu.modules.service.TlCustomBaseinfoService;
import com.terlu.modules.service.TlFinanceInfoService;
import com.terlu.modules.service.TlMainScheduleService;
import com.terlu.modules.service.TlOtherExtendsInfoService;
import com.terlu.modules.service.TlSealService;
import com.terlu.modules.service.TlSendAddressService;
import com.terlu.modules.service.TlTestRoomReservationChildService;
import com.terlu.modules.service.TlTestSiteHotelService;
import com.terlu.modules.service.TlTestTaskListService;
import com.terlu.modules.service.TlTestprojectChildService;
import com.terlu.modules.service.TlVistorRegisterService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;

/**
 * 试验测试申请表Controller
 * @author sunlifeng
 * @version 2019-12-27
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlCustomBaseinfo")
public class TlCustomBaseinfoController extends BaseController {

	@Autowired
	private TlCustomBaseinfoService tlCustomBaseinfoService;
	
	@Autowired
	private TlVistorRegisterService tlVistorRegisterService;
	
	@Autowired
	private TlTestprojectChildService tlTestprojectChildService;
	
	@Autowired
	private TlCarInfoService tlCarInfoService;
	
	@Autowired
	private TlTestRoomReservationChildService tlTestRoomReservationChildService;
	
	@Autowired
	private TlTestSiteHotelService tlTestSiteHotelService;
	
	@Autowired
	private TlFinanceInfoService tlFinanceInfoService;
	
	@Autowired
	private TlSendAddressService tlSendAddressService;
	
	@Autowired
	private TlOtherExtendsInfoService tlOtherExtendsInfoService;
	
	@Autowired
	private TlSealService tlSealService;
	
	@Autowired
	private TlTestTaskListService tlTestTaskListService;
	
	@Autowired
	private TlMainScheduleService tlMainScheduleService;
	
	@ModelAttribute
	public TlCustomBaseinfo get(@RequestParam(required=false) String id) {
		TlCustomBaseinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlCustomBaseinfoService.get(id);
		}
		if (entity == null){
			entity = new TlCustomBaseinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:view")
	@RequestMapping(value = {"list"})
	public String list(TlCustomBaseinfo tlCustomBaseinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if(!user.getId().equals("1") && !user.getId().equals("0"))
			tlCustomBaseinfo.setUserAuthorizer(user);
		Page<TlCustomBaseinfo> page = tlCustomBaseinfoService.findPage(new Page<TlCustomBaseinfo>(request, response), tlCustomBaseinfo); 
		model.addAttribute("page", page);
		tlCustomBaseinfo.setStatus(2);
		return "terlu/modules/tlCustomBaseinfoList";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:audit")
	@RequestMapping(value = {"listTodo"})
	public String listTodo(TlCustomBaseinfo tlCustomBaseinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if(!user.getId().equals("1") && !user.getId().equals("0"))
			tlCustomBaseinfo.setUserAuthorizer(user);
		Page<TlCustomBaseinfo> page = tlCustomBaseinfoService.findToDoTaskPage(tlCustomBaseinfo);
				//findPage(new Page<TlCustomBaseinfo>(request, response), tlCustomBaseinfo); 
		model.addAttribute("page", page);
		return "terlu/modules/tlCustomBaseinfoList";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:view")
	@RequestMapping(value = {"listBy", ""})
	public String listBy(String id, HttpServletRequest request, HttpServletResponse response, Model model) {
		TlCustomBaseinfo tlCustomBaseinfo = get(id);
		return list(tlCustomBaseinfo,request,response,model);
	}
	
	@RequestMapping(value = { "index" })
	public String index(TlCustomBaseinfo tlCustomBaseinfo, Model model) {

		return "terlu/modules/tlCustomBaseinfoIndex";
	}
	
	
	@ResponseBody
	@RequestMapping(value = { "treeData" })
	public List<Map<String, Object>> treeData(TlCustomBaseinfo tlCustomBaseinfo, Model model) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		User user = UserUtils.getUser();
		if(!user.getId().equals("1")  && !user.getId().equals("0"))
			tlCustomBaseinfo.setUserLeader(user);
		List<TlCustomBaseinfo> listCB = tlCustomBaseinfoService.findList(tlCustomBaseinfo);
		
		Map<String,TlCustomBaseinfo> mapCB = new HashMap<String,TlCustomBaseinfo>();
		for(TlCustomBaseinfo cb : listCB) {
			mapCB.put(cb.getId(), cb);
		}
		
		
		TlTestprojectChild tlTestprojectChild = new TlTestprojectChild();
		List<TlTestprojectChild> listTC = tlTestprojectChildService.findList(tlTestprojectChild);
		
		List<Dict> listDict = DictUtils.getDictList("test_road");
		String labels[] = new String[listDict.size()];
		for(int ii = 0 ; ii < listDict.size(); ii ++) {
			labels[ii] = listDict.get(ii).getLabel();
		}
		
		Map<String,Integer> mapSub = new HashMap<String,Integer>();
		
		TlTestRoomReservationChild tlTestRoomReservationChild = new TlTestRoomReservationChild();
		//tlTestRoomReservationChild.setTlCustomBaseinfoId(tl.getId());
		List<TlTestRoomReservationChild> listTest = tlTestRoomReservationChildService.findList(tlTestRoomReservationChild);
		for(TlTestRoomReservationChild trrc : listTest) {
			if(!mapCB.containsKey(trrc.getTlCustomBaseinfoId()))
				continue;
			Map<String, Object> map = Maps.newHashMap();
			map.put("id",trrc.getId());
			String subPid = trrc.getTlCustomBaseinfoId() + "1";
			map.put("pId",subPid );
			map.put("name", labels[trrc.getTestRoad()]);
			map.put("idd",1);
			list.add(map);
			mapSub.put(subPid, 1);
		}
		
		for(TlTestprojectChild tc : listTC) {
			
			if(!mapCB.containsKey(tc.getTlTestprojectId()))
					continue;
			Map<String, Object> map = Maps.newHashMap();
			map.put("id",tc.getId());
			String subPid = tc.getTlTestprojectId() + "0";
			map.put("pId", subPid);
			map.put("name", labels[tc.getTestRoad()]);
			map.put("idd",0);
			list.add(map);
			mapSub.put(subPid, 1);
		}
		
		
		for(TlCustomBaseinfo cb : listCB) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id",cb.getId());
			map.put("pId", 0);
			map.put("name", cb.getCompanyName());
			map.put("idd",3);
			list.add(map);
			
			String subid = cb.getId() + "0";
			if (mapSub.containsKey(subid)) {
				map = Maps.newHashMap();
				map.put("id", subid);
				map.put("pId", cb.getId());
				map.put("name", "共享测试道路");
				map.put("idd", 10);
				list.add(map);
			}

			subid = cb.getId() + "1";
			if (mapSub.containsKey(subid)) {
				map = Maps.newHashMap();
				map.put("id", subid);
				map.put("pId", cb.getId());
				map.put("name", "测试包场预定");
				map.put("idd", 10);
				list.add(map);
			}
		}
		
		return list;
	}

	@RequiresPermissions("modules:tlCustomBaseinfo:view")
	@RequestMapping(value = "form")
	public String form(TlCustomBaseinfo tlCustomBaseinfo, Model model) {
		
		
		List<TlMainSchedule> list = tlMainScheduleService.findList(new TlMainSchedule());
		model.addAttribute("weekList", list);
		model.addAttribute("tlCustomBaseinfo", tlCustomBaseinfo);
		return "terlu/modules/tlCustomBaseinfoForm";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:view")
	@RequestMapping(value = "formBaseInfo")
	public String formBaseInfo(TlCustomBaseinfo tlCustomBaseinfo, Model model) {
		model.addAttribute("tlCustomBaseinfo", tlCustomBaseinfo);
		//Map<String, String> map = new HashMap<String, String>();
//		Map<String, String> map = tlCustomBaseinfo.getMapTest();
//		map.put("test", "test");
		//model.addAttribute("mapTest", map);
		return "terlu/modules/tlCustomBaseBaseinfoForm";
	}
	
	private JasperPrint getFirstJasperPrint(TlCustomBaseinfo tl,String jrxmlDestPath) {
		
		StringBuffer sb = new StringBuffer();
	
		String str = String.format("{\"H4\":\"%s\",\"H5\":\"%s\",", tl.getCompanyName(),tl.getAddress());
		sb.append(str);
		
		str = String.format("\"H6\":\"%s\",\"R6\":\"%s\",", tl.getDepartment(),tl.getTelephone());
		sb.append(str);
		
		str = String.format("\"H7\":\"%s\",\"R7\":\"%s\",", tl.getZipCode(),tl.getFax());
		sb.append(str);
		
		str = String.format("\"H8\":\"%s\",\"H10\":\"%s\",", tl.getUserAuthorizer().getName(),tl.getUserLeader().getName());
		sb.append(str);
		
		str = String.format("\"R8\":\"%s\",\"R9\":\"%s\",", tl.getContactNumberL(),tl.getEmailL());
		sb.append(str);
		
		str = String.format("\"R10\":\"%s\",\"R11\":\"%s\",", tl.getContactNumberC(),tl.getEmailC());
		sb.append(str);
		
		TlVistorRegister tlVistorRegister = new TlVistorRegister();
		tlVistorRegister.setParentId(tl.getId());
		List<TlVistorRegister> list = tlVistorRegisterService.findList(tlVistorRegister);
		
		int start = 31;
		String strs[] = {"x","√"};
		
		String format,format2,format3;

		for(TlVistorRegister tlv :list) {
			format = String.format("\"A%s\":\"%s\",\"D%s\":\"%s\",",start,"%s",start,"%s");
			format2 = String.format("\"K%s\":\"%s\",\"P%s\":\"%s\",",start,"%s",start,"%s");
			format3 = String.format("\"V%s\":\"%s\",\"Y%s\":\"%s\",",start,"%s",start,"%s");
			str = String.format(format, tlv.getName(),tlv.getIdcardPassport());
			sb.append(str);
			str = String.format(format2,strs[ tlv.getDriver()],strs[ tlv.getApplyLicense()]);
			sb.append(str);
			str = String.format(format3, strs[ tlv.getJoinSafetrain()],strs[ tlv.getCheckinHotel()]);
			sb.append(str);
			start ++;

		}
		
		TlFinanceInfo tlFinanceInfo = new TlFinanceInfo();
		tlFinanceInfo.setParentId(tl.getId());
		List<TlFinanceInfo> fiList = tlFinanceInfoService.findList(tlFinanceInfo);
		
		if (fiList.size() >= 1) {
			TlFinanceInfo fi = fiList.get(0);
			format = "\"H13\":\"%s\",\"R13\":\"%s\",\"H14\":\"%s\",\"R14\":\"%s\",\"R15\":\"%s\",";
			str = String.format(format, fi.getInvoiceRise(), fi.getVatNumber(), fi.getInvoiceReceiver(),
					fi.getTelInvRecever(), fi.getEmail());
			sb.append(str);

			format = "\"H16\":\"%s\",\"H17\":\"%s\",\"H18\":\"%s\",\"H19\":\"%s\",";
			str = String.format(format, fi.getBankName(), fi.getAccountBank(), fi.getRegisteredAddress(),
					fi.getInvoiceReceiveAddress());
			sb.append(str);
		}
		
		TlSendAddress tlSendAddress = new TlSendAddress();
		tlSendAddress.setParentId(tl.getId());
		List<TlSendAddress> saList = tlSendAddressService.findList(tlSendAddress);
		
		if (saList.size() >= 1) {
			TlSendAddress fa = saList.get(0);
			format = "\"C25\":\"%s\",\"R25\":\"%s\",\"C26\":\"%s\",\"R26\":\"%s\",\"C27\":\"%s\",\"R27\":\"%s\",\"O28\":\"%s\",";
			str = String.format(format,fa.getSenderName(),fa.getReceiverName(),fa.getSenderCompany(), fa.getReceiverCompany(),
					fa.getTelSender(),fa.getTelReceiver(),fa.getAssistantName());
			sb.append(str);
		}

		
		sb.append("\"A11111\":\"001\"}");
		//sb.append("}");
		String strJson = sb.toString();
        // 第二种配置数据源的方式 InputStream
        InputStream is;
		try {
			is = new ByteArrayInputStream(strJson.getBytes("UTF-8"));
			Map<String, Object> parameters = new HashMap<String, Object>();
	        parameters.put("JSON_INPUT_STREAM", is);
	        // 配置其他参数
	        parameters.put(JsonQueryExecuterFactory.JSON_LOCALE, Locale.ENGLISH);
	        parameters.put(JRParameter.REPORT_LOCALE, Locale.US);
	        System.out.println(strJson);
	        
	        return JasperFillManager.fillReport(jrxmlDestPath, parameters);

	        
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	private JasperPrint getThirdJasperPrint(TlCustomBaseinfo tl,String jrxmlDestPath,List<TlTestprojectChild> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		String str;
		
		int start = 1;
		String strs[] = {"x","√"};
		
		
		String format;		

		for(TlTestprojectChild tlc :list) {
			if(tlc.getTestRoad() < 5)
				continue;
			start = tlc.getTestRoad() - 4;
			format = String.format("\"G%s\":\"%s\",\"J%s\":\"%s\",\"W%s\":\"%s\",\"Z%s\":\"%s\",",
					start,"%s",start,"%s",start,"%s",start,"%s",start,"%s");
			str = String.format(format, tlc.getCarTime(),tlc.getBriefDescription(),tlc.getLimitSpeed(),tlc.getCarLimNum());
			sb.append(str);

			start ++;

		}
		
		start = 11;
		
		List<Dict> listDict = DictUtils.getDictList("test_road");
		String labels[] = new String[listDict.size()];
		for(int ii = 0 ; ii < listDict.size(); ii ++) {
			labels[ii] = listDict.get(ii).getLabel();
		}
		
		TlTestRoomReservationChild tlTestRoomReservationChild = new TlTestRoomReservationChild();
		tlTestRoomReservationChild.setTlCustomBaseinfoId(tl.getId());
		List<TlTestRoomReservationChild> listTest = tlTestRoomReservationChildService.findList(tlTestRoomReservationChild);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(TlTestRoomReservationChild trrc : listTest) {
			
			format = String.format("\"A%s\":\"%s\",\"G%s\":\"%s\",\"M%s\":\"%s\",\"T%s\":\"%s\",",
					start,"%s",start,"%s",start,"%s",start,"%s",start,"%s");
			Date date = trrc.getPackageDate();
			str = String.format(format, labels[trrc.getTestRoad()],sdf.format(date),trrc.getPackageTime(),trrc.getCarLimNum());
			sb.append(str);

			start ++;
		}
		
		TlOtherExtendsInfo tlOtherExtendsInfo = new TlOtherExtendsInfo();
		tlOtherExtendsInfo.setParentId(tl.getId());
		List<TlOtherExtendsInfo> oesList = tlOtherExtendsInfoService.findList(tlOtherExtendsInfo);
		
		if(oesList.size() >= 1) {
			
			TlOtherExtendsInfo oes = oesList.get(0);
			format = "\"H6\":\"%s\",\"H7\":\"%s\",\"F18\":\"%s\",\"E22\":\"%s\",";
			str = String.format(format,oes.getDangerDescription(),oes.getSafeExplain(),oes.getSpecificRequirement(),oes.getOtherSpecialServices());
			sb.append(str);
			
			if(oes.getIsdanger().equals("1")) {
				sb.append("\"L5\":\"√\",");
			}else {
				sb.append("\"P5\":\"√\",");
			}
			
			if(oes.getIscamera().equals("1")) {
				sb.append("\"L8\":\"√\",");
			}else {
				sb.append("\"L8\":\"√\",");
			}
			
			if(oes.getIsCarRentalService().equals("1")) {
				sb.append("\"I20\":\"√\",");
			}else {
				sb.append("\"L20\":\"√\",");
			}
			
			if(oes.getIsNeedHireTestDriver().equals("1")) {
				sb.append("\"I21\":\"√\",");
			}else {
				sb.append("\"L21\":\"√\",");
			}
			
			if(oes.getPublicWorkshop() != null &&oes.getPublicWorkshop().equals("1")) {
				sb.append("\"B17\":\"√\",");
			}
			
			if(oes.getConfidentialWorkshop() != null && oes.getConfidentialWorkshop().equals("1")) {
				sb.append("\"G17\":\"√\",");
			}
			
			if(oes.getMeetingRoom()!= null && oes.getMeetingRoom().equals("1")) {
				sb.append("\"L17\":\"√\",");
			}
			
		}
		
		
		sb.append("\"B1\":\"001\"}");
		//sb.append("}");
		String strJson = sb.toString();
        // 第二种配置数据源的方式 InputStream
        InputStream is;
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			TlCustomBaseinfo tl2 = get(tl.getId());
			String userId = tl2.getMarketId();
			if(!StringUtils.isBlank(userId)) {
				TlSeal tlSeal = new TlSeal();
				User user = new User();
				user.setId(userId);
				tlSeal.setUser(user);
				List<TlSeal> sealList = tlSealService.findList(tlSeal);
				
				if(sealList.size() >= 1) {
					tlSeal = sealList.get(0);
					InputStream buffin = new ByteArrayInputStream(tlSeal.getImage());
					parameters.put("ANALYS_M", buffin);
				}
				
			}
			
			userId = tl2.getFieldId();
			if(!StringUtils.isBlank(userId)) {
				TlSeal tlSeal = new TlSeal();
				User user = new User();
				user.setId(userId);
				tlSeal.setUser(user);
				List<TlSeal> sealList = tlSealService.findList(tlSeal);
				if(sealList.size() >= 1) {
					tlSeal = sealList.get(0);
					InputStream buffin = new ByteArrayInputStream(tlSeal.getImage());
					parameters.put("CHECK_M", buffin);
				}
				
			}
			
			is = new ByteArrayInputStream(strJson.getBytes("UTF-8"));	
	        parameters.put("JSON_INPUT_STREAM", is);
	        // 配置其他参数
	        parameters.put(JsonQueryExecuterFactory.JSON_LOCALE, Locale.ENGLISH);
	        parameters.put(JRParameter.REPORT_LOCALE, Locale.US);
	        System.out.println(strJson);
	        
	        return JasperFillManager.fillReport(jrxmlDestPath, parameters);
  
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	private JasperPrint getSecondJasperPrint(TlCustomBaseinfo tl,String jrxmlDestPath,List<TlTestprojectChild> list) {
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		String str;
		
		int start = 26;
		String strs[] = {"x","√"};
		
		String format;		

		for(TlTestprojectChild tlc :list) {
			start = 26 + tlc.getTestRoad();
			format = String.format("\"G%s\":\"%s\",\"J%s\":\"%s\",\"W%s\":\"%s\",\"Z%s\":\"%s\",",
					start,"%s",start,"%s",start,"%s",start,"%s",start,"%s");
			str = String.format(format, tlc.getCarTime(),tlc.getBriefDescription(),tlc.getLimitSpeed(),tlc.getCarLimNum());
			sb.append(str);

			start ++;

		}
		
		TlTestSiteHotel tlTestSiteHotel = new TlTestSiteHotel();
		tlTestSiteHotel.setParentId(tl.getId());
		List<TlTestSiteHotel> listTsh = tlTestSiteHotelService.findList(tlTestSiteHotel);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(TlTestSiteHotel tsh : listTsh) {
			start = tsh.getRoomType() + 8;
			format = String.format("\"G%s\":\"%s\",\"L%s\":\"%s\",\"S%s\":\"%s\",",
					start,"%s",start,"%s",start,"%s",start,"%s");
			str = String.format(format, tsh.getReserveQuantity(),sdf.format(tsh.getCheckInDate()),sdf.format(tsh.getCheckOutDate()));
			sb.append(str);

			start ++;
		}
		
		TlCarInfo tlCarInfo = new TlCarInfo();
		tlCarInfo.setParentId(tl.getId());
		
		List<TlCarInfo> tlCarInfoList = tlCarInfoService.findList(tlCarInfo);
		start = 13;
		
		List<Dict> listDict = DictUtils.getDictList("fuel_type");
		String labels[] = new String[listDict.size()];
		for(int ii = 0 ; ii < listDict.size(); ii ++) {
			labels[ii] = listDict.get(ii).getLabel();
		}
		
		//String oiltype[] = {"92#","95#","柴油","充电","其它"};
		for(TlCarInfo tlci : tlCarInfoList) {
			sb.append("\"B");
			if(tlci.getCarType() == 0) {
				sb.append(start);
			}else {
				sb.append(start + 1);
			}
			sb.append("\":\"√\",");
			
			sb.append("\"E");
			if(tlci.getLoadType() == 0) {
				sb.append(start);
			}else {
				sb.append(start + 1);
			}
			sb.append("\":\"√\",");
			
			if (tlci.getLoadType() == 1) {
				str = String.format("\"J%d\":\"%s\",", start, tlci.getCarWeight());
				sb.append(str);
				str = String.format("\"J%d\":\"%s\",", start + 1, tlci.getMaxAxleLoad());
				sb.append(str);
			}
			
			str = String.format("\"L%d\":\"%s\",", start, labels[tlci.getFuelType()]);
			sb.append(str);
			str = String.format("\"N%d\":\"%s\",", start + 1, tlci.getEstimatedConsumption());
			sb.append(str);
			
			str = String.format("\"Q%d\":\"%s\",", start, tlci.getColorLicense());
			sb.append(str);
			
			str = String.format("\"U%d\":\"%s\",", start, tlci.getBrandModel());
			sb.append(str);
			
			str = String.format("\"X%d\":\"%s\",", start, tlci.getLimitSpeed());
			sb.append(str);
			
			str = String.format("\"AA%d\":\"%s\",", start, tlci.getVinAfterSix());
			sb.append(str);
			
			
			start += 2;
			
			
		}
		
		
		
		
		sb.append("\"B1\":\"001\"}");
		//sb.append("}");
		String strJson = sb.toString();
        // 第二种配置数据源的方式 InputStream
        InputStream is;
		try {
			is = new ByteArrayInputStream(strJson.getBytes("UTF-8"));
			Map<String, Object> parameters = new HashMap<String, Object>();
	        parameters.put("JSON_INPUT_STREAM", is);
	        // 配置其他参数
	        parameters.put(JsonQueryExecuterFactory.JSON_LOCALE, Locale.ENGLISH);
	        parameters.put(JRParameter.REPORT_LOCALE, Locale.US);
	        System.out.println(strJson);
	        
	        return JasperFillManager.fillReport(jrxmlDestPath, parameters);

	        
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	@RequiresPermissions("modules:tlCustomBaseinfo:view")
	@RequestMapping(value = "showReport")
	public String showReport(TlCustomBaseinfo tlCustomBaseinfo,HttpServletRequest request,HttpServletResponse response) {
		try {

			ServletOutputStream ouputStream = response.getOutputStream();
			// pdf文件生成路径
			String jrxmlDestPath = request.getSession().getServletContext().getRealPath("/jasper/" + "11.jasper");

            
			List<JasperPrint> list = new ArrayList<JasperPrint>();
			
			JasperPrint jp = this.getFirstJasperPrint(tlCustomBaseinfo, jrxmlDestPath);
			list.add(jp);
			jrxmlDestPath = request.getSession().getServletContext().getRealPath("/jasper/" + "22.jasper");
			
			TlTestprojectChild tlTestprojectChild = new TlTestprojectChild();
			tlTestprojectChild.setTlTestprojectId(tlCustomBaseinfo.getId());
			List<TlTestprojectChild> listTP = tlTestprojectChildService.findList(tlTestprojectChild);
			jp = this.getSecondJasperPrint(tlCustomBaseinfo, jrxmlDestPath,listTP);
			list.add(jp);
			
			jrxmlDestPath = request.getSession().getServletContext().getRealPath("/jasper/" + "33.jasper");
			
			//JasperExportManager.exportReportToHtmlFile(jp,"D:\\aa.html");
			//System.out.println(strXml);
			jp = this.getThirdJasperPrint(tlCustomBaseinfo, jrxmlDestPath,listTP);
			list.add(jp);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, list);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			byte[] bytes = baos.toByteArray();
            
			
//			byte[] bytes = JasperRunManager.runReportToPdf(jrxmlDestPath, parameters);
//			
			response.setContentType("application/pdf");
			// 设置中文字体解决pdf格式中文不显示问题
			response.setCharacterEncoding("utf-8");
			response.setContentLength(bytes.length);
			ouputStream.write(bytes, 0, bytes.length);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequiresPermissions("modules:tlCustomBaseinfo:edit")
	@RequestMapping(value = "save")
	public String save(TlCustomBaseinfo tlCustomBaseinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlCustomBaseinfo)){
			return form(tlCustomBaseinfo, model);
		}
		tlCustomBaseinfoService.save(tlCustomBaseinfo);
//		addMessage(redirectAttributes, "保存试验测试申请表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCustomBaseinfo/?repage";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:edit")
	@RequestMapping(value = "submitAudit")
	public String submitAudit(TlCustomBaseinfo tlCustomBaseinfo, Model model, RedirectAttributes redirectAttributes) {
		tlCustomBaseinfoService.submitAudit(tlCustomBaseinfo);
		addMessage(redirectAttributes, "保存试验测试申请表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCustomBaseinfo/list";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:audit")
	@RequestMapping(value = "formAudit")
	public String formAudit(TlCustomBaseinfo tlCustomBaseinfo, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, tlCustomBaseinfo)){
//			return form(tlCustomBaseinfo, model);
//		}
//		tlCustomBaseinfoService.audit(tlCustomBaseinfo,pass);
//		addMessage(redirectAttributes, "保存试验测试申请表成功");
		
		TlVistorRegister tlVistorRegister = new TlVistorRegister();
		
		tlVistorRegister.setParentId(tlCustomBaseinfo.getId());
		List<TlVistorRegister> listVistor = tlVistorRegisterService.findList(tlVistorRegister);
		model.addAttribute("listVistor", listVistor);
		
		String  tlTestprojectId = tlCustomBaseinfo.getId();
		TlTestSiteHotel tlTestSiteHotel = new TlTestSiteHotel();
		
		tlTestSiteHotel.setParentId(tlTestprojectId);
		List<TlTestSiteHotel> listHotel = 
		tlTestSiteHotelService.findList(tlTestSiteHotel);
		
		TlCarInfo tlCarInfo = new TlCarInfo();
		tlCarInfo.setParentId(tlTestprojectId);
		List<TlCarInfo> listCarInfo = tlCarInfoService.findList(tlCarInfo);
		
		TlTestprojectChild tlTestprojectChild = new TlTestprojectChild();
		tlTestprojectChild.setTlTestprojectId(tlTestprojectId);
		List<TlTestprojectChild> listTC =tlTestprojectChildService.findList(tlTestprojectChild);
		
		TlTestRoomReservationChild tlTestRoomReservationChild = new TlTestRoomReservationChild();
		tlTestRoomReservationChild.setTlCustomBaseinfoId(tlTestprojectId);
		List<TlTestRoomReservationChild> listTest = tlTestRoomReservationChildService.findList(tlTestRoomReservationChild);
		
		TlFinanceInfo tlFinanceInfo = new TlFinanceInfo();
		tlFinanceInfo.setParentId(tlTestprojectId);
		List<TlFinanceInfo> listFI = tlFinanceInfoService.findList(tlFinanceInfo);
		if(listFI.size() == 1)
			tlFinanceInfo = listFI.get(0);
		TlSendAddress tlSendAddress = new TlSendAddress();
		List<TlSendAddress> listtSA =tlSendAddressService.findList(tlSendAddress);
		if(listtSA.size() == 1)
			tlSendAddress = listtSA.get(0);
		model.addAttribute("tlSendAddress", tlSendAddress);
		model.addAttribute("tlCustomBaseinfo", tlCustomBaseinfo);
		model.addAttribute("tlFinanceInfo", tlFinanceInfo);
		
		model.addAttribute("listTest", listTest);
		
		model.addAttribute("listTC", listTC);
		model.addAttribute("listCarInfo", listCarInfo);
		model.addAttribute("listHotel", listHotel);
		model.addAttribute("tlCustomBaseinfo", tlCustomBaseinfo);
		
		TlOtherExtendsInfo tlOtherExtendsInfo = new TlOtherExtendsInfo();
		tlOtherExtendsInfo.setParentId(tlTestprojectId);
		List<TlOtherExtendsInfo> listOEI = tlOtherExtendsInfoService.findList(tlOtherExtendsInfo);
		if(listOEI.size() == 0)
			tlOtherExtendsInfo = new TlOtherExtendsInfo();
		else
			tlOtherExtendsInfo = listOEI.get(0);
		model.addAttribute("tlCustomBaseinfo", tlCustomBaseinfo);
		model.addAttribute("tlOtherExtendsInfo", tlOtherExtendsInfo);
		
		TlTestTaskList tlTestTaskList = new TlTestTaskList();
		tlTestTaskList.setParentId(tlTestprojectId);
		List<TlTestTaskList> listTTL = tlTestTaskListService.findList(tlTestTaskList);
		model.addAttribute("listTTL", listTTL);
		//addMessage(redirectAttributes, "保存试验测试申请表成功");
		return "terlu/modules/tlCustomBaseinfoAudit";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:audit")
	@RequestMapping(value = "audit")
	public String audit(TlCustomBaseinfo tlCustomBaseinfo, Model model, RedirectAttributes redirectAttributes) {
		if(tlCustomBaseinfo.getStatus() == 2) {
			return submitAudit(tlCustomBaseinfo,model, redirectAttributes);
		}
		tlCustomBaseinfoService.audit(tlCustomBaseinfo);
		addMessage(redirectAttributes, "保存试验测试申请表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCustomBaseinfo/listTodo";
	}
	
	@RequiresPermissions("modules:tlCustomBaseinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TlCustomBaseinfo tlCustomBaseinfo, RedirectAttributes redirectAttributes) {
		tlCustomBaseinfoService.delete(tlCustomBaseinfo);
		addMessage(redirectAttributes, "删除试验测试申请表成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlCustomBaseinfo/list";
	}

}
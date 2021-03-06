/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.terlu.modules.ai.aip.auth.AuthService;
import com.terlu.modules.ai.aip.utils.Base64Util;
import com.terlu.modules.ai.aip.utils.HttpUtil;
import com.terlu.modules.entity.TlDriverZj;
import com.terlu.modules.service.TlDriverZjService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
/**
 * 驾驶员证件Controller
 * @author wangqi
 * @version 2020-06-02
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlDriverZj")
public class TlDriverZjController extends BaseController {

	@Autowired
	private TlDriverZjService tlDriverZjService;
	
	@ModelAttribute
	public TlDriverZj get(@RequestParam(required=false) String id) {
		TlDriverZj entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlDriverZjService.get(id);
		}
		if (entity == null){
			entity = new TlDriverZj();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlDriverZj:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlDriverZj tlDriverZj, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDriverZj> page = tlDriverZjService.findPage(new Page<TlDriverZj>(request, response), tlDriverZj); 
		model.addAttribute("page", page);
		return "terlu/modules/tlDriverZjList";
	}

	@RequiresPermissions("modules:tlDriverZj:view")
	@RequestMapping(value = "form")
	public String form(TlDriverZj tlDriverZj, Model model) {
		model.addAttribute("tlDriverZj", tlDriverZj);
		return "terlu/modules/tlDriverZjForm";
	}

	@RequiresPermissions("modules:tlDriverZj:edit")
	@RequestMapping(value = "save")
	public String save(@RequestParam("files") MultipartFile file,TlDriverZj tlDriverZj, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlDriverZj)){
			return form(tlDriverZj, model);
		}
		byte[] fileBytes = null;
		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(fileBytes != null && fileBytes.length > 0){
			tlDriverZj.setIdcardPhoto(fileBytes);
		}
		try {
			byte[] idcardPhoto = tlDriverZj.getIdcardPhoto();
			String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
            String imgStr = Base64Util.encode(idcardPhoto);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "id_card_side=" + "front" + "&image=" + imgParam;
            AuthService auth = new AuthService();
            String accessToken = auth.getAuth("UaGq0GWBaDOOPxvoyh39beek","FbQOckuUCGkT2ysWNBG7qFB9XzxFLqpf");
            String result = HttpUtil.post(url, accessToken, param);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String words_result = jsonObject.getString("words_result");
            JSONObject parse = JSONObject.parseObject(words_result);
            List<String> list = new ArrayList<String>();
            for (Map.Entry<String, Object> entry : parse.entrySet()) {
                JSONObject attr = JSONObject.parseObject(String.valueOf(entry.getValue()));
                String words = attr.getString("words");
                list.add(words);
            }
            String name = list.get(0);
            String nation = list.get(1);
            String iDcard = list.get(3);
            String address = list.get(2);
            String birth = list.get(4);
            String sex = list.get(5);
            tlDriverZj.setNation(nation);
            tlDriverZj.setName(name);
            tlDriverZj.setIDcard(iDcard);
            tlDriverZj.setAddress(address);
            tlDriverZj.setBirth(birth);
            tlDriverZj.setSex(sex);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		
		tlDriverZjService.save(tlDriverZj);
		addMessage(redirectAttributes, "保存身份证件照成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverZj/?repage";
	}
	
	@RequiresPermissions("modules:tlDriverZj:edit")
	@RequestMapping(value = "delete")
	public String delete(TlDriverZj tlDriverZj, RedirectAttributes redirectAttributes) {
		tlDriverZjService.delete(tlDriverZj);
		addMessage(redirectAttributes, "删除驾驶员证件成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverZj/?repage";
	}
	
	@RequestMapping(value = "showIdcard")
	public String showIdcard(String id,HttpServletResponse response, Model model, HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		response.setHeader("ContentType", "image/jpeg");
		TlDriverZj tlDriverZj = tlDriverZjService.get(id);
		BufferedImage img = null;
		if(tlDriverZj != null && tlDriverZj.getIdcardPhoto() != null){
			InputStream buffin = new ByteArrayInputStream(tlDriverZj.getIdcardPhoto());
				try {
					img = ImageIO.read(buffin);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else{
			String path=request.getSession().getServletContext().getRealPath("/");
			FileInputStream buffin = null;
			try {
				buffin = new FileInputStream(path + "static/images/yinzhang/2.gif");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				img = ImageIO.read(buffin);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("png");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
			ImageIO.write(img, "png", sos);
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//流程处理
	@RequiresPermissions("modules:tlDriverZj:audit")
	@RequestMapping(value = {"listTodo"})
	public String listTodo(TlDriverZj tlDriverZj, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlDriverZj> page = tlDriverZjService.findToDoTaskPage(tlDriverZj);
		model.addAttribute("page", page);
		return "terlu/modules/tlDriverZjList";
	}
	
	@RequiresPermissions("modules:tlDriverZj:audit")
	@RequestMapping(value = "formAudit")
	public String formAudit(TlDriverZj tlDriverZj, Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("tlDriverZj",tlDriverZj);
		return "terlu/modules/tlDriverZjAudit";
	}
	
	@RequiresPermissions("modules:tlDriverZj:edit")
	@RequestMapping(value = "submitAudit")
	public String submitAudit(TlDriverZj tlDriverZj, Model model, RedirectAttributes redirectAttributes) {
		tlDriverZjService.submitAudit(tlDriverZj);
		addMessage(redirectAttributes, "保存身份证件成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverZj/list";
	}
	
	@RequiresPermissions("modules:tlDriverZj:audit")
	@RequestMapping(value = "audit")
	public String audit(TlDriverZj tlDriverZj, Model model, RedirectAttributes redirectAttributes) {
		if(tlDriverZj.getStatus() == 2) {
			return submitAudit(tlDriverZj,model, redirectAttributes);
		}
		tlDriverZjService.audit(tlDriverZj);
		addMessage(redirectAttributes, "保存身份证件成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlDriverZj/listTodo";
	}
	
}
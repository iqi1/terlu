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

import javax.imageio.ImageIO;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.terlu.modules.entity.TlSeal;
import com.terlu.modules.service.TlSealService;

/**
 * 电子签名Controller
 * @author sunlifeng
 * @version 2020-01-06
 */
@Controller
@RequestMapping(value = "${adminPath}/modules/tlSeal")
public class TlSealController extends BaseController {

	@Autowired
	private TlSealService tlSealService;
	
	@ModelAttribute
	public TlSeal get(@RequestParam(required=false) String id) {
		TlSeal entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tlSealService.get(id);
		}
		if (entity == null){
			entity = new TlSeal();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tlSeal:view")
	@RequestMapping(value = {"list", ""})
	public String list(TlSeal tlSeal, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TlSeal> page = tlSealService.findPage(new Page<TlSeal>(request, response), tlSeal); 
		model.addAttribute("page", page);
		return "terlu/modules/tlSealList";
	}

	@RequiresPermissions("modules:tlSeal:view")
	@RequestMapping(value = "form")
	public String form(TlSeal tlSeal, Model model) {
		model.addAttribute("tlSeal", tlSeal);
		return "terlu/modules/tlSealForm";
	}
	
	@RequestMapping(value = "showImg")
	public String showImg(String id,HttpServletResponse response, Model model, HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		response.setHeader("ContentType", "image/jpeg");
		TlSeal tlSeal = tlSealService.get(id);
		BufferedImage img = null;
		if(tlSeal != null && tlSeal.getImage() != null){
			InputStream buffin = new ByteArrayInputStream(tlSeal.getImage());
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

	@RequiresPermissions("modules:tlSeal:edit")
	@RequestMapping(value = "save")
	public String save(@RequestParam("files") MultipartFile file, TlSeal tlSeal, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tlSeal)){
			return form(tlSeal, model);
		}
		
		byte[] fileBytes = null;
		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(fileBytes != null && fileBytes.length > 0){
			tlSeal.setImage(fileBytes);
		}
		
		tlSealService.save(tlSeal);
		addMessage(redirectAttributes, "保存电子签名成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSeal/?repage";
	}
	
	@RequiresPermissions("modules:tlSeal:edit")
	@RequestMapping(value = "delete")
	public String delete(TlSeal tlSeal, RedirectAttributes redirectAttributes) {
		tlSealService.delete(tlSeal);
		addMessage(redirectAttributes, "删除电子签名成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tlSeal/?repage";
	}

}
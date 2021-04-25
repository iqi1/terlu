/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 试验场酒店预定Entity
 * @author wangqi
 * @version 2019-12-31
 */
public class TlTestSiteHotel extends DataEntity<TlTestSiteHotel> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private Integer roomType;		// 房间类型
	private String reserveQuantity;		// 预定数量
	private Date checkInDate;		// 入住日期
	private Date checkOutDate;		// 退房日期
	
	public TlTestSiteHotel() {
		super();
	}

	public TlTestSiteHotel(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父id不能为空")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	

	@NotNull(message="房间类型不能为空")
	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}
	
	@Length(min=1, max=16, message="预定数量长度必须介于 1 和 16 之间")
	public String getReserveQuantity() {
		return reserveQuantity;
	}

	public void setReserveQuantity(String reserveQuantity) {
		this.reserveQuantity = reserveQuantity;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="入住日期不能为空")
	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="退房日期不能为空")
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
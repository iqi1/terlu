/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.terlu.modules.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 车辆信息登记Entity
 * @author wangqi
 * @version 2019-12-31
 */
public class TlCarInfo extends DataEntity<TlCarInfo> {
	
	private static final long serialVersionUID = 1L;
	private String parentId;		// 父id
	private Integer carType;		// 车辆类型
	private Integer loadType;		// 载重类型
	private String carWeight;		// 车重
	private String maxAxleLoad;		// 最大轴重
	private Integer fuelType;		// 燃料类型
	private String estimatedConsumption;		// 预计消耗量
	private String colorLicense;		// 颜色/牌照
	private String brandModel;		// 品牌型号
	private String limitSpeed;		// 最高车速
	private String vinAfterSix;		// VIN后6位
	
	public TlCarInfo() {
		super();
	}

	public TlCarInfo(String id){
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
	
	@NotNull( message="车辆类型长度必须介于 1 和 5 之间")
	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}
	
	@NotNull( message="载重类型长度必须介于 1 和 6 之间")
	public Integer getLoadType() {
		return loadType;
	}

	public void setLoadType(Integer loadType) {
		this.loadType = loadType;
	}
	
	@Length(min=1, max=16, message="车重长度必须介于 1 和 16 之间")
	public String getCarWeight() {
		return carWeight;
	}

	public void setCarWeight(String carWeight) {
		this.carWeight = carWeight;
	}
	
	@Length(min=1, max=16, message="最大轴重长度必须介于 1 和 16 之间")
	public String getMaxAxleLoad() {
		return maxAxleLoad;
	}

	public void setMaxAxleLoad(String maxAxleLoad) {
		this.maxAxleLoad = maxAxleLoad;
	}
	
	@NotNull( message="燃料类型长度必须介于 1 和 10 之间")
	public Integer getFuelType() {
		return fuelType;
	}

	public void setFuelType(Integer fuelType) {
		this.fuelType = fuelType;
	}
	
	@Length(min=1, max=16, message="预计消耗量长度必须介于 1 和 16 之间")
	public String getEstimatedConsumption() {
		return estimatedConsumption;
	}

	public void setEstimatedConsumption(String estimatedConsumption) {
		this.estimatedConsumption = estimatedConsumption;
	}
	
	@Length(min=1, max=32, message="颜色/牌照长度必须介于 1 和 32 之间")
	public String getColorLicense() {
		return colorLicense;
	}

	public void setColorLicense(String colorLicense) {
		this.colorLicense = colorLicense;
	}
	
	@Length(min=1, max=32, message="品牌型号长度必须介于 1 和 32 之间")
	public String getBrandModel() {
		return brandModel;
	}

	public void setBrandModel(String brandModel) {
		this.brandModel = brandModel;
	}
	
	@Length(min=1, max=16, message="最高车速长度必须介于 1 和 16 之间")
	public String getLimitSpeed() {
		return limitSpeed;
	}

	public void setLimitSpeed(String limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
	
	@Length(min=1, max=6, message="VIN后6位长度必须介于 1 和 6 之间")
	public String getVinAfterSix() {
		return vinAfterSix;
	}

	public void setVinAfterSix(String vinAfterSix) {
		this.vinAfterSix = vinAfterSix;
	}
	
}
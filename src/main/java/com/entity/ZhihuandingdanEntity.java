package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 置换订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
@TableName("zhihuandingdan")
public class ZhihuandingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhihuandingdanEntity() {
		
	}
	
	public ZhihuandingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 置换编号
	 */
					
	private String zhihuanbianhao;
	
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 置换账号
	 */
					
	private String zhihuanzhanghao;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 置换物品
	 */
					
	private String zhihuanwupin;
	
	/**
	 * 物品图片
	 */
					
	private String wupintupian;
	
	/**
	 * 物品品牌
	 */
					
	private String wupinpinpai;
	
	/**
	 * 物品成色
	 */
					
	private String wupinchengse;
	
	/**
	 * 物品详情
	 */
					
	private String wupinxiangqing;
	
	/**
	 * 交换地址
	 */
					
	private String jiaohuandizhi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：置换编号
	 */
	public void setZhihuanbianhao(String zhihuanbianhao) {
		this.zhihuanbianhao = zhihuanbianhao;
	}
	/**
	 * 获取：置换编号
	 */
	public String getZhihuanbianhao() {
		return zhihuanbianhao;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：置换账号
	 */
	public void setZhihuanzhanghao(String zhihuanzhanghao) {
		this.zhihuanzhanghao = zhihuanzhanghao;
	}
	/**
	 * 获取：置换账号
	 */
	public String getZhihuanzhanghao() {
		return zhihuanzhanghao;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：置换物品
	 */
	public void setZhihuanwupin(String zhihuanwupin) {
		this.zhihuanwupin = zhihuanwupin;
	}
	/**
	 * 获取：置换物品
	 */
	public String getZhihuanwupin() {
		return zhihuanwupin;
	}
	/**
	 * 设置：物品图片
	 */
	public void setWupintupian(String wupintupian) {
		this.wupintupian = wupintupian;
	}
	/**
	 * 获取：物品图片
	 */
	public String getWupintupian() {
		return wupintupian;
	}
	/**
	 * 设置：物品品牌
	 */
	public void setWupinpinpai(String wupinpinpai) {
		this.wupinpinpai = wupinpinpai;
	}
	/**
	 * 获取：物品品牌
	 */
	public String getWupinpinpai() {
		return wupinpinpai;
	}
	/**
	 * 设置：物品成色
	 */
	public void setWupinchengse(String wupinchengse) {
		this.wupinchengse = wupinchengse;
	}
	/**
	 * 获取：物品成色
	 */
	public String getWupinchengse() {
		return wupinchengse;
	}
	/**
	 * 设置：物品详情
	 */
	public void setWupinxiangqing(String wupinxiangqing) {
		this.wupinxiangqing = wupinxiangqing;
	}
	/**
	 * 获取：物品详情
	 */
	public String getWupinxiangqing() {
		return wupinxiangqing;
	}
	/**
	 * 设置：交换地址
	 */
	public void setJiaohuandizhi(String jiaohuandizhi) {
		this.jiaohuandizhi = jiaohuandizhi;
	}
	/**
	 * 获取：交换地址
	 */
	public String getJiaohuandizhi() {
		return jiaohuandizhi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}

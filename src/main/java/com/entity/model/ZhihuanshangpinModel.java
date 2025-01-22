package com.entity.model;

import com.entity.ZhihuanshangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 置换商品
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
public class ZhihuanshangpinModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 置换状态
	 */
	
	private String zhihuanzhuangtai;
		
	/**
	 * 商品分类
	 */
	
	private String shangpinfenlei;
		
	/**
	 * 成色
	 */
	
	private String chengse;
		
	/**
	 * 品牌
	 */
	
	private String pinpai;
		
	/**
	 * 商品详情
	 */
	
	private String shangpinxiangqing;
		
	/**
	 * 置换账号
	 */
	
	private String zhihuanzhanghao;
		
	/**
	 * 置换姓名
	 */
	
	private String zhihuanxingming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：置换状态
	 */
	 
	public void setZhihuanzhuangtai(String zhihuanzhuangtai) {
		this.zhihuanzhuangtai = zhihuanzhuangtai;
	}
	
	/**
	 * 获取：置换状态
	 */
	public String getZhihuanzhuangtai() {
		return zhihuanzhuangtai;
	}
				
	
	/**
	 * 设置：商品分类
	 */
	 
	public void setShangpinfenlei(String shangpinfenlei) {
		this.shangpinfenlei = shangpinfenlei;
	}
	
	/**
	 * 获取：商品分类
	 */
	public String getShangpinfenlei() {
		return shangpinfenlei;
	}
				
	
	/**
	 * 设置：成色
	 */
	 
	public void setChengse(String chengse) {
		this.chengse = chengse;
	}
	
	/**
	 * 获取：成色
	 */
	public String getChengse() {
		return chengse;
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
	 * 设置：商品详情
	 */
	 
	public void setShangpinxiangqing(String shangpinxiangqing) {
		this.shangpinxiangqing = shangpinxiangqing;
	}
	
	/**
	 * 获取：商品详情
	 */
	public String getShangpinxiangqing() {
		return shangpinxiangqing;
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
	 * 设置：置换姓名
	 */
	 
	public void setZhihuanxingming(String zhihuanxingming) {
		this.zhihuanxingming = zhihuanxingming;
	}
	
	/**
	 * 获取：置换姓名
	 */
	public String getZhihuanxingming() {
		return zhihuanxingming;
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
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}

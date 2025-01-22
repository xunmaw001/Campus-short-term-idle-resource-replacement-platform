package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhihuandingdanEntity;
import com.entity.view.ZhihuandingdanView;

import com.service.ZhihuandingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 置换订单
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
@RestController
@RequestMapping("/zhihuandingdan")
public class ZhihuandingdanController {
    @Autowired
    private ZhihuandingdanService zhihuandingdanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhihuandingdanEntity zhihuandingdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhihuanzhanghu")) {
			zhihuandingdan.setZhihuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zhihuandingdan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhihuandingdanEntity> ew = new EntityWrapper<ZhihuandingdanEntity>();
		PageUtils page = zhihuandingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuandingdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhihuandingdanEntity zhihuandingdan, 
		HttpServletRequest request){
        EntityWrapper<ZhihuandingdanEntity> ew = new EntityWrapper<ZhihuandingdanEntity>();
		PageUtils page = zhihuandingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuandingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhihuandingdanEntity zhihuandingdan){
       	EntityWrapper<ZhihuandingdanEntity> ew = new EntityWrapper<ZhihuandingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhihuandingdan, "zhihuandingdan")); 
        return R.ok().put("data", zhihuandingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhihuandingdanEntity zhihuandingdan){
        EntityWrapper< ZhihuandingdanEntity> ew = new EntityWrapper< ZhihuandingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhihuandingdan, "zhihuandingdan")); 
		ZhihuandingdanView zhihuandingdanView =  zhihuandingdanService.selectView(ew);
		return R.ok("查询置换订单成功").put("data", zhihuandingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhihuandingdanEntity zhihuandingdan = zhihuandingdanService.selectById(id);
        return R.ok().put("data", zhihuandingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhihuandingdanEntity zhihuandingdan = zhihuandingdanService.selectById(id);
        return R.ok().put("data", zhihuandingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhihuandingdanEntity zhihuandingdan, HttpServletRequest request){
    	zhihuandingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuandingdan);

        zhihuandingdanService.insert(zhihuandingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhihuandingdanEntity zhihuandingdan, HttpServletRequest request){
    	zhihuandingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuandingdan);

        zhihuandingdanService.insert(zhihuandingdan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhihuandingdanEntity zhihuandingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhihuandingdan);
        zhihuandingdanService.updateById(zhihuandingdan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhihuandingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZhihuandingdanEntity> wrapper = new EntityWrapper<ZhihuandingdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhihuanzhanghu")) {
			wrapper.eq("zhihuanzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zhihuandingdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

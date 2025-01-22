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

import com.entity.ZhihuanshangpinEntity;
import com.entity.view.ZhihuanshangpinView;

import com.service.ZhihuanshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 置换商品
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
@RestController
@RequestMapping("/zhihuanshangpin")
public class ZhihuanshangpinController {
    @Autowired
    private ZhihuanshangpinService zhihuanshangpinService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhihuanshangpinEntity zhihuanshangpin, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhihuanzhanghu")) {
			zhihuanshangpin.setZhihuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhihuanshangpinEntity> ew = new EntityWrapper<ZhihuanshangpinEntity>();
		PageUtils page = zhihuanshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuanshangpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhihuanshangpinEntity zhihuanshangpin, 
		HttpServletRequest request){
        EntityWrapper<ZhihuanshangpinEntity> ew = new EntityWrapper<ZhihuanshangpinEntity>();
		PageUtils page = zhihuanshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuanshangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhihuanshangpinEntity zhihuanshangpin){
       	EntityWrapper<ZhihuanshangpinEntity> ew = new EntityWrapper<ZhihuanshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhihuanshangpin, "zhihuanshangpin")); 
        return R.ok().put("data", zhihuanshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhihuanshangpinEntity zhihuanshangpin){
        EntityWrapper< ZhihuanshangpinEntity> ew = new EntityWrapper< ZhihuanshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhihuanshangpin, "zhihuanshangpin")); 
		ZhihuanshangpinView zhihuanshangpinView =  zhihuanshangpinService.selectView(ew);
		return R.ok("查询置换商品成功").put("data", zhihuanshangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhihuanshangpinEntity zhihuanshangpin = zhihuanshangpinService.selectById(id);
		zhihuanshangpin.setClicknum(zhihuanshangpin.getClicknum()+1);
		zhihuanshangpin.setClicktime(new Date());
		zhihuanshangpinService.updateById(zhihuanshangpin);
        return R.ok().put("data", zhihuanshangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhihuanshangpinEntity zhihuanshangpin = zhihuanshangpinService.selectById(id);
		zhihuanshangpin.setClicknum(zhihuanshangpin.getClicknum()+1);
		zhihuanshangpin.setClicktime(new Date());
		zhihuanshangpinService.updateById(zhihuanshangpin);
        return R.ok().put("data", zhihuanshangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhihuanshangpinEntity zhihuanshangpin, HttpServletRequest request){
    	zhihuanshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuanshangpin);

        zhihuanshangpinService.insert(zhihuanshangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhihuanshangpinEntity zhihuanshangpin, HttpServletRequest request){
    	zhihuanshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuanshangpin);

        zhihuanshangpinService.insert(zhihuanshangpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhihuanshangpinEntity zhihuanshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhihuanshangpin);
        zhihuanshangpinService.updateById(zhihuanshangpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhihuanshangpinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhihuanshangpinEntity> wrapper = new EntityWrapper<ZhihuanshangpinEntity>();
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

		int count = zhihuanshangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhihuanshangpinEntity zhihuanshangpin, HttpServletRequest request,String pre){
        EntityWrapper<ZhihuanshangpinEntity> ew = new EntityWrapper<ZhihuanshangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = zhihuanshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuanshangpin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ZhihuanshangpinEntity zhihuanshangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shangpinfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "zhihuanshangpin").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ZhihuanshangpinEntity> zhihuanshangpinList = new ArrayList<ZhihuanshangpinEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                zhihuanshangpinList.addAll(zhihuanshangpinService.selectList(new EntityWrapper<ZhihuanshangpinEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ZhihuanshangpinEntity> ew = new EntityWrapper<ZhihuanshangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = zhihuanshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuanshangpin), params), params));
        List<ZhihuanshangpinEntity> pageList = (List<ZhihuanshangpinEntity>)page.getList();
        if(zhihuanshangpinList.size()<limit) {
            int toAddNum = (limit-zhihuanshangpinList.size())<=pageList.size()?(limit-zhihuanshangpinList.size()):pageList.size();
            for(ZhihuanshangpinEntity o1 : pageList) {
                boolean addFlag = true;
                for(ZhihuanshangpinEntity o2 : zhihuanshangpinList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    zhihuanshangpinList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(zhihuanshangpinList.size()>limit) {
            zhihuanshangpinList = zhihuanshangpinList.subList(0, limit);
        }
        page.setList(zhihuanshangpinList);
        return R.ok().put("data", page);
    }





}

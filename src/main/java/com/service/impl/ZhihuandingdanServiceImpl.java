package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhihuandingdanDao;
import com.entity.ZhihuandingdanEntity;
import com.service.ZhihuandingdanService;
import com.entity.vo.ZhihuandingdanVO;
import com.entity.view.ZhihuandingdanView;

@Service("zhihuandingdanService")
public class ZhihuandingdanServiceImpl extends ServiceImpl<ZhihuandingdanDao, ZhihuandingdanEntity> implements ZhihuandingdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhihuandingdanEntity> page = this.selectPage(
                new Query<ZhihuandingdanEntity>(params).getPage(),
                new EntityWrapper<ZhihuandingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhihuandingdanEntity> wrapper) {
		  Page<ZhihuandingdanView> page =new Query<ZhihuandingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhihuandingdanVO> selectListVO(Wrapper<ZhihuandingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhihuandingdanVO selectVO(Wrapper<ZhihuandingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhihuandingdanView> selectListView(Wrapper<ZhihuandingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhihuandingdanView selectView(Wrapper<ZhihuandingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

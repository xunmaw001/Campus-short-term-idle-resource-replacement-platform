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


import com.dao.ZhihuanzhanghuDao;
import com.entity.ZhihuanzhanghuEntity;
import com.service.ZhihuanzhanghuService;
import com.entity.vo.ZhihuanzhanghuVO;
import com.entity.view.ZhihuanzhanghuView;

@Service("zhihuanzhanghuService")
public class ZhihuanzhanghuServiceImpl extends ServiceImpl<ZhihuanzhanghuDao, ZhihuanzhanghuEntity> implements ZhihuanzhanghuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhihuanzhanghuEntity> page = this.selectPage(
                new Query<ZhihuanzhanghuEntity>(params).getPage(),
                new EntityWrapper<ZhihuanzhanghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhihuanzhanghuEntity> wrapper) {
		  Page<ZhihuanzhanghuView> page =new Query<ZhihuanzhanghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhihuanzhanghuVO> selectListVO(Wrapper<ZhihuanzhanghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhihuanzhanghuVO selectVO(Wrapper<ZhihuanzhanghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhihuanzhanghuView> selectListView(Wrapper<ZhihuanzhanghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhihuanzhanghuView selectView(Wrapper<ZhihuanzhanghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

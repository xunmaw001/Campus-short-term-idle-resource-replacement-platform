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


import com.dao.ZhihuanshangpinDao;
import com.entity.ZhihuanshangpinEntity;
import com.service.ZhihuanshangpinService;
import com.entity.vo.ZhihuanshangpinVO;
import com.entity.view.ZhihuanshangpinView;

@Service("zhihuanshangpinService")
public class ZhihuanshangpinServiceImpl extends ServiceImpl<ZhihuanshangpinDao, ZhihuanshangpinEntity> implements ZhihuanshangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhihuanshangpinEntity> page = this.selectPage(
                new Query<ZhihuanshangpinEntity>(params).getPage(),
                new EntityWrapper<ZhihuanshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhihuanshangpinEntity> wrapper) {
		  Page<ZhihuanshangpinView> page =new Query<ZhihuanshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhihuanshangpinVO> selectListVO(Wrapper<ZhihuanshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhihuanshangpinVO selectVO(Wrapper<ZhihuanshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhihuanshangpinView> selectListView(Wrapper<ZhihuanshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhihuanshangpinView selectView(Wrapper<ZhihuanshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

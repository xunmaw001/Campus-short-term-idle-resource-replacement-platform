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


import com.dao.DiscusszhihuanshangpinDao;
import com.entity.DiscusszhihuanshangpinEntity;
import com.service.DiscusszhihuanshangpinService;
import com.entity.vo.DiscusszhihuanshangpinVO;
import com.entity.view.DiscusszhihuanshangpinView;

@Service("discusszhihuanshangpinService")
public class DiscusszhihuanshangpinServiceImpl extends ServiceImpl<DiscusszhihuanshangpinDao, DiscusszhihuanshangpinEntity> implements DiscusszhihuanshangpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhihuanshangpinEntity> page = this.selectPage(
                new Query<DiscusszhihuanshangpinEntity>(params).getPage(),
                new EntityWrapper<DiscusszhihuanshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhihuanshangpinEntity> wrapper) {
		  Page<DiscusszhihuanshangpinView> page =new Query<DiscusszhihuanshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhihuanshangpinVO> selectListVO(Wrapper<DiscusszhihuanshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhihuanshangpinVO selectVO(Wrapper<DiscusszhihuanshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhihuanshangpinView> selectListView(Wrapper<DiscusszhihuanshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhihuanshangpinView selectView(Wrapper<DiscusszhihuanshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

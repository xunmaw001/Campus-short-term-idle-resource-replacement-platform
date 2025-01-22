package com.dao;

import com.entity.DiscusszhihuanshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhihuanshangpinVO;
import com.entity.view.DiscusszhihuanshangpinView;


/**
 * 置换商品评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
public interface DiscusszhihuanshangpinDao extends BaseMapper<DiscusszhihuanshangpinEntity> {
	
	List<DiscusszhihuanshangpinVO> selectListVO(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
	
	DiscusszhihuanshangpinVO selectVO(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
	
	List<DiscusszhihuanshangpinView> selectListView(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);

	List<DiscusszhihuanshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
	
	DiscusszhihuanshangpinView selectView(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
	

}

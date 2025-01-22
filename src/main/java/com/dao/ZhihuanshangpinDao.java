package com.dao;

import com.entity.ZhihuanshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhihuanshangpinVO;
import com.entity.view.ZhihuanshangpinView;


/**
 * 置换商品
 * 
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
public interface ZhihuanshangpinDao extends BaseMapper<ZhihuanshangpinEntity> {
	
	List<ZhihuanshangpinVO> selectListVO(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
	
	ZhihuanshangpinVO selectVO(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
	
	List<ZhihuanshangpinView> selectListView(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);

	List<ZhihuanshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
	
	ZhihuanshangpinView selectView(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
	

}

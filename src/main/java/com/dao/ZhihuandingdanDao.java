package com.dao;

import com.entity.ZhihuandingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhihuandingdanVO;
import com.entity.view.ZhihuandingdanView;


/**
 * 置换订单
 * 
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
public interface ZhihuandingdanDao extends BaseMapper<ZhihuandingdanEntity> {
	
	List<ZhihuandingdanVO> selectListVO(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
	
	ZhihuandingdanVO selectVO(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
	
	List<ZhihuandingdanView> selectListView(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);

	List<ZhihuandingdanView> selectListView(Pagination page,@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
	
	ZhihuandingdanView selectView(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
	

}

package com.dao;

import com.entity.ZhihuanzhanghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhihuanzhanghuVO;
import com.entity.view.ZhihuanzhanghuView;


/**
 * 置换账户
 * 
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
public interface ZhihuanzhanghuDao extends BaseMapper<ZhihuanzhanghuEntity> {
	
	List<ZhihuanzhanghuVO> selectListVO(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
	
	ZhihuanzhanghuVO selectVO(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
	
	List<ZhihuanzhanghuView> selectListView(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);

	List<ZhihuanzhanghuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
	
	ZhihuanzhanghuView selectView(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
	

}

package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhihuandingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhihuandingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuandingdanView;


/**
 * 置换订单
 *
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
public interface ZhihuandingdanService extends IService<ZhihuandingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhihuandingdanVO> selectListVO(Wrapper<ZhihuandingdanEntity> wrapper);
   	
   	ZhihuandingdanVO selectVO(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
   	
   	List<ZhihuandingdanView> selectListView(Wrapper<ZhihuandingdanEntity> wrapper);
   	
   	ZhihuandingdanView selectView(@Param("ew") Wrapper<ZhihuandingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhihuandingdanEntity> wrapper);
   	

}


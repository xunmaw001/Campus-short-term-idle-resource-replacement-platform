package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhihuanshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhihuanshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhihuanshangpinView;


/**
 * 置换商品评论表
 *
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
public interface DiscusszhihuanshangpinService extends IService<DiscusszhihuanshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhihuanshangpinVO> selectListVO(Wrapper<DiscusszhihuanshangpinEntity> wrapper);
   	
   	DiscusszhihuanshangpinVO selectVO(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
   	
   	List<DiscusszhihuanshangpinView> selectListView(Wrapper<DiscusszhihuanshangpinEntity> wrapper);
   	
   	DiscusszhihuanshangpinView selectView(@Param("ew") Wrapper<DiscusszhihuanshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhihuanshangpinEntity> wrapper);
   	

}


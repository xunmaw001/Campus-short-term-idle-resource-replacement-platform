package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhihuanshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhihuanshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuanshangpinView;


/**
 * 置换商品
 *
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
public interface ZhihuanshangpinService extends IService<ZhihuanshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhihuanshangpinVO> selectListVO(Wrapper<ZhihuanshangpinEntity> wrapper);
   	
   	ZhihuanshangpinVO selectVO(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
   	
   	List<ZhihuanshangpinView> selectListView(Wrapper<ZhihuanshangpinEntity> wrapper);
   	
   	ZhihuanshangpinView selectView(@Param("ew") Wrapper<ZhihuanshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhihuanshangpinEntity> wrapper);
   	

}


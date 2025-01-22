package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhihuanzhanghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhihuanzhanghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuanzhanghuView;


/**
 * 置换账户
 *
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
public interface ZhihuanzhanghuService extends IService<ZhihuanzhanghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhihuanzhanghuVO> selectListVO(Wrapper<ZhihuanzhanghuEntity> wrapper);
   	
   	ZhihuanzhanghuVO selectVO(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
   	
   	List<ZhihuanzhanghuView> selectListView(Wrapper<ZhihuanzhanghuEntity> wrapper);
   	
   	ZhihuanzhanghuView selectView(@Param("ew") Wrapper<ZhihuanzhanghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhihuanzhanghuEntity> wrapper);
   	

}


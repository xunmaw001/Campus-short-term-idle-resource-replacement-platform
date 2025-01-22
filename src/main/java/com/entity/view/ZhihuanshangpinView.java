package com.entity.view;

import com.entity.ZhihuanshangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 置换商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-25 17:05:25
 */
@TableName("zhihuanshangpin")
public class ZhihuanshangpinView  extends ZhihuanshangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhihuanshangpinView(){
	}
 
 	public ZhihuanshangpinView(ZhihuanshangpinEntity zhihuanshangpinEntity){
 	try {
			BeanUtils.copyProperties(this, zhihuanshangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

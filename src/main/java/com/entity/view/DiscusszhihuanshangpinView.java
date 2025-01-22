package com.entity.view;

import com.entity.DiscusszhihuanshangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 置换商品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-25 17:05:26
 */
@TableName("discusszhihuanshangpin")
public class DiscusszhihuanshangpinView  extends DiscusszhihuanshangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhihuanshangpinView(){
	}
 
 	public DiscusszhihuanshangpinView(DiscusszhihuanshangpinEntity discusszhihuanshangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhihuanshangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

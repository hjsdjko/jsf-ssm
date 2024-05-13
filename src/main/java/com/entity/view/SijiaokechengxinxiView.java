package com.entity.view;

import com.entity.SijiaokechengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-01-26
 */
@TableName("sijiaokechengxinxi")
public class SijiaokechengxinxiView extends SijiaokechengxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public SijiaokechengxinxiView() {

	}
	private String jlname;

	public String getJlname() {
		return jlname;
	}

	public void setJlname(String jlname) {
		this.jlname = jlname;
	}

	public SijiaokechengxinxiView(SijiaokechengxinxiEntity sijiaokechengxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, sijiaokechengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

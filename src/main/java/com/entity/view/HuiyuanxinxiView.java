package com.entity.view;

import com.entity.HuiyuanxinxiEntity;

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
@TableName("huiyuanxinxi")
public class HuiyuanxinxiView extends HuiyuanxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	/**
	 * 会员卡名称
	 */
	private String hykname;

	public HuiyuanxinxiView() {

	}

	public String getHykname() {
		return hykname;
	}

	public void setHykname(String hykname) {
		this.hykname = hykname;
	}

	public HuiyuanxinxiView(HuiyuanxinxiEntity huiyuanxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, huiyuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

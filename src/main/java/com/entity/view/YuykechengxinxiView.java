package com.entity.view;

import com.entity.YuykechengxinxiEntity;

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
@TableName("yuykechengxinxi")
public class YuykechengxinxiView extends YuykechengxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public YuykechengxinxiView() {

	}
	private String hyname;
	private String sjname;

	public String getHyname() {
		return hyname;
	}

	public void setHyname(String hyname) {
		this.hyname = hyname;
	}

	public String getSjname() {
		return sjname;
	}

	public void setSjname(String sjname) {
		this.sjname = sjname;
	}

	public YuykechengxinxiView(YuykechengxinxiEntity yuykechengxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, yuykechengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

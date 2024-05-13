package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @author 
 * @email
 * @date 2021-01-26
 */
@TableName("jianshenfangxinxi")
public class JianshenfangxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianshenfangxinxiEntity() {

	}

	public JianshenfangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     * 健身区域名称
     */
    private String jsfname;


    /**
     * 健身房信息
     */
    private String jsfmessage;


    /**
     * 健身房图片 
     */
    private String jsfPhoto;


    /**
     * 负责教练
     */
    private Integer jlidTypes;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：健身区域名称
	 */
    public String getJsfname() {
        return jsfname;
    }


    /**
	 * 获取：健身区域名称
	 */

    public void setJsfname(String jsfname) {
        this.jsfname = jsfname;
    }
    /**
	 * 设置：健身房信息
	 */
    public String getJsfmessage() {
        return jsfmessage;
    }


    /**
	 * 获取：健身房信息
	 */

    public void setJsfmessage(String jsfmessage) {
        this.jsfmessage = jsfmessage;
    }
    /**
	 * 设置：健身房图片 
	 */
    public String getJsfPhoto() {
        return jsfPhoto;
    }


    /**
	 * 获取：健身房图片 
	 */

    public void setJsfPhoto(String jsfPhoto) {
        this.jsfPhoto = jsfPhoto;
    }
    /**
	 * 设置：负责教练
	 */
    public Integer getJlidTypes() {
        return jlidTypes;
    }


    /**
	 * 获取：负责教练
	 */

    public void setJlidTypes(Integer jlidTypes) {
        this.jlidTypes = jlidTypes;
    }

}

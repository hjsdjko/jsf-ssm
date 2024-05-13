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
@TableName("sijiaokechengxinxi")
public class SijiaokechengxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SijiaokechengxinxiEntity() {

	}

	public SijiaokechengxinxiEntity(T t) {
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
     * 私教名称
     */
    private String sjname;


    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat
    private Date courseTime;
    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 教程介绍
     */
    private String message;


    /**
     * 费用
     */
    private Double cost;


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
	 * 设置：私教名称
	 */
    public String getSjname() {
        return sjname;
    }


    /**
	 * 获取：私教名称
	 */

    public void setSjname(String sjname) {
        this.sjname = sjname;
    }
    /**
	 * 设置：课程时间
	 */
    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
	 * 设置：费用
	 */
    public Double getCost() {
        return cost;
    }

    public Date getJieshuTime() {
        return jieshuTime;
    }

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }

    /**
	 * 获取：费用
	 */

    public void setCost(Double cost) {
        this.cost = cost;
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

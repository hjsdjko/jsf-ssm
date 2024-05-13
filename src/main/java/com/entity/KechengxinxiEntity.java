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
@TableName("kechengxinxi")
public class KechengxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KechengxinxiEntity() {

	}

	public KechengxinxiEntity(T t) {
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
     * 星期日期（星期1-星期天）
     */
    private String weekTypes;


    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
    @DateTimeFormat
    private Date times1;

    /**
     * 课程时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
    @DateTimeFormat
    private Date times2;


    /**
     * 课程内容
     */
    private String kcname;


    /**
     * 课程信息
     */
    private String message;


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
	 * 设置：星期日期（星期1-星期天）
	 */
    public String getWeekTypes() {
        return weekTypes;
    }


    /**
	 * 获取：星期日期（星期1-星期天）
	 */

    public void setWeekTypes(String weekTypes) {
        this.weekTypes = weekTypes;
    }

    public Date getTimes1() {
        return times1;
    }

    public void setTimes1(Date times1) {
        this.times1 = times1;
    }

    public Date getTimes2() {
        return times2;
    }

    public void setTimes2(Date times2) {
        this.times2 = times2;
    }

    /**
	 * 设置：课程内容
	 */
    public String getKcname() {
        return kcname;
    }


    /**
	 * 获取：课程内容
	 */

    public void setKcname(String kcname) {
        this.kcname = kcname;
    }
    /**
	 * 设置：课程信息
	 */
    public String getMessage() {
        return message;
    }


    /**
	 * 获取：课程信息
	 */

    public void setMessage(String message) {
        this.message = message;
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

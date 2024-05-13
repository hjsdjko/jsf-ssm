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
 * @date 2021-01-28
 */
@TableName("yuykechengxinxi")
public class YuykechengxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuykechengxinxiEntity() {

	}

	public YuykechengxinxiEntity(T t) {
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
     * 预约的私教课程
     */
    @TableField("sjidTypes")
    private Integer sjidTypes;


    /**
     * 会员id
     */
    @TableField("hyidTypes")
    private Integer hyidTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 设置：预约的私教课程
	 */
    public Integer getSjidTypes() {
        return sjidTypes;
    }


    /**
	 * 获取：预约的私教课程
	 */

    public void setSjidTypes(Integer sjidTypes) {
        this.sjidTypes = sjidTypes;
    }
    /**
	 * 设置：会员id
	 */
    public Integer getHyidTypes() {
        return hyidTypes;
    }


    /**
	 * 获取：会员id
	 */

    public void setHyidTypes(Integer hyidTypes) {
        this.hyidTypes = hyidTypes;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

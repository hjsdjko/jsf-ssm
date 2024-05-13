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
@TableName("huiyuankaxinxi")
public class HuiyuankaxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuiyuankaxinxiEntity() {

	}

	public HuiyuankaxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     * 用户id
     */
    private Integer hyidTypes;


    /**
     * 会员卡类型
     */
    private Integer huTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
     * 到期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date expireTime;


    /**
	 * 设置：
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getHyidTypes() {
        return hyidTypes;
    }


    /**
	 * 获取：用户id
	 */

    public void setHyidTypes(Integer hyidTypes) {
        this.hyidTypes = hyidTypes;
    }
    /**
	 * 设置：会员卡类型
	 */
    public Integer getHuTypes() {
        return huTypes;
    }


    /**
	 * 获取：会员卡类型
	 */

    public void setHuTypes(Integer huTypes) {
        this.huTypes = huTypes;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：到期时间
	 */
    public Date getExpireTime() {
        return expireTime;
    }


    /**
	 * 获取：到期时间
	 */

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

}

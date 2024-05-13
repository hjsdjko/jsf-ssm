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
@TableName("huiyuankaleixing")
public class HuiyuankaleixingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuiyuankaleixingEntity() {

	}

	public HuiyuankaleixingEntity(T t) {
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
     * 会员卡名称
     */
    private String hykname;


    /**
     * 费用
     */
    private Double cost;


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
	 * 设置：会员卡名称
	 */
    public String getHykname() {
        return hykname;
    }


    /**
	 * 获取：会员卡名称
	 */

    public void setHykname(String hykname) {
        this.hykname = hykname;
    }
    /**
	 * 设置：费用
	 */
    public Double getCost() {
        return cost;
    }


    /**
	 * 获取：费用
	 */

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
